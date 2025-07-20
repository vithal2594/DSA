package Prac.basics;

abstract class Animal {
    abstract void makeSound(); // abstract method

    void eat() {               // concrete method
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Dog barks");
    }
}
// 4 pillars 
// 1.abstraction
// 2.encapsulation
// 3.inheritance
// 4.polymorphism

// 🔹 Key Points:
// Can have both abstract and concrete methods

// Can have constructors

// Can have instance variables

// Supports inheritance

// Can have access modifiers (public, protected, etc.)

interface Flyable {
    void fly(); // abstract method
}
// All methods are public and abstract by default (until Java 7)

// Cannot have constructors

// Can only have constants (variables are public static final)

// Supports multiple inheritance

// Java 8+: Can have default and static methods

// Java 9+: Can have private methods
class Bird implements Flyable {
    public void fly() {
        System.out.println("Bird flies");
    }
}
