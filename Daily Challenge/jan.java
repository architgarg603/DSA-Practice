import java.util.*;
import java.io.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

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

class jan {

    public int findJudge(int n, int[][] arr) {
        int[] freq = new int[n + 1];
        int[] freqCnt = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i][0]] = 1;
            freqCnt[arr[i][1]] += 1;
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.println(freq[i]);
            if (freq[i] == 0 && freqCnt[i] == n - 1)
                return i;
        }

        return -1;
    }

    // ===========================leetcode 1009
    public int bitwiseComplement(int n) {

        int i = 1;

        while (i < n) {
            i = i * 2 + 1;
        }

        return i - n;
    }

    // ========================= leetcode 131
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        palindromicSubString(s, 0, ans, temp);
        return ans;
    }

    public static boolean checkPalindrome(String str, int si, int ei) {
        while (si < ei) {
            if (str.charAt(si++) != str.charAt(ei--))
                return false;
        }

        return true;
    }

    public static void palindromicSubString(String str, int si, List<List<String>> ans, List<String> temp) {

        if (si == str.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = si; i < str.length(); i++) {
            if (checkPalindrome(str, si, i)) {
                temp.add(str.substring(si, i + 1));
                palindromicSubString(str, i + 1, ans, temp);
                temp.remove(temp.size() - 1);
            }
        }

    }

    // ======================================================= leetcode 1094
    public boolean carPooling(int[][] arr, int cap) {

        int[] freq = new int[1100];
        for (int[] x : arr) {
            freq[x[1]] += x[0];
            freq[x[2]] -= x[0];
        }
        int ans = 0;
        for (int x : freq) {
            ans += x;
            if (ans > cap)
                return false;
        }

        return true;

    }

    // ========================================= leetcode 382
    class Solution {
        int[] nums;

        public Solution(ListNode head) {
            int size = 0;
            ListNode temp = head;
            while (head != null) {
                size++;
                head = head.next;
            }
            nums = new int[size];
            int cnt = 0;
            while (temp != null) {
                nums[cnt] = temp.val;
                temp = temp.next;
                cnt++;
            }
        }

        public int getRandom() {
            int idx = (int) (Math.random() * nums.length);
            return nums[idx];
        }
    }

    // ==========================================leetcode 1463
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dpCache = new int[m][n][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dpCache[i][j][k] = -1;
                }
            }
        }
        return dp(0, 0, n - 1, grid, dpCache);
    }

    private int dp(int row, int col1, int col2, int[][] grid, int[][][] dpCache) {
        if (col1 < 0 || col1 >= grid[0].length || col2 < 0 || col2 >= grid[0].length) {
            return 0;
        }
        if (dpCache[row][col1][col2] != -1) {
            return dpCache[row][col1][col2];
        }
        int result = 0;
        result += grid[row][col1];
        if (col1 != col2) {
            result += grid[row][col2];
        }
        if (row != grid.length - 1) {
            int max = 0;
            for (int newCol1 = col1 - 1; newCol1 <= col1 + 1; newCol1++) {
                for (int newCol2 = col2 - 1; newCol2 <= col2 + 1; newCol2++) {
                    max = Math.max(max, dp(row + 1, newCol1, newCol2, grid, dpCache));
                }
            }
            result += max;
        }

        dpCache[row][col1][col2] = result;
        return result;
    }

    public boolean isRobotBounded(String str) {
        int dir = 0;
        int x = 0, y = 0;
        char[] arr = str.toCharArray();
        for (char ch : arr) {
            if (ch == 'R') {
                dir = (dir + 1) % 4;
            } else if (ch == 'L') {
                dir = (dir - 1 + 4) % 4;
            } else {
                switch (dir) {
                    case 0: {
                        y++;
                        break;
                    }
                    case 1: {
                        x++;
                        break;
                    }
                    case 2: {
                        y--;
                        break;
                    }
                    case 3: {
                        x--;
                        break;
                    }
                }
            }
        }

        if (x == 0 && y == 0)
            return true;
        if (dir != 0)
            return true;
        return false;
    }

    // ======================== leetcode 67
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int car = 0;
        while (i >= 0 && j >= 0) {
            int sum = a.charAt(i) + b.charAt(j) - '0' - '0' + car;
            car = sum / 2;
            sb.append(sum % 2);
            i--;
            j--;

        }
        while (i >= 0) {
            int sum = a.charAt(i) - '0' + car;
            car = sum / 2;
            sb.append(sum % 2);
            i--;

        }

        while (j >= 0) {
            int sum = b.charAt(j) - '0' + car;
            car = sum / 2;
            sb.append(sum % 2);
            j--;
        }

        if (car > 0)
            sb.append(1);

        return sb.reverse().toString();
    }

    // ========================================= leetcode 1022
    public int sumRootToLeaf(TreeNode root) {

        return sumRootToLeaf_Helper(root, 0);
    }

    public static int sumRootToLeaf_Helper(TreeNode root, int sum) {
        if (root == null)
            return 0;

        sum = (2 * sum) + root.val;

        if (root.left == null && root.right == null)
            return sum;

        return sumRootToLeaf_Helper(root.left, sum) + sumRootToLeaf_Helper(root.right, sum);

    }

    // =============================== leetcode 701
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val < root.val)
            root.left = insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);

        return root;

    }
    // ======================================== leetcode 452

    public int findMinArrowShots(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 1;
        int end = arr[0][1];
        for (int i = 0; i < arr.length; i++) {
            if (end < arr[i][0]) {
                ans++;
                end = arr[i][1];
            }
        }

        return ans;

    }

    // ========================================= leetcode 8
    public int myAtoi(String s) {
        long ans = 0;
        int checkNumber = 0;
        int checkNegetive = 0;
        int checkWord = 0;

        s = s.trim();
        s = s.split(" ")[0];

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);

            if ((x < '0' || x > '9')) {

                if (checkNumber == 0 && x == ' ')
                    continue;
                checkWord++;
                if (checkWord <= 1 && checkNumber == 0 && (x == '-' || x == '+')) {
                    checkNegetive = x == '-' ? 1 : 0;
                    continue;
                }
                return checkNegetive == 1 ? (int) -ans : (int) ans;
            }

            ans = ans * 10 + (x - '0');
            checkNumber = 1;
            if (ans > Integer.MAX_VALUE)
                return checkNegetive == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        return checkNegetive == 1 ? (int) -ans : (int) ans;

    }

    // =============================================letcode 1345
    public int minJumps(int[] arr) {
        if (arr.length == 1)
            return 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        int ans = 0;
        Queue<Integer> qu = new LinkedList<>();
        qu.add(0);
        while (qu.size() > 0) {
            ans++;
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                int x = qu.remove();
                if (x == arr.length - 1)
                    return ans - 1;
                if (x - 1 >= 0 && map.containsKey(arr[x - 1])) {
                    qu.add(x - 1);
                }
                if (x + 1 < arr.length && map.containsKey(arr[x + 1])) {
                    qu.add(x + 1);
                }

                ArrayList<Integer> temp = map.getOrDefault(arr[x], new ArrayList<>());
                for (int j = 0; j < temp.size(); j++)
                    qu.add(temp.get(j));
                map.remove(arr[x]);
            }
        }
        return ans - 1;

    }

    // ================================= leetcode 849
    public int maxDistToClosest(int[] arr) {
        if (arr.length == 2)
            return 1;
        int ans = 0;
        int cnt = 0;
        int n = arr.length;

        if (arr[0] == 0) {
            for (int i = 0; i < arr.length && arr[i] == 0; i++)
                cnt++;
        }
        ans = Math.max(ans, cnt);

        cnt = 0;
        if (arr[n - 1] == 0) {
            for (int i = n - 1; i >= 0 && arr[i] == 0; i--)
                cnt++;
        }
        ans = Math.max(ans, cnt);
        int i = 0, j = 0;
        while (j < n) {
            if (arr[j] == 1) {
                ans = Math.max(ans, (j - i + 1) / 2);
                i = j + 1;
            }
            j++;
        }

        return ans;

    }

    // ================================================ leetcode290
    public boolean wordPattern(String p, String s) {
        HashMap<String, Character> map = new HashMap<>();
        String[] str = s.split(" ");
        if (p.length() != str.length)
            return false;

        for (int i = 0; i < str.length; i++) {
            if (map.containsKey(str[i])) {
                if (map.get(str[i]) != p.charAt(i))
                    return false;
            } else {
                if (map.containsValue(p.charAt(i)))
                    return false;
                map.put(str[i], p.charAt(i));
            }
        }

        return true;
    }
}