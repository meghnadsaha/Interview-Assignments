package com.coding.tietoevry;


import javax.annotation.processing.Generated;
import java.util.HashSet;
import java.util.Set;

interface MyInterface {

    default void defaultMethod () {
        System.out.println("Default method...");
    }

    static void staticMethod () {
        System.out.println("static method...");
    }
}

//    //    1.	write an interface with default and static method?
//    public static void main1 ( String[] args ) {
//        TietoevryMain obj = new TietoevryMain();
//        obj.defaultMethod();
//        MyInterface.staticMethod();
//    }

class Student {

    private Long id;

    private String name;
    private Set<Course> courses = new HashSet<>();

    public void addCourse ( Course course ) {
        courses.add(course);
        course.getStudents().add(this);
    }


    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public Set<Course> getCourses () {
        return courses;
    }

    public void setCourses ( Set<Course> courses ) {
        this.courses = courses;
    }

    public Student ( String name ) {
        this.name = name;
    }


}


class Course {

    private Long id;
    private String name;
    private Set<Student> students = new HashSet<>();


    public void addStudent( Student student ) {
        students.add(student);
        student.getCourses().add(this);
    }

    public Course ( String name ) {
        this.name = name;
    }

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public Set<Student> getStudents () {
        return students;
    }

    public void setStudents ( Set<Student> students ) {
        this.students = students;
    }


}


class Enrollment {

//    @Id
//    @GeneratedValue(strategy = GeneratedType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "student_id")
    private Student student;

//    @ManyToOne
//    @JoinColumn(name = "Course_id")
    private Course course;

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public Student getStudent () {
        return student;
    }

    public void setStudent ( Student student ) {
        this.student = student;
    }

    public Course getCourse () {
        return course;
    }

    public void setCourse ( Course course ) {
        this.course = course;
    }


}

public class TietoevryMain {
    //implements MyInterface {


    public static void main ( String[] args ) {
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");


        Course course1 = new Course("Math");
        Course course2 = new Course("Math");

        student1.addCourse(course1);
        student1.addCourse(course2);
        student2.addCourse(course1);

        course1.addStudent(student1);
        course1.addStudent(student2);
        course2.addStudent(student1);


        System.out.println(course1);

    }



}
