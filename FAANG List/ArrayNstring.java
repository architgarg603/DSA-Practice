// leetcode 925

class ArrayNstring {

    public boolean isLongPressedName(String s, String t) {
        int i = 0, j = 0, ns = s.length(), nt = t.length();
        if (nt < ns)
            return false;
        while (i < ns && j < nt) {

            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else if (i > 0 && s.charAt(i - 1) == t.charAt(j)) {
                j++;
            } else {
                // System.out.println(i+" "+j);
                return false;
            }

        }
        if (i < ns)
            return false;
        while (j < nt) {
            if (s.charAt(ns - 1) != t.charAt(j))
                return false;
            j++;
        }
        return true;
    }

    // ======================================= lintcode 903
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        for (int[] x : updates) {
            ans[x[0]] += x[2];
            if (x[1] + 1 < length)
                ans[x[1] + 1] -= x[2];
        }

        for (int i = 1; i < length; i++)
            ans[i] += ans[i - 1];
        return ans;
    }

    // ======================================leetcode 11

    public int maxArea(int[] arr) {
        int n = arr.length;
        int si = 0, ei = n - 1;
        int ans = 0;

        while (si < ei) {
            ans = Math.max(ans, (ei - si) * Math.min(arr[si], arr[ei]));

            if (arr[si] < arr[ei])
                si++;
            else
                ei--;
        }
        return ans;

    }

    // =================================== leetcode 977
    public int[] sortedSquares(int[] arr) {
        int[] ans = new int[arr.length];
        int idx = 0;

        while (idx < arr.length && arr[idx] < 0) {
            idx++;
        }
        int i = idx - 1, j = idx;
        int k = 0;
        while (i >= 0 && j < arr.length) {
            int x = arr[i] * arr[i];
            int y = arr[j] * arr[j];

            if (x < y) {
                ans[k] = x;
                i--;
            } else {
                ans[k] = y;
                j++;
            }
            k++;
        }

        while (i >= 0) {
            ans[k] = arr[i] * arr[i];
            i--;
            k++;
        }

        while (j < arr.length) {
            ans[k] = arr[j] * arr[j];
            j++;
            k++;
        }

        return ans;
    }

    // ==================================leetcode 665
    public boolean checkPossibility(int[] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1] && cnt == 0) {
                cnt++;
                if (i > 0 && arr[i - 1] > arr[i + 1]) {
                    arr[i + 1] = arr[i];
                } else {
                    arr[i] = arr[i + 1];
                }
            } else if (cnt == 1 && (arr[i] > arr[i + 1])) {
                return false;
            }
        }

        return true;

    }

    // =========================== leetcode 152

    public int maxProduct(int[] arr) {
        int l = 1, r = 1, ans = arr[0];
        for (int i = 0; i < arr.length; i++) {

            l = l == 0 ? 1 : l;
            r = r == 0 ? 1 : r;

            l *= arr[i];
            r *= arr[arr.length - 1 - i];

            ans = Math.max(ans, Math.max(l, r));
        }

        return ans;
    }

    // ================================ leetcode 556
    public int nextGreaterElement(int n) {
        if(n>2147483647)return -1;
        String str = n+"";
        char[] arr = str.toCharArray();
        int i = arr.length -2;
        
        while(i>=0 && arr[i]>=arr[i+1])i--;
        if(i<0)return -1;
        int x = i+1;
        int y = arr.length-1;
        
        for(int k = arr.length-1;k>=0;k--){
            if(arr[k]>arr[i]){
                char temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;  
                break;
            }
        }
       
        String ans = "";
        
        while(x<y){
            char temps = arr[x];
            arr[x] = arr[y];
            arr[y] = temps;
            x++;y--;
        }
        
        
        for(int k=0;k<arr.length;k++)ans += arr[k];
        
        
        long val = Long.valueOf(ans);
        return val <= Integer.MAX_VALUE ? (int) val : -1;
    }

    // =================================== leetcode
}
