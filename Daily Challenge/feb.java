import java.util.*;
import java.io.*;

class feb {

    // =============================== leetcode 121
    public int maxProfit(int[] arr) {
        int ans = 0;
        int minPrice = arr[0];
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, arr[i] - minPrice);
            minPrice = Math.min(arr[i], minPrice);
        }

        return ans;

    }

    // ========================== leetcode 438
    public List<Integer> findAnagrams(String s, String p) {
        int[] freq = new int[128];
        for (int i = 0; i < p.length(); i++)
            freq[p.charAt(i)]++;
        int req = p.length();
        List<Integer> ans = new ArrayList<>();

        int si = 0, ei = 0;

        while (ei < s.length()) {
            if (freq[s.charAt(ei++)]-- > 0)
                req--;
            while ((ei - si) > p.length()) {
                if (freq[s.charAt(si++)]++ >= 0)
                    req++;
            }
            if ((ei - si) == p.length() && req == 0) {
                ans.add(si);
            }
        }

        return ans;

    }

}