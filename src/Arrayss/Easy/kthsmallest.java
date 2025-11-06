package Arrayss.Easy;

import java.util.PriorityQueue;

public class kthsmallest {
    public static void main(String[] args){
        int []arr = {1,2,4,6,7,8,4,7};
        int k=3;
        System.out.println("Kth Smallest Element is: " + kthsma(arr, k));

    }
    public static int kthsma(int [] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i=0; i<arr.length;i++){
            pq.offer(arr[i]);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }
}
