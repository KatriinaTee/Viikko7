package main;

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
        System.out.println("Tervetuloa Gifu-järjestelmään");
        System.out.println("Mille yliopistolle haluat ottaa järjestelmän käyttöön?")
        String stringInput = sc.nextLine();
        University university = new University(stringInput);

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
                    int courseId = Integer.parseInt(sc.nextLine());
                    System.out.println("Anna kurssin maksimi opiskelijamäärä:");
                    int maxStudents = Integer.parseInt(sc.nextLine());


                    case 2:
                    System.out.println("Anna opiskelijan nimi:");
                    String studentName = sc.nextLine();
                    System.out.println("Anna opiskelijan opiskelijanumero:");
                    int studentNumber = Integer.parseInt(sc.nextLine());

                    Student newStudent = new Student(name, number);
                    university.addStudent(newStudent);

    }
}
