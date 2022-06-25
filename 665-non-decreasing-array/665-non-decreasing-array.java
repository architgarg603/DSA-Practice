class Solution {
        public boolean checkPossibility(int[] arr) {
        int cnt =0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1] && cnt==0){
                cnt++;
                if(i>0 && arr[i-1]>arr[i+1]){
                    arr[i+1] = arr[i];
                }else{
                    arr [i]= arr[i+1];
                }
            }else if(cnt==1 && (arr[i]>arr[i+1]) ){
                return false;
            }
        }
        
            return true;
    
    }
}