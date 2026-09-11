class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int i = 0;
        for(char c : senate.toCharArray()){
            if(c == 'R') radiant.offer(i++);
            else dire.offer(i++);
        }
        while(!radiant.isEmpty() && !dire.isEmpty()){
            if(dire.peek() > radiant.peek()) radiant.offer(i++);
            else dire.offer(i++);
            radiant.poll();
            dire.poll();
        }
        return dire.isEmpty() ? "Radiant" : "Dire";
    }
}