class Solution {
    public int solve(int n){
        int ans =0;
        while(n!=0){
            int rem = n%10;
            ans += (rem*rem);
            n=n/10;
            
        }
        return ans;
    }
    public boolean isHappy(int n) {
        
        HashSet<Integer>set = new HashSet<>();
        
        while(true){
            int newNumber = solve(n);
            if(newNumber==1){
                return true;
            }
            if(set.contains(newNumber)){
                return false;
            }
            set.add(newNumber);
            n = newNumber;
            
            
        }
        
        
    }
}