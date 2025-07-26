package Strings.Easy;

public class isotationofanother {
    public static void main(String[] args) {
         System.out.println(isrotationofanother("abc","bca"));
    }
    public static boolean isrotationofanother(String s, String t) {
         int ns=s.length();
         int nt=t.length();
         if(ns !=nt){
             return false;
         }
         String s1=s+s;
         return s1.contains(t);
    }
}
