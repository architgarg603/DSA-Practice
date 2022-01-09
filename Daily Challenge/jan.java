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
        int x=0,y=0;
        char[] arr =  str.toCharArray();
        for(char ch : arr){
            if(ch == 'R'){
                dir  = (dir+1)%4;
            }else if(ch == 'L'){
                dir = (dir-1+4)%4;
            }else{
                switch(dir){
                    case 0 :{
                        y++;
                        break;
                    }
                    case 1:{
                        x++;
                        break;
                    }
                    case 2: {
                        y--;
                        break;
                    }
                    case 3:{
                        x--;
                        break;
                    }
                }
            }
        }
        
        if(x==0 && y ==0)return true;
        if(dir != 0)return true;
        return false;
    }
}