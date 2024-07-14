package main;

import java.util.ArrayList;

public class Gifu {
    private String university;
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private ArrayList<Enrollment> enrollments;


    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Gifu() {
    }

    public Gifu(String stringInput) {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.enrollments = new ArrayList<>();
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public Course getCourse(int id) {
        return this.courses.get(id);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public Student getStudent(int id){
        return this.students.get(id);
    }

    public void listCourses () {
        for (int j = 0; j < courses.size(); j++) {
            System.out.println(j + ") "  + courses.get(j).getInformation());
        }
    }

    public void listStudents () {
        for (int j = 0; j < students.size(); j++) {
            System.out.println(j + ") " + students.get(j).getInformation());
        }
    }

    public void enrollStudents(Student student, Course course){
        Enrollment enrollment = new Enrollment(course, student);
        this.enrollments.add(enrollment);
    }

    public ArrayList<Enrollment> getEnrollments(Course course){
        ArrayList<Enrollment> enr = new ArrayList<>();

        for (int j = 0; j < enrollments.size(); j++) { 

            if(enrollments.get(j).getCourse() == course){
                enr.add(enrollments.get(j));
            }            
        }

        return enr;
    }

    public ArrayList<Enrollment> getEnrollments(Student student){
        ArrayList<Enrollment> enr2 = new ArrayList<>();

        for (int j = 0; j < enrollments.size(); j++) { 
            
            if(enrollments.get(j).getStudent() == student){
                enr2.add(enrollments.get(j));
            }            
        }

        return enr2;
    }

    }


