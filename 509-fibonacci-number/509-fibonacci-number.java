class Solution {
    public int fib(int n) {
        if(n<2)return n;
        int a = 0,b=1;
        for(int i=0;i<n;i++){
            int c = a+b;
            a = b;
            b = c;
        }
        
        return a;
    }
}