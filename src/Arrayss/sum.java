package Arrayss;

import java.util.Scanner;

class Algebra {
     int add(int a, int b){
      int ans=a+b;
      return ans;
     }
  
}

public class sum {
    public static void main(String[] args){
      Algebra algebra = new Algebra();
     Scanner sc =new Scanner(System.in);
     int a=sc.nextInt();
     int b=sc.nextInt();
     algebra.add(a, b);
      System.out.println("The sum of "+a+" and "+b+" is: "+algebra.add(a, b));
      sc.close();
    }
}
