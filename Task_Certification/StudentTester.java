package Task_Certification;

class Student {
    private String name;
    private String studentId;
    private int qualifyingexammarks ;
    private char residentialstatus;
    private int yearofengg;

    public Student(String name, String studentId, double gpa, int qualifyingexammarks, char residentialstatus, int yearofengg) {
        this.name = name;
        this.studentId = studentId;
        this.qualifyingexammarks = qualifyingexammarks;
        this.residentialstatus = residentialstatus; 
        this.yearofengg = yearofengg;
 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getQualifyingexammarks() {
        return qualifyingexammarks;
    }

    public void setQualifyingexammarks(int qualifyingexammarks) {
        this.qualifyingexammarks = qualifyingexammarks;
    }

    public char getResidentialstatus() {
        return residentialstatus;
    }

    public void setResidentialstatus(char residentialstatus) {
        this.residentialstatus = residentialstatus;
    }

    public int getYearofengg() {
        return yearofengg;
    }

    public void setYearofengg(int yearofengg) {
        this.yearofengg = yearofengg;
    }

}

public class StudentTester {

    public static void main(String[] args) {
        Student student = new Student("John Doe", 20, "12345", 3.5,);
        System.out.println(student.getName()); // John Doe
        System.out.println(student.getAge()); // 20
        System.out.println(student.getStudentId()); // 12345
        System.out.println(student.getGpa()); // 3.5

        student.setName("Jane Doe");
        student.setAge(21);
        student.setStudentId("54321");
        student.setGpa(3.8);

        System.out.println(student.getName()); // Jane Doe
        System.out.println(student.getAge()); // 21
        System.out.println(student.getStudentId()); // 54321
        System.out.println(student.getGpa()); // 3.8
    }
}