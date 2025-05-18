package in.hello.controller;
public class TestClass
{
    public static void main(String[] args) {
        validateAge(15); // Invalid age
        validateAge(25); 
    }

    public static void validateAge(int age) {
        if (age < 20 || age > 30) {
            System.out.println("FAILED: Age must be between 20 and 30");
            return; // Exit the method if age is invalid
        }
        System.out.println("Valid age: " + age);
        System.out.println("hi my name is khan");
    }
}
