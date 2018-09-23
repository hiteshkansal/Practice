package com.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class FileReaderTest {

	final static String fieldsArray[] = { "Attachments", "Details", "Frequency", "Time Lost", "Raised on behalf of",
			"Team Manager's LAN ID", "CRM LAN ID", "Fuel", "Location", "Customer Contact number", "Agent User ID",
			"Computer Name", "Date of Issue", "Time of Issue", "Agent Extension number", "Browser Name",
			"Browser Version","CEAR NO","Team Manager","Site","AccountNumber","System","Layer1","Layer2","Layer3","Suppoert type","Route Cause","Outecome","IR Number"
			 ,"Issue highlighted previosuly?","How many occassions","Assistance Required Y/N","Total time taken","Comments","Email Date"
			 ,"Duty_Worked","Form_Number","Day"};

	private static FileOutputStream fos;
	private static HSSFWorkbook workbook;
	private static HSSFSheet worksheet;
	// private static HSSFRow row;
	private static int rowNum = 0;

	public static void main(String[] args) throws MessagingException, IOException {

		FileReaderTest fileReader = new FileReaderTest();

		workbook = new HSSFWorkbook();
		worksheet = workbook.createSheet("My Worksheet");

		/*worksheet.setColumnWidth(0, 5000);
		worksheet.setColumnWidth(1, 5000);
*/
		HSSFCellStyle cellStyle = workbook.createCellStyle();

		HSSFFont font = workbook.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setFontHeightInPoints((short) 10);
		font.setBold(true);
		cellStyle.setFont(font);
		cellStyle.setWrapText(true);
		HSSFRow headerRow = worksheet.createRow(rowNum++);

		int k = 0;
		for (String headers : fieldsArray) {
			Cell cellHeader = headerRow.createCell(k++);
			cellHeader.setCellValue(headers);
			cellHeader.setCellStyle(cellStyle);
		}

		File folder = new File("C:\\Users\\Hitesh\\Desktop\\Ridhi\\Files");

		for (File fileEntry : folder.listFiles()) {
			// System.out.println(fileEntry.getName());

			Properties props = System.getProperties();
			props.put("mail.host", "smtp.dfenergy.com");
			props.put("mail.transport.protocol", "smtp");

			Session mailSession = Session.getDefaultInstance(props, null);
			InputStream source = new FileInputStream(fileEntry.getAbsolutePath());
			MimeMessage message = new MimeMessage(mailSession, source);

			 System.out.println("Subject : " + message.getSubject());
			// System.out.println("From : " + message.getFrom()[0]);
			 System.out.println("Body : " + message.getContent());

			// System.out.println(fileReader.getFinalContent(message));
			fileReader.getFinalContent(message);
			// System.out.println("--------------------------------------------------------");

		}

	}

	private String getFinalContent(MimeMessage p) throws MessagingException, IOException {

		String finalContents = "";
		if (p.getContent() instanceof String) {
			finalContents = (String) p.getContent();
		} else {
			Multipart mp = (Multipart) p.getContent();
			if (mp.getCount() > 0) {
				Part bp = mp.getBodyPart(0);
				try {
					finalContents = dumpPart(bp);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return finalContents.trim();
	}

	private String dumpPart(Part p) throws Exception {

		fos = new FileOutputStream("C:\\Users\\Hitesh\\Desktop\\Ridhi\\data2excel.xls");
		InputStream is = p.getInputStream();
		if (!(is instanceof BufferedInputStream)) {
			is = new BufferedInputStream(is);
		}
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String line;
		int i = -1, j = 2, colNum = 0;
		HSSFRow row = worksheet.createRow(rowNum++);

		boolean flag = true;
		try {
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				i++;
				if (i == 0) {
					System.out.println("Line: "+line);
					Cell cell = row.createCell(colNum++);
					cell.setCellValue(line);
					continue;
				}
				if ((!line.toLowerCase().contains("Frequency".toLowerCase())) && flag) {
					if (!line.isEmpty()) {
						sb.append(line);
						sb.append(". ");
					}
					continue;
				}

				if (line.toLowerCase().contains("Frequency".toLowerCase())) {
					flag = false;
					Cell cell = row.createCell(colNum++);
					cell.setCellValue(sb.toString());
				}

				if (line.toLowerCase().contains(fieldsArray[j].toLowerCase())) {
					Cell cell = row.createCell(colNum++);
					cell.setCellValue(line.replaceFirst(fieldsArray[j], "").trim());
					j++;
				}
			}
			workbook.write(fos);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
					fos.flush();
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
}
