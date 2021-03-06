import java.util.*;
import java.io.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

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

    // ====================== leetcode 23
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        ListNode dummy = lists[0];
        for (int i = 1; i < lists.length; i++) {
            if (lists[i] != null)
                dummy = mergeTwoLL(dummy, lists[i]);
        }
        return dummy;
    }

    public ListNode mergeTwoLL(ListNode r1, ListNode r2) {
        if (r1 == null)
            return r2;
        if (r2 == null)
            return r1;

        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        while (r1 != null && r2 != null) {
            if (r1.val < r2.val) {
                temp.next = r1;
                r1 = r1.next;
            } else {
                temp.next = r2;
                r2 = r2.next;
            }
            temp = temp.next;
        }

        if (r1 != null) {
            temp.next = r1;
        }
        if (r2 != null) {
            temp.next = r2;
        }
        return dummy.next;

    }

    // ?================= leetcode 80
    public int removeDuplicates(int[] arr) {
        int itr = 0, ptr = 0;
        while (itr < arr.length) {
            arr[ptr++] = arr[itr++];

            if (itr < arr.length && arr[itr] == arr[ptr - 1])
                arr[ptr++] = arr[itr++];
            while (itr < arr.length && arr[itr] == arr[ptr - 1])
                itr++;
        }

        return ptr;
    }

    // ========================= leetcode 389
    public char findTheDifference(String s, String t) {
        int[] freq = new int[128];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i)]++;
        for (int i = 0; i < t.length(); i++)
            freq[t.charAt(i)]--;
        for (int i = 92; i < 128; i++)
            if (freq[i] == -1)
                return (char) (i);
        return ' ';

    }

    // ======================== leetcode 258
    public int addDigits(int n) {
        if (n <= 9)
            return n;
        int ans = 0;
        while (n > 0) {
            int r = n % 10;
            ans += r;
            n /= 10;
        }

        return addDigits(ans);
    }

    // =============================== leetcode 532
    public int findPairs(int[] arr, int k) {
        Arrays.sort(arr);
        HashSet<Integer> map = new HashSet<>();
        HashSet<Integer> check = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.contains(arr[i] - k)) {

                ans++;
                map.remove(arr[i] - k);
            }
            if (!check.contains(arr[i])) {
                map.add(arr[i]);
                check.add(arr[i]);
            }
        }

        return ans;
    }

    // ============================= leetcode 560
    public int subarraySum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(0, 1);
        for (int ele : arr) {

            sum += ele;
            if (map.containsKey(sum - k))
                ans += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        return ans;

    }

    // ========================= leetcode 567
    public boolean checkInclusion(String s1, String s2) {
        int req = s1.length();
        int[] freq = new int[128];
        for (int i = 0; i < s1.length(); i++)
            freq[s1.charAt(i)]++;

        int si = 0, ei = 0;

        while (ei < s2.length()) {

            if (freq[s2.charAt(ei++)]-- > 0)
                req--;

            while (ei - si > s1.length()) {
                if (freq[s2.charAt(si++)]++ >= 0)
                    req++;
            }

            if (req == 0)
                return true;

        }

        return false;

    }

    // ===================================leetcode 127
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> map = new HashSet<>();
        for (String str : wordList)
            map.add(str);
        if (!map.contains(endWord))
            return 0;

        Queue<String> qu = new LinkedList<>();
        qu.add(beginWord);

        int cnt = 0;

        while (qu.size() > 0) {
            int size = qu.size();
            cnt++;
            while (size-- > 0) {

                String temp = qu.remove();
                if (temp.equals(endWord))
                    return cnt;

                for (int i = 0; i < temp.length(); i++) {
                    for (int j = 0; j < 26; j++) {
                        String str = temp.substring(0, i) + (char) (97 + j) + temp.substring(i + 1);

                        if (map.contains(str)) {
                            qu.add(str);
                            map.remove(str);
                        }
                    }
                }

            }
        }

        return 0;

    }

    // =========================== leetcode 78
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, ans, temp, 0);

        return ans;
    }

    public void solve(int[] arr, List<List<Integer>> ans, List<Integer> temp, int idx) {
        if (idx == arr.length) {
            List<Integer> base = new ArrayList<>(temp);
            ans.add(base);
            return;
        }

        solve(arr, ans, temp, idx + 1);
        temp.add(arr[idx]);
        solve(arr, ans, temp, idx + 1);
        temp.remove(temp.size() - 1);

    }

    // ========================================== leetcode 104
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // ================================== leetcode 136
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int ele : nums)
            ans ^= ele;
        return ans;
    }

    // ========================24
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy;

        while (curr != null && curr.next != null && curr.next.next != null) {
            ListNode t1 = curr.next;
            ListNode t2 = t1.next;

            t1.next = t2.next;
            t2.next = t1;
            curr.next = t2;

            curr = t1;

        }

        return dummy.next;

    }

    // =========================== leetcode 39
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinationSum(candidates, target, ans, temp, 0);
        return ans;
    }

    public void combinationSum(int[] arr, int tar, List<List<Integer>> ans, List<Integer> temp, int idx) {

        if (tar == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                temp.add(arr[i]);
                combinationSum(arr, tar - arr[i], ans, temp, i);
                temp.remove(temp.size() - 1);
            }
        }

    }

    // =============================== leetcode 402
    public String removeKdigits(String str, int k) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            while (st.size() > 0 && st.peek() > str.charAt(i) && k > 0) {
                st.pop();
                k--;
            }

            if (st.size() == 0 && str.charAt(i) == '0') {
                continue;
            } else {
                st.push(str.charAt(i));
            }
        }

        while (k > 0 && st.size() > 0) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (st.size() > 0) {
            sb.append(st.pop());
        }

        if (sb.length() == 0)
            return "0";
        else
            return sb.reverse().toString();

    }

    // =========================== 1675
    public int minimumDeviation(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        int minVal = Integer.MAX_VALUE;
        for (int ele : arr) {

            if (ele % 2 == 1)
                ele *= 2;
            minVal = Math.min(minVal, ele);
            pq.add(ele);

        }
        int diff = Integer.MAX_VALUE;
        while (pq.peek() % 2 != 1) {
            int ele = pq.remove();
            diff = Math.min(diff, ele - minVal);
            minVal = Math.min(minVal, ele / 2);
            pq.add(ele / 2);
        }

        diff = Math.min(diff, pq.peek() - minVal);

        return diff;

    }

    // ==================== leetcode 1288
    public int removeCoveredIntervals(int[][] arr) {
        Arrays.sort(arr, (a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int ans = arr.length;
        int maxEnd = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            if (maxEnd >= arr[i][1])
                ans--;
            maxEnd = Math.max(arr[i][1], maxEnd);
        }

        return ans;
    }

    // ============================== leetcode 165
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");

        int i = 0;
        for (i = 0; i < str1.length || i < str2.length; i++) {
            int t1 = i >= str1.length ? 0 : Integer.parseInt(str1[i]);
            int t2 = i >= str2.length ? 0 : Integer.parseInt(str2[i]);

            if (t1 < t2) {
                return -1;
            }

            if (t1 > t2)
                return 1;
        }
        return 0;
    }

    // ============================ leetcode 662
    class maxWidth {
        TreeNode node = null;
        int idx = 0;

        maxWidth(TreeNode node, int idx) {
            this.idx = idx;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int ans = 0;

        Queue<maxWidth> qu = new LinkedList<>();
        qu.add(new maxWidth(root, 1));

        while (qu.size() > 0) {
            int mx = 0, mn = 0;
            int size = qu.size();
            for (int i = 0; i < size; i++) {

                maxWidth temp = qu.remove();
                if (i == 0)
                    mn = temp.idx;
                if (i == size - 1)
                    mx = temp.idx;

                if (temp.node.left != null)
                    qu.add(new maxWidth(temp.node.left, 2 * temp.idx));
                if (temp.node.right != null)
                    qu.add(new maxWidth(temp.node.right, 2 * temp.idx + 1));

            }
            ans = Math.max(ans, mx - mn + 1);

        }

        return ans;
    }

    // =========================leetcode 228
    public List<String> summaryRanges(int[] arr) {
        List<String> ans = new ArrayList<>();
        int ei = 1, si = 0;

        while (ei < arr.length) {
            while (ei < arr.length && arr[ei] == arr[ei - 1] + 1)
                ei++;
            if (si == ei - 1)
                ans.add("" + arr[si]);
            else
                ans.add(arr[si] + "->" + arr[ei - 1]);
            si = ei++;
        }
        if (si == arr.length)
            return ans;
        ans.add("" + arr[si]);
        return ans;
    }

    // ================================799
    public double champagneTower(int poured, int query_row, int query_glass) {

        double[][] dp = new double[query_row + 1][query_row + 1];
        for (double[] arr : dp)
            Arrays.fill(arr, -1);

        return Math.min(1, champagneTowerHelper(poured, query_row, query_glass, dp));
    }

    public double champagneTowerHelper(int p, int r, int g, double[][] dp) {
        if (r < 0 || g < 0)
            return 0.00;
        if (r == 0 && g == 0)
            return dp[r][g] = (double) (p);
        if (dp[r][g] != -1)
            return dp[r][g];
        double left = g == 0 ? 0 : (champagneTowerHelper(p, r - 1, g - 1, dp) - 1) / 2;
        double right = (champagneTowerHelper(p, r - 1, g, dp) - 1) / 2;

        if (left < 0)
            left = 0;
        if (right < 0)
            right = 0;

        return dp[r][g] = left + right;

    }

    // ============================================= leetcode 141
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    // ============================================== leetcode 82
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        ListNode itr = head;
        while (itr != null ) {
           if(itr.next != null && itr.val == itr.next.val){
               while(itr.next != null && itr.val == itr.next.val)itr = itr.next;
               itr = itr.next;
           }else{
               temp.next = itr;
               temp = temp.next;
                itr = itr.next;
               temp.next = null;
           }
        }
        return dummy.next;

    }
}