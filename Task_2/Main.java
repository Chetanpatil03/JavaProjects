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
        Student student = new Student("John Doe", 20, "Computer Science");
        student.displayInfo();   // Display student information

        Student student2 = new Student("Jane Smith", 22, "Mathematics");
        student2.displayInfo();  // Display student information
        // Add more students as needed

        
        
    }
}
