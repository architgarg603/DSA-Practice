class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if(n == 0)return ans;
        
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        ans.add(temp);
        
        for(int i=1;i<n;i++){
            temp = new ArrayList<>();
            temp.add(1);
            for(int j=1;j<i;j++){
                temp.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));   
            }
            temp.add(1);
            ans.add(temp);
        }
        
        return ans;
    }
}