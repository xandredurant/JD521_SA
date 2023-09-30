/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jd521_sa;
/**
 *
 * @author Xandr
 */

/**
 * This class represents a Student.
 */
public class Student {
    private int id;                 // Student ID
    private String course;          // Course name
    private int[] marks = new int[3];   // Array to store marks for 3 formative assessments
    private double averagemarks;    // Average marks
    
    /**
     * Default constructor for the Student class.
     */
    public Student(){
        id = 0;
        this.course = "Empty";
        marks[0] = 0; 
        marks[1] = 0; 
        marks[2] = 0;
        averagemarks = 0;
    }
            
    /**
     * Constructor for the Student class.
     * @param id Student ID
     * @param course Course name
     * @param fa1 Marks for formative assessment 1
     * @param fa2 Marks for formative assessment 2
     * @param fa3 Marks for formative assessment 3
     */
    public Student(int id, String course, int fa1, int fa2, int fa3){
        this.id = id;
        this.course = course;
        marks[0] = fa1; 
        marks[1] = fa2; 
        marks[2] = fa3;
        averagemarks = (fa1+fa2+fa3)/3.0;
    }
    
    /**
     * Sets the ID of the student.
     * @param id Student ID
     */
    public void setID(int id){
        this.id = id;
    }
    
    /**
     * Sets the course of the student.
     * @param course Course name
     */
    public void setCourse(String course){
        this.course = course;
    }
    
    /**
     * Sets the marks for the student's formative assessments.
     * @param fa1 Marks for formative assessment 1
     * @param fa2 Marks for formative assessment 2
     * @param fa3 Marks for formative assessment 3
     */
    public void setMarks(int fa1, int fa2, int fa3){
        marks[0] = fa1; 
        marks[1] = fa2; 
        marks[2] = fa3;
        averagemarks = (fa1+fa2+fa3)/3.0;
    }
    
    /**
     * Returns the ID of the student.
     * @return Student ID
     */
    public int getid(){
        return this.id;
    }
    
    /**
     * Returns the course of the student.
     * @return Course name
     */
    public String getCourse(){
        return this.course;
    }
    
    /**
     * Returns the marks for the student's formative assessments.
     * @return Array of marks
     */
    public int[] getMarks(){
        return this.marks;
    }
    
    /**
     * Returns the average marks of the student.
     * @return Average marks
     */
    public double getAverageMarks(){
        return this.averagemarks;
    }
}

