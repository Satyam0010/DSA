class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        return check(endTime) - check(startTime);
    }
    private int check(String s){
        String[] ss = s.split(":");
        int hour = Integer.parseInt(ss[0]);
        int min = Integer.parseInt(ss[1]);
        int sec = Integer.parseInt(ss[2]);
        return hour*3600 + min*60 + sec;
    }
}