package Strings.Easy;

public class substrsearch {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(new substrsearch().strStr(haystack, needle));
    }
        public int strStr(String haystack, String needle) {
            if(haystack.contains(needle)){
                return haystack.indexOf(needle);
            }
            return -1;
        }
    }
