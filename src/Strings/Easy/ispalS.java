package Strings.Easy;

public class ispalS {
    public static void main(String[] args) {
        String str = "racecar";
        if (ispal(str)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static boolean ispal(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
//        for(int i=str.length()-1;i>=0;i--){
//            rev+=str.charAt(i);
//        }
//        if(str.equals(rev)){
//            System.out.println("true");
//        }else{
//            System.out.println("false");
//        }
//    }
//}
