package Arrayss.Easy;

public class ispalindrome {
    public static void main(String[] args){
        int [] arr = {3,6,0,6,3};
        boolean isPalindromic = ispalindrom(arr);
        if (isPalindromic) {
            System.out.println("The array is a palindrome.");
        } else {
            System.out.println("The array is not a palindrome.");
        }
    }
    public static boolean ispalindrom(int[] arr){
        int i=0;
        int j=arr.length-1;

        while(i < j){
            if(arr[i] != arr[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
