package Sorting;

public class mergeSort {
    public static void merge(int[] arr, int s, int m, int e) {
        int n1 = m - s + 1;
        int n2 = e - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        // copy the elements from the original array to the temporary arrays
        for (int i = 0; i < n1; i++) {
            left[i] = arr[s + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[m + 1 + i];
        }

        int i = 0, j = 0, k = s;

        // merge the two subarrays
        while (i < n1 && j < n2) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // copy any remaining elements from the left subarray
        while (i < n1) {
            arr[k++] = left[i++];
        }

        // copy any remaining elements from the right subarray
        while (i < n2) {
            arr[k++] = right[j++];
        }
    }

    public static void mergesort(int[] arr, int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;

            // sort the left and right halves recursively
            mergesort(arr, l, mid);
            mergesort(arr, mid + 1, h);

            // merge the sorted halves
            merge(arr, l, mid, h);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 10, 4, 9, 2, 20 };
        int n = arr.length;

        mergesort(arr, 0, n-1);

        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        // 2, 4, 5, 9, 10, 20
    }
}
