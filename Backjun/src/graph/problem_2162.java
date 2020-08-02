package graph;

//선분 그룹
import java.util.*;
import java.io.*;

public class problem_2162 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Point> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			double x1 = Double.parseDouble(st.nextToken());
			double y1 = Double.parseDouble(st.nextToken());
			double x2 = Double.parseDouble(st.nextToken());
			double y2 = Double.parseDouble(st.nextToken());

			list.add(new Point(x1, y1, x2, y2));
		}

		simulation(list);
	}

	private static void simulation(List<Point> list) {
		List<List<Point>> point_group = new ArrayList<>();

		for (Point p : list) {
			if (point_group.isEmpty()) {
				List<Point> temp = new ArrayList<>();
				temp.add(p);
				point_group.add(temp);
			} else {
				List<List<Point>> delete_list = new ArrayList<>();
				List<Point> temp = new ArrayList<>();
				
				for (List<Point> point_list : point_group) {
					if (isSameGroup(point_list, p)) {
						temp.addAll(point_list);
						delete_list.add(point_list);
					}
				}
				
				for (List<Point> l : delete_list) {
					point_group.remove(l);
				}

				temp.add(p);
				point_group.add(temp);
			}
		}

		System.out.println(point_group.size());
		int big = 0;
		for (List<Point> p : point_group) {
			big = Math.max(big, p.size());
		}
		System.out.println(big);
	}

	private static boolean isSameGroup(List<Point> list, Point p) {
		for (Point pl : list) {
			double ccw1 = ccw(pl.x1, pl.y1, pl.x2, pl.y2, p.x1, p.y1);
			double ccw2 = ccw(pl.x1, pl.y1, pl.x2, pl.y2, p.x2, p.y2);

			double ccw3 = ccw(p.x1, p.y1, p.x2, p.y2, pl.x1, pl.y1);
			double ccw4 = ccw(p.x1, p.y1, p.x2, p.y2, pl.x2, pl.y2);

			double c_12 = ccw1 * ccw2;
			double c_34 = ccw3 * ccw4;

			if (c_12 == 0 && c_34 == 0) {
				//선분이 서로 평행할 경우, 무조껀 교차를 안한다고 판정해버리면 안된다.
				if(isOverlap(pl,p))
					return true;
			}else if (c_12 <= 0 && c_34 <= 0)
				return true;
		}

		return false;
	}

	private static boolean isOverlap(Point pl, Point p) {
		if (Math.max(p.x1, p.x2) < Math.min(pl.x1, pl.x2))
			return false;
		if (Math.max(pl.x1, pl.x2) < Math.min(p.x1, p.x2))
			return false;

		if (Math.max(pl.y1, pl.y2) < Math.min(p.y1, p.y2))
			return false;
		if (Math.max(p.y1, p.y2) < Math.min(pl.y1, pl.y2))
			return false;

		return true;
	}

	private static double ccw(double x1, double y1, double x2, double y2, double x3, double y3) {
		double result = 0.0;
		result = x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1;

		return result;
	}

	private static class Point {
		double x1, x2;
		double y1, y2;

		public Point(double x1, double y1, double x2, double y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
}
