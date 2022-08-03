class MyCalendar {
    TreeSet<int[]> map;
    public MyCalendar() {
           map  = new TreeSet<>((a,b)->a[0]-b[0]);
    }
    
    public boolean book(int start, int end) {
        int[] arr = new int[]{start,end};
        int[] x = map.floor(arr);
        int[] y = map.ceiling(arr);
        // System.out.println(Arrays.toString(x));
        // System.out.println(Arrays.toString(y));
        // System.out.println("...............................");
        if(x != null && (x[0]== start || x[1] >start) )return false;
        if(y != null && y[0]<end)return false;
        map.add(arr);
        return true;
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */