package Sorting;

public class insertion {
    public static void algo(int n, int[] arr){
        for(int i=1; i<n; i++){
            int temp = arr[i];
            int j = i-1;

            while(j>=0 && arr[j]>temp){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = temp;
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