package Strings.Easy;

public class validshuffle {

    public static void main(String[] args){
        String s1="abc";
        String s2="def";
        String s3="abcdef";
        System.out.println(checkshuffle(s1,s2,s3));
    }
    public static boolean checkshuffle(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        int i=0;
        int j=0;
        int k=0;

        while(k < s3.length()){
            if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
                i++;
            }else if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
                j++;
            }else{
                return false;
            }
            k++;
        }
        return true;
    }
}
