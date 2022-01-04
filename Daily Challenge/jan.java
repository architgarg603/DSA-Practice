class jan {

    public int findJudge(int n, int[][] arr) {
        int[] freq = new int[n+1];
        int[] freqCnt = new int[n+1];
        for(int i=0;i<arr.length;i++){
            freq[arr[i][0]] = 1;
            freqCnt[arr[i][1]] += 1;
        }
        
        for(int i=1;i<n+1;i++){
            System.out.println(freq[i]);
            if(freq[i]==0 && freqCnt[i] == n-1)return i;
        }
        
        return -1;
    }
    // ===========================leetcode 1009
     public int bitwiseComplement(int n) {
               
        int i = 1;
        
        while(i<n){
            i = i*2 + 1;
        }
        
        return i-n;
    }

}