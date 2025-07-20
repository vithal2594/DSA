// Remove duplicate element from a list (Use Stream API)
// input - 1,2,2,3,3,3,4,5,5,6
// output - 1,4,6

import java.util.HashMap;
import java.util.Scanner;

public class removeduplicates {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter the size of array");

         int size =sc.nextInt();
         int arr[] = new int[size];

         for(int i=0; i<size; i++){
             arr[i]=sc.nextInt();
         }
         removedublicates(arr);
         System.out.println("after removing duplicates :"+" ");
        sc.close();
    }

    public static void removedublicates(int arr[]){
          int n= arr.length;
          HashMap<Integer,Integer> mp = new HashMap<>();
          for(int i=0; i<n; i++){
             mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
             
             
            // mp[i] = mp.getOrDefault(arr[i],0)+1;  
          }
          for(int i=0; i<n; i++){
            if(mp.get(arr[i]) == 1){
                System.out.print(arr[i]+ " ");
            }
          }
          
    }
    // public 
}
// 1,2,2,3,3,3,4,5,5,6
// map (key,val)
// mp[1,1];
// mp[2,2];
// mp[3,3];
// mp[4,1];
// mp[5,2];
// mp[6,1];

// mp<int,int>mp;
// @restcontroller
// @deleteMapping("/delete/{id}")
// public static void delete(@RequestParam("id") int id){
//     System.out.println("Enter the student id");
//     int id = sc.nextInt();
//     if(id != student.id){
//         if(id == null)
//         System.out.println("Student is not present in the database");
//     }else {
//         System.out.println("Student is deleted from the database");
//     }
   
// }

// osm = endpoint/ orderid
  
// scheduler =endpoint/ orderid

// .envnam
// .name
// .consumerid


// kafka 

//            zookeeper


// producers 1 
//            2,3             subscriber

