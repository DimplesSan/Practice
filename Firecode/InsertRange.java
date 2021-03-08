// [[1,2], [3,5], [6,7], [8,10], [12,14]], Interval: [5,9]
// [[1,2], [3,10], [12,14]]
//
// [[0,5]], Interval: [1,2]
// [[0,5]]
//
// [[1,2]], Interval: [0,5]
// [[0,5]]
//
// [[-10,-5], [0,10]], Interval: [-2,-1]
// [[0,1], [2,10]]
//
// [[0,1], [4,5]], Interval: [2,3]
// [[0,1], [2,3], [4,5]] - [[0,1]. [4,5]]
//
// [], Interval: [1,2]
// [[1,2]]
//
// [[1,4], [7,9]], Interval: [2,6]
// [[1,6], [7,9]]

public static ArrayList<Interval> insertRange(ArrayList<Interval> intervalsList, Interval insert) {
    if(insert == null) return intervalsList;

    ArrayList<Interval> mergedIntervals = new ArrayList<Interval>();
    if(intervalsList == null || intervalsList.size() == 0) { mergedIntervals.add(insert); return mergedIntervals; }
    
    int i = 0;
    Interval current = insert;
    boolean isInserted = false;
    while(i<intervalsList.size()) {
        
        if(doesRangeOverlap(intervalsList.get(i), current)) {
            current = mergeIntervals(intervalsList.get(i), current);
            isInserted = true;
        } else {
            if(isInserted || rangePast(intervalsList.get(i), current) ) {
                mergedIntervals.add(current);
                isInserted = false;
            }    
            mergedIntervals.add(intervalsList.get(i));
        }
    
        i++; 
    }
    
    if(isInserted) mergedIntervals.add(current);
    
    return mergedIntervals;
}

public static boolean rangePast(Interval a, Interval b) {
    if(a.start > b.end ) return true;
    return false;
}

public static Interval mergeIntervals(Interval a, Interval b) {
    int newStart = a.start <= b.start ? a.start : b.start;
    int newEnd = a.end >= b.end ? a.end : b.end;

    return new Interval(newStart, newEnd);
}

public static boolean doesRangeOverlap(Interval a, Interval b){
    //3 types of overlap
        // a completely encompasses b
        if(b.start >= a.start && b.end <= a.end) return true;
        // b completely encompasses a
        if(a.start >= b.start && a.end <= b.end) return true;
        // partial overlap
        if(a.start <= b.start && a.end >= b.start) return true;
        if(b.start <= a.start && b.end >= a.start) return true;

    return false;
}
