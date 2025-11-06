package Arrayss.Easy;

//Input: n = 4
//
//Output: 5
//
//Explanation: {1, 1, 1, 1}, {1, 1, 2}, {2, 1, 1}, {1, 2, 1} and {2, 2}.
public class noofway {
    public static void main(String[] args){
         int n=4;
         System.out.println(" no of ways : "+ steptoreachdp(n));
    }
//    public static int stepstoreach(int steps){
////        if(steps < 0){
////            return -1;
////        }
//        if(steps == 0 || steps == 1 )
//            return 1;
//        return stepstoreach(steps-1) + stepstoreach(steps-2);
//    }

    public static int steptoreachdp(int steps){
        if(steps == 0 || steps == 1) return -1;
        int[] arrys = new int[steps +1];
        arrys[0] =arrys[1]=1;

        for(int i=2; i<steps+1; i++){
            arrys[i] =arrys[i-1]+arrys[i-2];
        }
          return arrys[steps];
    }
}
//1  or 2
//
//4
//1->1
//1->2
//2->2