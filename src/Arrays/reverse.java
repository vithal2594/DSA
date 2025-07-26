package Arrays;

public class reverse {
    public static void main(String[] args){
        int n=423;
        StringBuffer s= new StringBuffer(String.valueOf(n));
        s.reverse();
        n=Integer.parseInt(String.valueOf(s));
        System.out.println(n);
    }
}
