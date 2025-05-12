 class Student {
    String name;
    int age;
    String major;

    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Major: " + major);
    }

    
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        // Create a new Student object
    }
}
