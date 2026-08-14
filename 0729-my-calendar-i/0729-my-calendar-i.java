class MyCalendar {
    private TreeMap<Integer,Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        Integer prevEvent = calendar.floorKey(startTime);
        if(prevEvent != null && calendar.get(prevEvent) > startTime) return false;
        Integer nextEvent = calendar.ceilingKey(startTime);
        if(nextEvent != null && nextEvent < endTime) return false;
        calendar.put(startTime,endTime);
        return true; 
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */