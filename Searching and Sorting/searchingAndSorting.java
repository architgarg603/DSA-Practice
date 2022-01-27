import java.util.*;
import java.io.*;

class searchingAndSorting {

    public static void print(int[] arr) {
        for (int x : arr)
            System.out.print(x + " ");
    }

    // ============================= quick sort

    public static int partition(int[] arr, int si, int ei) {
        int itr = si, ptr = si;

        while (ptr <= ei) {
            if (arr[ptr] <= arr[ei]) {
                int temp = arr[ptr];
                arr[ptr] = arr[itr];
                arr[itr] = temp;
                itr++;
            }
            ptr++;
        }

        return itr - 1;
    }

    public static void quickSort(int[] arr, int si, int ei) {
        if (si > ei)
            return;

        int pi = partition(arr, si, ei);
        quickSort(arr, si, pi - 1);
        quickSort(arr, pi + 1, ei);
    }

    // ============================================ count inversions gfg

    static long inversionCountHelper(long[] arr, int si, int ei, int mid, long[] ans) {
        long cnt = 0;
        int lsi = si, lei = mid;
        int rsi = mid + 1, rei = ei;
        int k = lsi;
        while (lsi <= lei && rsi <= rei) {
            if (arr[lsi] > arr[rsi]) {
                cnt += lei - lsi + 1;
                ans[k] = arr[rsi];
                rsi++;
            } else {
                ans[k] = arr[lsi];
                lsi++;
            }
            k++;
        }

        while (lsi <= lei) {
            ans[k] = arr[lsi];
            lsi++;
            k++;
        }

        while (rsi <= rei) {
            ans[k] = arr[rsi];
            rsi++;
            k++;
        }

        for (int i = si; i <= ei; i++) {
            arr[i] = ans[i];
        }

        return cnt;

    }

    static long inversionCount(long[] arr, int si, int ei, long[] ans) {
        if (si >= ei)
            return 0;
        int mid = si + (ei - si) / 2;
        long leftAns = inversionCount(arr, si, mid, ans);
        long rightAns = inversionCount(arr, mid + 1, ei, ans);
        return inversionCountHelper(arr, si, ei, mid, ans) + leftAns + rightAns;
    }

    static long inversionCount(long arr[], long N) {
        long[] ans = new long[(int) N];
        int n = (int) N;
        return inversionCount(arr, 0, n - 1, ans);
    }

    // =================================== leetcode 33
    public int search(int[] arr, int tar) {
        int si = 0, ei = arr.length - 1;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (arr[mid] == tar)
                return mid;
            if (arr[mid] < arr[ei]) {
                if (arr[mid] < tar && arr[ei] >= tar) {
                    si = mid + 1;
                } else
                    ei = mid - 1;
            } else {
                if (arr[si] <= tar && tar < arr[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            }
        }

        return -1;
    }

    // ======================= leetcode 81
    public boolean search_2(int[] arr, int tar) {
        int si = 0, ei = arr.length - 1;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (arr[mid] == tar || arr[si] == tar)
                return true;
            if (arr[mid] < arr[ei]) {
                if (arr[mid] < tar && tar <= arr[ei]) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            } else if (arr[si] < arr[mid]) {
                if (arr[si] <= tar && tar < arr[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            } else {
                si++;
            }
        }

        return false;
    }

    // ================================== leetcode 153
    public int findMin(int[] arr) {
        int si = 0, ei = arr.length - 1;
        if (arr[si] < arr[ei])
            return arr[si];
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (arr[mid] < arr[ei]) {
                ei = mid;
            } else {
                si = mid + 1;
            }
        }

        return arr[ei];
    }

    // =================================== leetcode 154
    public int findMin_2(int[] arr) {
        int si = 0, ei = arr.length - 1;
        if (arr[si] < arr[ei])
            return arr[si];

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (arr[mid] < arr[ei]) {
                ei = mid;
            } else if (arr[ei] < arr[mid]) {
                si = mid + 1;
            } else {
                ei--;
            }
        }

        return arr[si];
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        quickSort(arr, 0, arr.length - 1);
        print(arr);

    }
}