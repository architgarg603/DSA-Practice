import java.util.*;
import java.io.*;

class arrayNstring {

    public static void display(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void reverse(int[] arr, int st, int ed) {
        while (st < ed) {
            int temp = arr[st];
            arr[st] = arr[ed];
            arr[ed] = temp;
            st++;
            ed--;
        }
    }

    public static void rotateByK(int k, int[] arr) {
        int n = arr.length;
        k = ((k % n) + n) % n;

        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);
        display(arr);

    }

    public static void segregatePositiveAndNegative(int[] arr) {
        int itr = 0, ptr = 0, n = arr.length;
        while (itr < n) {
            if (arr[itr] < 0) {
                int temp = arr[itr];
                arr[itr] = arr[ptr];
                arr[ptr] = temp;
                ptr++;
            }
            itr++;
        }
        display(arr);
    }

    public static void segregate01(int[] arr) {
        int i = 0, j = 0, n = arr.length;
        while (i < n) {
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }
        display(arr);
    }

    public static void segregate012(int[] arr) {
        int n = arr.length, i = 0, j = 0, k = 0;
        while (k < n) {
            if (arr[k] == 1) {
                int temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
                j++;
            }
            if (arr[k] == 0) {
                int temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;

                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
                j++;
            }
            k++;
        }

        display(arr);
    }

    public static void rotateMax(int[] arr) {
        int sum = 0;
        int sumIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            sumIdx += arr[i] * i;
        }

        int maxAns = sumIdx;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            sumIdx = sumIdx - sum + arr[i - 1] * n;
            maxAns = Math.max(maxAns, sumIdx);
        }
        System.out.println(maxAns);

    }

    // 003
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int cnt = 0, si = 0, ei = 0, n = s.length();
        int ans = 0;
        int len = 0;

        while (ei < n) {
            if (freq[s.charAt(ei++)]++ > 0)
                cnt++;

            while (cnt > 0) {
                if (freq[s.charAt(si++)]-- > 1)
                    cnt--;
            }

            len = Math.max(len, ei - si);
        }

        return len;

    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int si = 0, ei = 0, cnt = 0, ans = 0;
        int n = s.length();
        int[] freq = new int[256];

        while (ei < n) {

            if (freq[s.charAt(ei++)]++ == 0)
                cnt++;
            while (cnt > 2) {
                if (freq[s.charAt(si++)]-- == 1)
                    cnt--;
            }

            ans = Math.max(ans, ei - si);

        }

        return ans;
    }

    public String minWindow(String s, String t) {
        int cnt = 0, si = 0, ei = 0, gsi = 0, gei = 0, len = (int) 1e9;
        int ns = s.length();
        int nt = t.length();

        if (nt > ns)
            return "";

        int[] freq = new int[256];

        for (int i = 0; i < nt; i++) {
            freq[t.charAt(i)]++;
            cnt++;
        }

        while (ei < ns) {
            if (freq[s.charAt(ei++)]-- > 0)
                cnt--;

            while (cnt == 0) {
                if (ei - si < len) {
                    len = ei - si;
                    gsi = si;
                    gei = ei;
                }
                if (freq[s.charAt(si++)]++ == 0)
                    cnt++;
            }
        }

        if (len == (int) 1e9)
            return "";
        else
            return s.substring(gsi, gsi + len);

    }

    // ================================ gfg - Smallest distinct window
    public String findSubString(String str) {
        int cnt = 0, si = 0, ei = 0;
        int[] freq = new int[256];
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (freq[str.charAt(i)] == 0) {
                cnt++;
                freq[str.charAt(i)]++;
            }
        }

        int gsi = 0, len = str.length();

        while (ei < n) {
            if (freq[str.charAt(ei++)]-- > 0)
                cnt--;

            while (cnt == 0) {
                if (ei - si < len) {
                    len = ei - si;
                    gsi = si;
                }

                if (freq[str.charAt(si++)]++ == 0)
                    cnt++;
            }
        }

        return str.substring(gsi, gsi + len);

    }

    // ======================================== lincode 386

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        int cnt = 0;
        int len = 0;

        int ei = 0, si = 0, n = s.length();
        int[] freq = new int[256];
        // int cnt = 0;
        while (ei < n) {

            if (freq[s.charAt(ei++)]++ == 0)
                cnt++;

            while (cnt > k) {
                if (freq[s.charAt(si++)]-- == 1)
                    cnt--;
            }

            len = Math.max(len, ei - si);

        }

        return len;
    }

    // ====================================== leetcode 1456

    public int maxVowels(String s, int k) {
        int ans = 0;
        int si = 0, ei = 0, n = s.length(), cnt = 0;

        while (ei < n) {
            if (isVowel(s.charAt(ei++)))
                cnt++;

            if (ei - si >= k && isVowel(s.charAt(si++)))
                cnt--;

            ans = Math.max(ans, cnt);
        }

        return ans;
    }

    public static boolean isVowel(char x) {
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }

    // ====================================== leetcode 1248
    public int numberOfSubarrays(int[] arr, int k) {
        int atK = atMost(arr,k);
        int atK1 = k-1<0?0:atMost(arr,k-1);
        return atK - atK1;
    }
    
    public int atMost(int[] arr, int k){
        int cnt = 0;
        int si=0,ei=0,n=arr.length;
        int ans = 0;
        while(ei<n){
            
            if((arr[ei++]%2) != 0){
                cnt++;
            }
            
            while(cnt>k){
             if((arr[si++]%2) != 0){
                cnt--;
             }   
            }
            
            ans += ei-si;
            
        }
        
        return ans;
    }
    
    // =========================== leetcode 904

    public int totalFruit(int[] arr) {
        int si=0,ei=0,n=arr.length,cnt=0,ans=0;
        int[] freq = new int[n];
        while(ei<n){
            if(freq[arr[ei++]]++==0)cnt++;
            
            while(cnt>2){
                if(freq[arr[si++]]--==1)cnt--;
            }
            
            ans = Math.max(ans,ei-si);
        }
        
        return ans;
    }

    // ============================= leetcode 930
    public int numSubarraysWithSum(int[] nums, int goal) {
        return AtMostSum(nums, goal) - (goal == 0?0:AtMostSum(nums,goal-1));
    }
    
    public int AtMostSum(int[] arr, int k){
        int si =0, ei=0, n= arr.length, cnt = 0;
        int sum = 0;
        while(ei<n){
            sum+= arr[ei++];
            while(sum>k){
                sum-= arr[si++];
            }
            
            cnt += ei-si;
        }
        
        return cnt;
    }
    // ======================================= leetcode 485
    public int findMaxConsecutiveOnes(int[] arr) {
        int si=0,ei=0,ans=0, n=arr.length;
        
        while(ei<n){
            if(arr[ei++]==0){
                si=ei;
            }
            ans = Math.max(ans,ei-si);
        }
        return ans;
        
    }

    // ============================ leetcode 487 / lintcode 883
    public int findMaxConsecutiveOnes_2(int[] arr) {

        int si=0,ei=0,cnt=0,ans=0,n=arr.length;
        while(ei<n){
            if(arr[ei++] == 0)cnt++;
            while(cnt>1){
                if(arr[si++]==0)cnt--;
            }
            ans= Math.max(ans, ei-si);
        }
        return ans;

    }

    // ====================================================== leetcode 1004

    public int longestOnes(int[] arr, int k) {
        int si=0,ei=0,cnt=0,ans=0,n=arr.length;
        while(ei<n){
            if(arr[ei++] == 0)cnt++;
            while(cnt>k){
                if(arr[si++]==0)cnt--;
            }
            ans= Math.max(ans, ei-si);
        }
        return ans;
    }
    // ========================== leetcode 974
    public int subarraysDivByK(int[] arr, int k) {
    
        int si=0,ei=0,n=arr.length,ans = 0;
         int[] freq = new int[k];
         int sum = 0;
         freq[0] = 1;
         while(ei<n){
             sum += arr[ei++];
             int rem = (sum%k+k)%k;
             ans += freq[rem]++;
         }
         return ans;
     }

    //  ========================= gfg cnt subarray equal 0 N 1
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ei = 0, ans = 0, sum = 0;
        map.put(0,1);
        while(ei<n){
            int val = arr[ei++];
            sum += val == 1? 1:-1;
            ans += map.getOrDefault(sum,0);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return ans;
    }

    // ============================ leetcode 525 
    public int findMaxLength(int[] arr) {
    
        HashMap<Integer,Integer> map = new HashMap<>();
        int ei=0,n = arr.length, ans = 0, sum =0;
        map.put(0,0);
        while(ei<n){
            int val = arr[ei++];
            sum += val == 1 ? 1: -1;
            map.putIfAbsent(sum, ei);
            ans = Math.max(ans, ei - map.get(sum));
        }
        
        return ans;
    }

    // ================================ 239
    public int[] maxSlidingWindow(int[] arr, int k) {
        LinkedList<Integer> qu = new LinkedList<>();
        
        int[] ans = new int[arr.length-k+1];
        int n = arr.length;
        for(int i=0;i<n;i++){
            while(qu.size()>0 && qu.getFirst()<=i-k)qu.removeFirst();
            while(qu.size()>0 && arr[qu.getLast()]<=arr[i])qu.removeLast();
            qu.addLast(i);
            if(i>=k-1)ans[i-k+1] = arr[qu.getFirst()];
        }
        
        return ans;
        
        
        
    }

    // =============================== leetcode 1191
    static int mod = (int)1e9+7;
    public int kadane(int[] arr){
        int n = arr.length;
        int gsum = arr[0];
        int sum = 0;
        
        for(int x : arr){
            sum = Math.max(x, sum+x);
            gsum = Math.max(sum,gsum);
        }
        
        return gsum;
    }
    
    
    public int kConcatenationMaxSum(int[] arr, int k) {
        if(k==0)return 0;
        if(k==1)return kadane(arr);
        
        long kSum = kadane(arr);
        
        long prefixSum=0, postfixSum=0, sum = 0;
        int n = arr.length;
        long prSum=0,poSum = 0;
        for(int i=0,j=n-1;i<n;i++,j--){
            prSum += arr[i];
            poSum += arr[j];
            sum += arr[i];
            
            prefixSum = Math.max(prefixSum, prSum);
            postfixSum = Math.max(postfixSum, poSum);
        }
        System.out.println(kSum);
        if(sum<0)sum=0;
        else sum = sum%mod;
        return (int) Math.max(kSum, postfixSum + prefixSum + ((k-2)* sum)%mod)%mod;
        
    } 
    public static void main(String[] args) {
        // int[] arr = new int[]{1,2,3,4,5,6,7,8,9,-1,-2,-3};
        // int[] arr = new int[]{0,1,0,1,0,0,0,0,1,1,1,1,0,0,1,0,1,0};
        // int[] arr = new int[] { 0, 2, 1, 1, 1, 1, 2, 0, 0, 0 };
        // rotateByK(3,arr);
        // segregatePositiveAndNegative(arr);
        // segregate01(arr);
        // segregate012(arr);
    }
}