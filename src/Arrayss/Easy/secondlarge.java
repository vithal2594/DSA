package Arrayss.Easy;

public class secondlarge {
    public static void main(String[] args){
        int [] arr = {1,28,90,5,63,5};
        System.out.println("Second largest element: " + secondlarg(arr));
    }
    public static int secondlarg(int[] arr){
        int n= arr.length;
        int la=-1;
        int sla = -1;
        for(int i=0;i<n;i++){
            if(arr[i] > la){
                sla=la;
                la=arr[i];
            }else if(arr[i] > sla && arr[i] < la){
                sla= arr[i];
            }
        }
        return sla;
    }
}
