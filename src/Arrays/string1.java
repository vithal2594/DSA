public class string1 {
    public static void main(String[] args){
         String  word1=  "a/b/c"; // a/b/c
         String  word2= "a/b/./c"; // a/b/c
         String  word3="a/b/../c"; //a/c
         String  word4="a/b/.../c"; //a/b/.../c
         String  word5="a//b/c"; //a/b/c
        
    }
    public static String normalisepath(String str){
        String[] parts = str.split("/");
        
    } 
}
