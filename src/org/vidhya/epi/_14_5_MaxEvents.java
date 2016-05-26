package org.vidhya.epi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _14_5_MaxEvents {

	private class Interval {
		private int start;
		private int end;
		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	private class Point implements Comparable<Point>{
		private int val; 
		private boolean start;
		
		Point(int val, boolean start) {
			this.val = val;
			this.start = start;
		}
		
		boolean isStart() {
			return start;
		}
		/*
		 * if val is same, start point comes first. if both are start or end, break ties arbitrarily. Why needed/? 
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		public int compareTo(Point o) {
			/*if (val == o.val) 
			{
				if (start && !(o.isStart())) {
					return -1;
				} 
				else if (!start && (o.isStart())){
					return 1;
				}
			}*/
			return (val - o.val);
		}
	}
	/**
	 * @return
	 */
	private List<Interval> getListofIntervals() {
		List<Interval> li = new ArrayList<Interval>();
		li.add(new Interval(1,5));
		li.add(new Interval(6,10));
		li.add(new Interval(11,13));
		li.add(new Interval(13,14));
		li.add(new Interval(14,15));
		li.add(new Interval(2,7));
		li.add(new Interval(8,9));
		li.add(new Interval(12,15));
		li.add(new Interval(4,5));
		li.add(new Interval(9,17));
		return li;
	}
	 
	public int findMaxNoOfEvents(List<Interval> input) {
		int max_count= Integer.MIN_VALUE;
		int num_int = input.size();
		Point points[] = new Point[num_int*2];
		int i = 0;
		for (Interval interval : input) {
			points[i++] = new Point(interval.start, true);
			points[i++] = new Point(interval.end, false);
		}
		Arrays.sort(points);
		int count = 0;
		for (Point p: points) {
			// this is a start of an interval, increment count. like pushing to stack, keep count of max element in stack or count. 
			if (p.isStart()) {
				count++;
				max_count = Math.max(count, max_count);
			}
			// this is an end of an interval, decrement count. like pop from stack. 
			else {
				count--;
			}
		}		
		
		return max_count;		
	}
	public static void main(String args[]) {
		_14_5_MaxEvents mc = new _14_5_MaxEvents();	
		
		System.out.println(mc.findMaxNoOfEvents(mc.getListofIntervals()));;
	}
}
