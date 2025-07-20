package Prac.basics;

public class overl {
    class test{
        public static void show(){
            System.out.println("nothis passed in arguments");
        }
        public static void show(int a){
            System.out.println("1 Integer argument passed in arguments");
        }
        public static void show(String str){
            System.out.println("1 String argument passed in arguments");
        }
    }
    public static void main(String[] args) {
       test.show();
       test.show("hello");
       test.show(100);
    }
}
// Compile-time (method overloading)