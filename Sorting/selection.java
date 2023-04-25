package Sorting;

public class selection {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void algo(int n, int[] arr){
        for(int i=0; i<n; i++){
            int temp = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[temp]){
                    temp = j;
                }
            }
            swap(arr,temp,i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,10,4,9,2,20};
         int n = arr.length;

         algo(n ,arr);
         for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
         }
        // 2, 4, 5, 9, 10, 20
    }
}
