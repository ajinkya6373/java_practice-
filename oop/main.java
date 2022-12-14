package oop;

import java.util.ArrayList;
import java.util.Arrays;


public class main {
    public static void main(String[] args) {
        // store roll no
        int [] numbers = new int[5];
        // store 5 name
        String [] names = new String[5];

//        // data of 5 student :{roll no , name , marks}
//        Student [] students = new Student[5]; // declaration of array of objects of type student
//        System.out.println(Arrays.toString(students));
//        Student ajinkya = new Student(); // declaration  objects of type student
//        ajinkya.rno=36;
//        Student b; // declare reference variable b of class Student
//        b= new Student(); // create object of class Student
//        b.marks=50; // create instance of class Student
//        System.out.println(ajinkya.rno);
//        System.out.println(b.marks);


        // same reference  variable pointing to same  object;
//        ArrayList<Integer>roll = new ArrayList<>(5);
//        roll.add(34);
//        roll.add(35);
//        ArrayList<Integer>A =new ArrayList<>(5);
//        A =roll;
//        A.add(23);
//        System.out.println(A);
//        System.out.println(roll);



        Student student1 = new Student(36, "ajinkya", 89);
        Student student2 = new Student(12,"shekhar", 78);
        Student student3 =new Student();
//        System.out.println(student1.marks);
//        System.out.println(student2.marks);
//        System.out.println(student3.name);
//        student1.greeting();
//        student2.greeting();
//        student2.greeting();
//        System.out.println(student1.numberOFstudent);
//        System.out.println(student2.numberOFstudent);
//        System.out.println(student3.numberOFstudent);

        //access static variable like below
        System.out.println(Student.numberOFstudent);
        System.out.println(Student.age());
    }

   public static void greeting(){
        System.out.println("hello");
    }
}


// create class
 class  Student{
    int rno;
    String name;
    float marks;
    static long numberOFstudent;   // static variable is same for all objects
   static void  greeting(){
        System.out.println("hello ");
    }

    static  int age(){
       return  11;
    }


    Student(){
        // call constructor from another constructor
        this (0,"default name", 0.0f);
    }
    //constructor
    Student(int roll, String name, float marks){
       this.rno =roll;
       this.name=name;
       this.marks=marks;
       Student.numberOFstudent +=1;
    }




}

