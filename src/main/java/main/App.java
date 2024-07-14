package main;

import java.util.List;
import java.util.Scanner;


/**
    Tehdään kerran alussa:
        1. git init
        2. git remote add origin .... (kopioi GitHub repositoryn sivulta)
        3. git branch -M main

    Tehdään aina kun halutaan tallentaa lokaalit muutokset GitHubiin:
        1.  git add .
        2.  git commit -m "VIESTI_TÄHÄN"
        3.  git push origin main   
   */
public class App 
{
    public static void main( String[] args )
    {   
        Scanner sc = new Scanner(System.in);

        System.out.println("Tervetuloa Gifu-järjestelmään");
        System.out.println("Mille yliopistolle haluat ottaa järjestelmän käyttöön?");
        String stringInput = sc.nextLine();
        Gifu gifu = new Gifu(stringInput);

        boolean exit = false;
        while(!exit) {
            System.out.println("1) Luo uusi kurssi, 2) Luo uusi opiskelija, 3) Listaa kurssit, 4) Listaa opiskelijat, 5) Lisää opiskelija kurssille, 6) Anna kurssiarvosanat, 7) Listaa kurssilla olevat opiskelijat, 8) Listaa opiskelijan arvosanat, 9) Listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat, 0) Lopeta ohjelma");

            if(sc.hasNext()) {
                int i = 0;
                stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);

                switch(i) {
                    case 1:
                        System.out.println("Anna kurssin nimi:");
                        String courseName = sc.nextLine();
                        System.out.println("Anna kurssin ID:");
                        String courseId = sc.nextLine();
                        System.out.println("Anna kurssin maksimi opiskelijamäärä:");
                        int maxStudents = Integer.parseInt(sc.nextLine());

                        Course course = new Course(maxStudents, courseName, courseId);
                        gifu.addCourse(course);
                        break;

                    case 2:
                        System.out.println("Anna opiskelijan nimi:");
                        String studentName = sc.nextLine();
                        System.out.println("Anna opiskelijan opiskelijanumero:");
                        String studentNumber = sc.nextLine();

                        Student newStudent = new Student(studentName, studentNumber);
                        gifu.addStudent(newStudent);
                        break;
                    case 3:
                        gifu.listCourses();
                        break;
                    case 4:
                        gifu.listStudents();
                        break;
                    case 5:
                        //Lisää opiskelija kurssille
                        gifu.listCourses();
                        System.out.println("Mille kurssille haluat lisätä opiskelijan? Syötä kurssin numero:");
                        int courseNumber = Integer.parseInt(sc.nextLine());
                        Course c = gifu.getCourse(courseNumber);

                        gifu.listStudents();
                        System.out.println("Minkä opiskelijan haluat lisätä kurssille? Syötä opiskelijan numero:");
                        int studentNumber5 = Integer.parseInt(sc.nextLine());
                        Student s = gifu.getStudent(studentNumber5);

                        gifu.enrollStudents(s, c);
                    break;
                    case 6:
                        // anna kurssi arvosanat
                        gifu.listCourses();
                        System.out.println("Minkä kurssin haluat arvostella? Syötä kurssin numero:");
                        int cNum = Integer.parseInt(sc.nextLine());
                        Course c6 = gifu.getCourse(cNum);
                        List<Enrollment> ennroList = gifu.getEnrollments(c6);

                        for (int j = 0; j < ennroList.size(); j++) {
                            Enrollment e = ennroList.get(j);
                            Student ennroStudent = e.getStudent();
                            System.out.println("Anna arvosana opiskelijalle " +ennroStudent.getInformation());
                            int grad = Integer.parseInt(sc.nextLine());
                            e.gradeCourse(grad);
                        }
                    
                        break;
                    case 7:
                        // Listaa kurssilla olevat opiskelijat
                        gifu.listCourses();
                        System.out.println("Minkä kurssin opiskelijat haluat listata? Syötä kurssin numero:");
                        int cNum7 = Integer.parseInt(sc.nextLine());
                        Course c7 = gifu.getCourse(cNum7);
                        List<Enrollment> ennroList7 = gifu.getEnrollments(c7);

                        for (int j = 0; j < ennroList7.size(); j++) {
                            Enrollment e = ennroList7.get(j);
                            Student ennroStudent = e.getStudent();                            
                            System.out.println(ennroStudent.getInformation()+ ", arvosana: " + e.getGrade());
                        }

                        break;
                    case 8:
                        // Listaa opiskelijan arvosanat
                        gifu.listStudents();
                        System.out.println("Minkä opiskelijan arvosanat haluat listata? Syötä opiskelijan numero:");
                        int sNum = Integer.parseInt(sc.nextLine());
                        Student s8 = gifu.getStudent(sNum);
                        List<Enrollment> ennroList8 = gifu.getEnrollments(s8);
                        System.out.println("Opiskelijan " + s8.getInformation()+" arvosanat:");

                        for (int j = 0; j < ennroList8.size(); j++) {
                            Enrollment e = ennroList8.get(j);
                            Course ennCourse = e.getCourse();
                            System.out.println(ennCourse.getInformation()+ ", arvosana: " + e.getGrade());
                        }

                        break;
                    case 9:
                        // Listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat
                        List<Course> cAll = gifu.getCourses();

                        for (int j = 0; j < cAll.size(); j++) {
                            Course c9 = cAll.get(j);
                            List<Enrollment> ennroList9 = gifu.getEnrollments(c9);
                            System.out.println(c9.getInformation());
                            for (int y = 0; y < ennroList9.size(); y++) {
                                Enrollment e = ennroList9.get(y);
                                Student ennroStudent = e.getStudent();                            
                                System.out.println(ennroStudent.getInformation()+ ", arvosana: " + e.getGrade());
                            }
                        }

                        break;
                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;
                        break;
                    default:
                        System.out.println("Syöte oli väärä");
                        break;
                }
             }  
               
        } 
        sc.close();  
    }
      
}  
