class MyCalendarTwo {
    private TreeMap<Integer,Integer> calendar;
    public MyCalendarTwo() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        calendar.put(startTime,calendar.getOrDefault(startTime,0)+1);
        calendar.put(endTime,calendar.getOrDefault(endTime,0)-1);
        int active = 0;
        for(int event : calendar.values()){
            active += event;
            if(active > 2){
                calendar.put(startTime,calendar.getOrDefault(startTime,0)-1);
                calendar.put(endTime,calendar.getOrDefault(endTime,0)+1);
                if(calendar.get(startTime) == 0) calendar.remove(startTime);
                if(calendar.get(endTime) == 0) calendar.remove(endTime);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */