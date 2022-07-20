class Solution {
    public int nextGreaterElement(int s) {
        String str = ""+s;
        char[] arr = str.toCharArray();
        int n = arr.length;
        int i = n-2;
        
        while(i>=0 && arr[i]>=arr[i+1])i--;
        
        if(i == -1)return -1;
        
        int x = n-1;
        while(arr[x] <= arr[i])x--;
        char temp = arr[i];
        arr[i] = arr[x];
        arr[x] = temp;
        
        
        int y = n-1;
        x = i+1;
        while(x < y){
            temp = arr[y];
            arr[y] = arr[x];
            arr[x] = temp;
            x++;
            y--;

        }
        
        long ans = 0;
        
        for(i=0;i<n;i++) ans = (ans*10) + (arr[i] - '0');
        
        
        return ans <= Integer.MAX_VALUE ? (int)ans : -1;
    }
}