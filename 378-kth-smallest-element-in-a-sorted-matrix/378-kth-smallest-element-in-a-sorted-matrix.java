class Solution {
    public int kthSmallest(int[][] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return arr[a[0]][a[1]] - arr[b[0]][b[1]];
        });
        int n = arr.length, m = arr[0].length;
        for(int i=0;i<n;i++)
            pq.add(new int[]{i,0});
        
        while(pq.size()>0 && k-->1){
            int[] curr = pq.remove();
            if(curr[1]<n-1){
                curr[1]++;
                pq.add(curr);
            }
        }
        int[] a = pq.remove();
        return arr[a[0]][a[1]];
    }
}