package Task_Certification;

class Student {
    private String name;
    private int studentId;
    private int qualifyingexammarks ;
    private char residentialstatus;
    private int yearofengg;

    public Student(String name, int studentId, int qualifyingexammarks, char residentialstatus, int yearofengg) {
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

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
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
        Student student_one = new Student("John Doe",101, 80, 'H', 3);
        Student student_two = new Student("Peter",102, 83, 'D', 2);
        Student student_three = new Student("Chetan",103, 85, 'H', 1);

        System.out.println("output for student_one:\n\n");
        System.out.println("Name                   : " + student_one.getName());
        System.out.println("Student ID             : " + student_one.getStudentId());
        System.out.println("Qualifying Exam Marks  : " + student_one.getQualifyingexammarks());
        
        if (student_one.getResidentialstatus() == 'H') {
            System.out.println("Residential Status     : Hosteller");
        } else if (student_one.getResidentialstatus() == 'D')
            System.out.println("Residential Status     : Day Scholar");
        
        System.out.println("Year of Engineering    : " + student_one.getYearofengg());
        
        
        System.out.println("output for student_two:\n\n");
        System.out.println("Name                   : " + student_two.getName());
        System.out.println("Student ID             : " + student_two.getStudentId());
        System.out.println("Qualifying Exam Marks  : " + student_two.getQualifyingexammarks());
        if (student_two.getResidentialstatus() == 'H') {
            System.out.println("Residential Status     : Hosteller");
        } else if (student_two.getResidentialstatus() == 'D') {
            System.out.println("Residential Status     : Day Scholar");
        }
        System.out.println("Year of Engineering    : " + student_two.getYearofengg());

        System.out.println("output for student_three:\n\n");
        System.out.println("Name                   : " + student_three.getName());
        System.out.println("Student ID             : " + student_three.getStudentId());
        System.out.println("Qualifying Exam Marks  : " + student_three.getQualifyingexammarks());
        if (student_three.getResidentialstatus() == 'H') {
            System.out.println("Residential Status     : Hosteller");
        } else if (student_three.getResidentialstatus() == 'D') {
            System.out.println("Residential Status     : Day Scholar");
        }
        System.out.println("Year of Engineering    : " + student_three.getYearofengg());
        
    }
}
