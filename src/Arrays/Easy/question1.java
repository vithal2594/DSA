package Arrays.Easy;

//Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
//num = "1432219", k = 3
public class question1 {
//1432219

//    public static int smallestpossibleafterremvingk(String num, int k){
//        List<Integer> li = new ArrayList<>()
//        for(char ch: num.toCharArray()){
//            li.add((int) ch);
//        }
//        int min=Integer.MAX_VALUE;
//        int ch=0;
//        for(int i=0; i<li.size(); i++){
//
//        }
//    }
//
public static void main(String[] args){
    int [] arr = {1,1};//,-4,5,7,8,-1,-2};
    int maximumsum = maxsum1(arr);
    System.out.println("Maximum sum is :" + maximumsum);
}
//    public static int maxsum(int[] arr){
//        int sum=0;
//        int maxsum=Integer.MIN_VALUE;
//
//        for(int i=0; i< arr.length; i++){
//            sum+=arr[i];
//            maxsum = Math.max(sum,maxsum);
//        }
//        return maxsum;
//    }

//    public static  int maxsum1(int[] arr){
//        int maxsum=Integer.MIN_VALUE;
//        for(int i=0; i<arr.length; i++){
//            int sum=0;
//            for(int j=i; j<arr.length; j++){
//                sum+=arr[j];
//                maxsum=Math.max(sum,maxsum);
//            }
//        }
//        return maxsum;
//    }

    public static int maxsum1(int[] arr){
         int sum= arr[0];
         int maxsum= arr[0];
         if(arr.length == 1){
             return arr[0];
         }
         for(int i=1; i<arr.length; i++){
             sum= Math.max(arr[i], sum+arr[i]);
             maxsum= Math.max(maxsum,sum);
         }
         return maxsum;
    }
}
