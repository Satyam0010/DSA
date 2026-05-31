class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for(int ass: asteroids){
            if(m < ass) return false;
            m += ass;
        } return true;
    }
}