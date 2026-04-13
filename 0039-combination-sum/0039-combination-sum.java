class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0,candidates,target,new ArrayList<>(),ans);
        return ans;
    }

    private void backtrack(int i , int[] arr, int target,List<Integer> current, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(current));
            return;
        }

        if(i == arr.length || target < 0) return;


        current.add(arr[i]);
        backtrack(i,arr,target-arr[i],current,ans);
        current.remove(current.size()-1);
        backtrack(i+1,arr,target,current,ans);
    }
}