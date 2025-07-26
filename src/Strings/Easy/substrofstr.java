package Strings.Easy;

public class substrofstr {
    public static void main(String[] args){
        String input = "abc";
        printAllsubstring(input);
    }
    public static void printAllsubstring(String s){
        int n=s.length();
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<n; j++){
                sb.append(s.charAt(j));
                System.out.println(sb.toString());
            }
        }
    }
}
