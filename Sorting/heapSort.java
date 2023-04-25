package Sorting;

public class heapSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapsort(int[] arr, int n) {
        // Build max heap
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for(int i=n-1; i>=0; i--) {
            swap(arr, 0, i);        // Move current root to end
            heapify(arr, i, 0);     // call max heapify on the reduced heap
        }
    }

    // To heapify a subtree rooted with node i which is an index in arr[]
    public static void heapify(int[] arr, int n, int i) {
        int root = i;           // Initialize largest as root       
        int left = 2 * i + 1;   
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && arr[left] > arr[root]) {
            root = left;
        }

        // If right child is larger than root
        if (right < n && arr[right] > arr[root]) {
            root = right;
        }

        // If largest is not root
        if (root != i) {
            swap(arr, i, root);
            heapify(arr, n, root);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 10, 4, 9, 2, 20 };
        int n = arr.length;

        heapsort(arr, n);
        
        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}