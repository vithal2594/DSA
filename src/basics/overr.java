package basics;

public class overr {
    class test{
        void show(){
            System.out.println("Parent");
        }
    }
    class child extends test{
        void show(){
            System.out.println("Child");
        }
    }
    class Child extends test {
        // Overrides Parent.func(int) (runtime polymorphism)
        @Override
        public void show() {
            System.out.println("Child.func(int): ");
        }
    }
}
// Runtime (method overriding)