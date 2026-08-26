class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> q = new PriorityQueue<>((a,b)-> Integer.compare(map.get(b),map.get(a)));
        q.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char c = q.poll();
            int j = map.get(c);
            while(j > 0){
                sb.append(c);
                j--;
            }
        }
        return sb.toString();
    }
}