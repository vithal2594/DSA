package Arrayss.Easy;

public class largestElement {
    public static void main(String[] args){
        int []arr = {1,2,90,3,4,5};
        System.out.println("Largest element: " + largestel(arr));

    }
    public static int largestel(int[] arr){
        int n= arr.length;
        int le = arr[0] ;
        for(int i=1; i<n; i++){
            if(arr[i] > le){
                le = arr[i];
            }
        }
        return le;
    }
}
