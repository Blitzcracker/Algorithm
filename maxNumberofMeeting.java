public int findMaxMeetings(Interval[] intervals){
	Arrays.sort(new Comparator<Interval>(){
		public int compare(Interval a, Interval b){
			return a.start - b.start;
		}
	});

	return helper(intervals, 0);	

}

public int helper(Interval[] intervals, int start){
	if(start == intervals.length - 1)
		return 1;
	if(intervals[start + 1].start >= intervals[start].end)
		return 1 + helper(intervals, start + 1);
	else{
		int max = 1;
		int i = start + 1;
		while(i < intervals.length && intervals[i].start < intervals[start].end){	//find the next nonoverlapping interval
			max = Math.max(max, helper(intervals, i));	// meanwhile trigger search from each overlapped interval as start
		}
		max = Math.max(max, 1 + (i < intervals.length ? helper(intervals, i) : 0));
	}
	return max;
}