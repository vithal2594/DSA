package Arrays.Easy;

public class isSorted {
    public static  void main(String[] args){
        int [] arr = {1,2,3,5,6,2};
//        int [] arr ={54,1,2,3,4,5};
        System.out.println("Is the array sorted? " + issorted(arr));
    }
    public static boolean issorted(int [] arr ){
        int n= arr.length;
        for(int i=0; i<n-1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return  true;

    }
}
