class WordFilter {
    
    class Node{
        Node[] child;
        HashSet<String> words;
        
        Node(){
            words = new HashSet<>();
            child = new Node[256];
        }
    }
    
    Node pre,suf;
    HashMap<String, Integer> idx ;

    public WordFilter(String[] words) {
        pre = new Node();
        suf = new Node();
        idx = new HashMap<>();
        
        for(int i=0;i<words.length;i++){
            insert(words[i]);
            idx.put(words[i],i);
        }       
        
    }
    
    
    public void insert(String str){
        Node p = pre;
        Node s = suf;
        
        for(int i=0;i<str.length();i++){
            char ch1 = str.charAt(i) ;
            char ch2 = str.charAt(str.length() - i - 1) ;
            
            if(p.child[ch1] == null)
                p.child[ch1] = new Node();
            p = p.child[ch1];
            p.words.add(str);
            
            if(s.child[ch2] == null)
                s.child[ch2] = new Node();
            s = s.child[ch2];
            s.words.add(str);
        }
    }
    
    public int f(String pre, String suf) {
        Node p = this.pre;
        Node s = this.suf;
        
        for(int i=0;i<pre.length();i++){
            if(p.child[pre.charAt(i)] == null)return -1;
            p  = p.child[pre.charAt(i)];
        }
        
        Set<String> preWords = p.words;
        
        for(int i=0;i<suf.length();i++){
            if(s.child[suf.charAt(suf.length() - 1 - i)] == null)return -1;
            s  = s.child[suf.charAt(suf.length() - 1 - i)];
        }
        
        Set<String> sufWords = s.words;
        
        int ans =-1;
        // System.out.println()
        for(String str : preWords){
            if(sufWords.contains(str)){
                ans = Math.max(ans, idx.get(str));
            }
        }
        
        return ans;
        
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */