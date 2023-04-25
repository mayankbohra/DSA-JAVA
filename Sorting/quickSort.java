package Sorting;

public class quickSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int start, int end){
        int p = arr[start];
        int i = start, j = end;

        while(i<j){
            while(arr[i] <= p){i++;}
            while(arr[j] > p){j--;}
            if(i<j){
                swap(arr, i, j);
            }
        }
        swap(arr, start, j);

        return j;
    }

    public static void  quicksort(int[] arr, int i, int j){
        if(i<j){
            int pivot = partition(arr, i, j);

            quicksort(arr, i, pivot-1);
            quicksort(arr, pivot+1, j);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 10, 4, 9, 2, 20 };
        int n = arr.length;

        quicksort(arr, 0, n-1);

        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        // 2, 4, 5, 9, 10, 20
    }
}
