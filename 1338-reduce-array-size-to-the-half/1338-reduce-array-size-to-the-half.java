class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : arr)
            map.put(x, map.getOrDefault(x,0)+1);
        
        ArrayList<Integer> a = new ArrayList<>();
        for(int k : map.keySet()){
            a.add(map.get(k));
        }
        
        Collections.sort(a);
        
        int ans = 0;
        int size = (arr.length + 1) / 2 ;
        int i = a.size()-1 ;
        while(size >0 && i>=0){
            size -= a.get(i);
            i--;
            ans++;
        }
        
        return ans;
        
    }
}