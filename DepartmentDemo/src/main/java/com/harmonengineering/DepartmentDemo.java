package com.harmonengineering;

import java.util.*;



class Student
{
    public String firstName ;
    public String lastName ;
    Student ( String firstName, String lastName )
    {
        this.firstName = firstName ;
        this.lastName = lastName ;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Student student = (Student) o;
        return Objects.equals( this.lastName, student.lastName) ;
    }
    @Override
    public int hashCode()
    {
        return Objects.hash( this.lastName);
    }
}
class Department
{
    static class StudentMark
    {
        StudentMark( Student student, Integer mark ) { this.mark = mark ; this.student = student ; }
        Student student ; Integer mark ;
    }

    private final HashMap< String, StudentMark> studentMap = new HashMap<>() ;

    private final HashMap< Student, Integer> studentMap2 = new HashMap<>() ;

    public void addStudent( Student student, Integer studentMark )
    {
        studentMap.put( student.lastName, new StudentMark( student, studentMark ) ) ;
        studentMap2.put( student, studentMark) ;
    }
    public void listStudents()
    {
        Iterator<Map.Entry<String,StudentMark>> i = studentMap.entrySet().iterator();
        while( i.hasNext() )
        {
            Map.Entry<String,StudentMark> entry = i.next() ;
            Student s = entry.getValue().student;
            Integer m = entry.getValue().mark ;
            System.out.println( s.firstName +
                    "\t" + s.lastName +
                    "\t" + m )  ;
        }
    }
    public void listStudents2()
    {
        Iterator<Map.Entry<Student,Integer>> i = studentMap2.entrySet().iterator();
        while( i.hasNext() )
        {
            Map.Entry<Student,Integer> entry = i.next() ;
            Student s = entry.getKey() ;
            Integer m = entry.getValue() ;
            System.out.println( s.firstName +
                    "\t" + s.lastName +
                    "\t" + m )  ;
        }
    }
}
public class DepartmentDemo
{
    public static void main( String[] args )
    {
        Department d = new Department() ;
        Student s = new Student( "Henry", "Jones") ;
        d.addStudent(s,92 ) ;
        d.addStudent( new Student( "Jane", "Fonda"), 69);
        d.addStudent( new Student( "Henry", "Fonda"), 78);
        d.listStudents();
        System.out.println() ;
        d.listStudents2();
    }
}
