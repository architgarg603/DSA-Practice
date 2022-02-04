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

    // ========================== leetcode 454
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        ArrayList<Integer> t1 = pair_(nums1, nums2);
        HashMap<Integer, Integer> map = new HashMap<>();
        pair_Map(nums3, nums4, map);

        int ans = 0;
        for (int i = 0; i < t1.size(); i++) {
            if (map.containsKey(-t1.get(i))) {
                ans += map.get(-t1.get(i));
            }
        }

        return ans;

    }

    public ArrayList<Integer> pair_(int[] arr1, int[] arr2) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                arr.add(arr1[i] + arr2[j]);
            }
        }

        return arr;
    }

    public static void pair_Map(int[] arr1, int[] arr2, HashMap<Integer, Integer> map) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                int sum = (arr1[i] + arr2[j]);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
    }

    // ================================ leetcode 525

    public int findMaxLength(int[] arr) {
        int[] freq = new int[2 * (arr.length + 2)];
        int sum = arr.length;
        int ans = 0;
        Arrays.fill(freq, -1);
        freq[sum] = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += (arr[i] == 0) ? -1 : 1;

            if (sum == arr.length) {
                ans = Math.max(ans, i + 1);
                continue;
            }

            if (freq[sum] != -1) {
                ans = Math.max(ans, i - freq[sum]);
            } else {
                freq[sum] = i;
            }
        }

        return ans;

    }
}