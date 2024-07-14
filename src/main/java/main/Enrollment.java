package main;

public class Enrollment {
    private int grade;
    private Course course;
    private Student student;

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public Enrollment(Course course, Student student) {
        this.grade = -1;
        this.course = course;
        this.student = student;
    }

    public int getGrade() {
        return grade;
    }
    
    public void gradeCourse(int grade) {
        this.grade = grade;
    }
}
