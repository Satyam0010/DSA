class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtracking(0,candidates,target,new ArrayList<>(),res);
        return res;
    }

    private void backtracking(int i,int[] arr,int target,List<Integer> current,List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(current));
            return ;
        }


        for(int j = i; j < arr.length ;j++){

            if(j > i && arr[j] == arr[j-1]) continue;

            if(arr[j]>target) break;

            current.add(arr[j]);
            backtracking(j+1,arr,target-arr[j],current,res);
            current.remove(current.size()-1);
        }
    }
}