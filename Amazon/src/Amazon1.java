import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class App {
	int id;
	int time;

}

public class Amazon1 {
	List<List<Integer>> optimalUtilization(int deviceCapacity, List<List<Integer>> foregroundAppList,
			List<List<Integer>> backgroundAppList) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<App> forg = new ArrayList<App>();
		if (deviceCapacity == 0 || foregroundAppList == null || foregroundAppList.size() == 0
				|| backgroundAppList == null || backgroundAppList.size() == 0)
			return res;
		for (int i = 0; i < foregroundAppList.size(); i++) {
			App a = new App();
			a.id = foregroundAppList.get(i).get(0);
			a.time = foregroundAppList.get(i).get(1);
			forg.add(a);
		}
		List<App> back = new ArrayList<App>();

		for (int i = 0; i < backgroundAppList.size(); i++) {
			App a = new App();
			a.id = backgroundAppList.get(i).get(0);
			a.time = backgroundAppList.get(i).get(1);
			back.add(a);
		}
		Collections.sort(back, new Comparator<App>() {
			public int compare(App o1, App o2) {
				return o1.time - o2.time;
			}
		});
		App ft = new App();
		int remCap, closest, maxTill = Integer.MIN_VALUE;

		for (int i = 0; i < forg.size(); i++) {
			ft = forg.get(i);
			remCap = deviceCapacity - ft.time;
			App cls = findClosest(back, remCap);
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(ft.id);
			temp.add(cls.id);
			closest = ft.time + cls.time;
			if (closest > maxTill && closest <= deviceCapacity) {
				res.clear();
				res.add(temp);
				maxTill = closest;
			} else if (closest == maxTill) {
				res.add(temp);
			}
		}
		return res;
	}

	public App findClosest(List<App> back, int target) {
		int n = back.size();

		if (target <= back.get(0).time)
			return back.get(0);
		if (target >= back.get(n - 1).time)
			return back.get(n - 1);

		int i = 0, j = n, mid = 0;
		while (i < j) {
			mid = (i + j) / 2;

			if (back.get(mid).time == target)
				return back.get(mid);

			if (target < back.get(mid).time) {

				if (mid > 0 && target > back.get(mid - 1).time)
					return getClosest(back.get(mid - 1), back.get(mid), target);
				j = mid;
			}

			else {
				if (mid < n - 1 && target < back.get(mid + 1).time)
					return getClosest(back.get(mid), back.get(mid + 1), target);
				i = mid + 1;
			}
		}

		return back.get(mid);
	}

	public App getClosest(App val1, App val2, int target) {
		if (target - val1.time >= val2.time - target)
			return val2;
		else
			return val1;
	}
}