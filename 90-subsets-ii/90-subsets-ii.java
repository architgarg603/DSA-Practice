class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums,0,ans, temp);
        return ans;
    }
    
    public void solve(int[] arr, int idx, List<List<Integer>> ans,List<Integer> temp){
        
        
        ans.add(new ArrayList<>(temp));
        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i] == arr[i-1])continue;
            temp.add(arr[i]);
            solve(arr,i+1,ans,temp);
            temp.remove(temp.size()-1);
        }
        
    }
    
}