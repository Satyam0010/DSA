public class Solution {
    public List<String> braceExpansionII(String expression) {
        Stack<Object> stack = new Stack<>();
        List<List<String>> currentGroups = new ArrayList<>();
        currentGroups.add(new ArrayList<>(Arrays.asList("")));
        
        int i = 0;
        while (i < expression.length()) {
            char ch = expression.charAt(i);
            
            if (ch == '{') {
                stack.push(currentGroups);
                currentGroups = new ArrayList<>();
                currentGroups.add(new ArrayList<>(Arrays.asList("")));
                i++;
            } else if (ch == '}') {
                List<String> combinedCurrent = flattenGroups(currentGroups);
                @SuppressWarnings("unchecked")
                List<List<String>> previousGroups = (List<List<String>>) stack.pop();
                
                List<String> lastGroup = previousGroups.get(previousGroups.size() - 1);
                previousGroups.set(previousGroups.size() - 1, mergeProduct(lastGroup, combinedCurrent));
                
                currentGroups = previousGroups;
                i++;
            } else if (ch == ',') {
                currentGroups.add(new ArrayList<>(Arrays.asList("")));
                i++;
            } else {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && Character.isLowerCase(expression.charAt(i))) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                String word = sb.toString();
                
                List<String> lastGroup = currentGroups.get(currentGroups.size() - 1);
                currentGroups.set(currentGroups.size() - 1, mergeProduct(lastGroup, Arrays.asList(word)));
            }
        }
        
        List<String> flatResult = flattenGroups(currentGroups);
        Set<String> uniqueSortedSet = new TreeSet<>(flatResult);
        return new ArrayList<>(uniqueSortedSet);
    }
    
    private List<String> mergeProduct(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<>();
        for (String s1 : list1) {
            for (String s2 : list2) {
                result.add(s1 + s2);
            }
        }
        return result;
    }
    
    private List<String> flattenGroups(List<List<String>> groups) {
        List<String> result = new ArrayList<>();
        for (List<String> group : groups) {
            result.addAll(group);
        }
        return result;
    }
}
