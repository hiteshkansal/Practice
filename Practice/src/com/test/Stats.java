package com.test;

import java.util.*;
import java.util.concurrent.*;

public class Stats {

    public static class StockDetail{
        private String symbol;
        private int tickCount;
        private double totalPrice;
        
        public void setSymbol(String symbol){
            this.symbol = symbol;
        }
        
        public String getSymbol(){
            return symbol;
        }
        
        public void setTickCount(int tickCount){
            this.tickCount = tickCount;
        }
        
        public int getTickCount(){
            return tickCount;
        }
        
        public void setTotalPrice(double totalPrice){
            this.totalPrice = totalPrice;
        }
        
        public double getTotalPrice(){
            return totalPrice;
        }
    }
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {

        Map<String,StockDetail> stock = new HashMap<String, StockDetail>();
        
		@Override
		public void putNewPrice(String symbol, double price) {
		    StockDetail temp = stock.get(symbol);
		    if(temp!=null){
		        temp.setTotalPrice(temp.getTotalPrice()+price);
		        temp.setTickCount(temp.getTickCount()+1);
		        stock.put(symbol, temp);
		    }
		    else{
		    	temp = new StockDetail();
		        temp.setTotalPrice(price);
		        temp.setTickCount(1);
		        stock.put(symbol, temp);
		    }
		}

		@Override
		public double getAveragePrice(String symbol) {
    		StockDetail temp = stock.get(symbol);
    		return temp.getTotalPrice()/temp.getTickCount();
		}

		@Override
		public int getTickCount(String symbol) {
    		StockDetail temp = stock.get(symbol);
    		return temp.getTickCount();
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(String.format("%s %.4f %d", symbol,
						stats.getAveragePrice(symbol),
						stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
}