package Strings.Easy;

public class rotationofstring {
    public static void main(String[] args){
        String s1="abcd";
        String s2="cdab";
        System.out.println(rotationof(s1,s2));
    }
    public static boolean rotationof(String s1,String s2){
        String s=s1+s1;
        for(int i=0; i<s.length();i++){
            if(s.contains(s2)){
                return true;
            }
        }
        return false;
    }
}
