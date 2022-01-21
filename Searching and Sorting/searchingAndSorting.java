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

        while(ptr<=ei){
            if(arr[ptr]<=arr[ei]){
                int temp = arr[ptr];
                arr[ptr] = arr[itr];
                arr[itr] = temp;
                itr++;
            }
            ptr++;
        }

        return itr-1;
    }
    
    public static void quickSort(int[] arr, int si, int ei) {
        if (si > ei)
        return;
        
        int pi = partition(arr, si, ei);
        quickSort(arr, si, pi - 1);
        quickSort(arr, pi + 1, ei);
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        quickSort(arr, 0, arr.length - 1);
        print(arr);

    }
}