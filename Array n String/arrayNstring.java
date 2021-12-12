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