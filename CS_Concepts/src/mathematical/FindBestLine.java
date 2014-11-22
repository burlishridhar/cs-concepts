package mathematical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindBestLine {

	public static void main(String[] args) {
			FindBestLine f = new FindBestLine();
			List<Point_ID1> points = new ArrayList<Point_ID1>();
			points.add(new Point_ID1(1, 2));
			points.add(new Point_ID1(2, 5));
			points.add(new Point_ID1(3, 4));
			points.add(new Point_ID1(1, 3));
			points.add(new Point_ID1(4, 2));
			
			Line_ID1 bestLine = f.findBestLine(points);
			System.out.println(bestLine.slope);
			System.out.println(bestLine.intercept);
			System.out.println(bestLine.infinite_slope);
	}
	
	public Line_ID1 findBestLine(List<Point_ID1> points){
		Line_ID1 bestLine = null;
		Map<Line_ID1, Integer> line_count = new HashMap<Line_ID1,Integer>();
		for(int i=0; i<points.size(); i++){
				for(int j=i+1;j<points.size();j++){
						Line_ID1 l = new Line_ID1(points.get(i), points.get(j));
						if(!line_count.containsKey(l))
									line_count.put(l, 0);
						line_count.put(l, line_count.get(l)+1);
						if(bestLine==null||
								line_count.get(bestLine)<line_count.get(l))
								bestLine = l;
				}
		}
		return bestLine;
	}

}

class Point_ID1{
	int x, y;

	public Point_ID1(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

class Line_ID1{
	double slope, intercept; boolean infinite_slope = false;
	
	Line_ID1(Point_ID1 p1, Point_ID1 p2){
		if(p1.x==p2.x){
				infinite_slope=true; intercept = p1.x;
		}else{
				slope = (p1.y-p2.y)/(p1.x-p2.x);
				intercept = p1.y - slope * p1.x;
		}
	}

	
	@Override
	public int hashCode() {
		return (int) (slope * 1000) | (int) (intercept * 1000);
	}

	@Override
	public boolean equals(Object obj) {
		Line_ID1 l = (Line_ID1) obj;
		if(l.slope==this.slope && l.intercept==this.intercept 
				&& l.infinite_slope==this.infinite_slope){
				return true;
		}
		return false;
	}
	
}