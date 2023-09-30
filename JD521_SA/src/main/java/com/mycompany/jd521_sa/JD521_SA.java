/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jd521_sa;

/**
 *
 * @author Xandr
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class JD521_SA {
    private static Student[] students;
    private static Scanner in;

    // Method to create students based on user input
    public static void createStudents() {
        in = new Scanner(System.in);

        System.out.println("Amount of students in JD521: ");
        int jd = getIntInput();
        System.out.println("Amount of students in PRG521: ");
        int prg = getIntInput();
        System.out.println("Amount of students in SLD521: ");
        int sld = getIntInput();

        students = new Student[jd + prg + sld];

        // Create students for JD521
        for (int k = 0; k < jd; k++) {
            if (k == 0) {
                System.out.println("\nJD521:");
            }

            System.out.println("\nStudent: " + (k + 1));

            System.out.println("Please enter the marks for FA1: ");
            int fa1 = getIntInput();
            System.out.println("Please enter the marks for FA2: ");
            int fa2 = getIntInput();
            System.out.println("Please enter the marks for FA3: ");
            int fa3 = getIntInput();

            students[k] = new Student(k + 1, "JD521", fa1, fa2, fa3);
        }

        // Create students for PRG521
        for (int k = jd; k < jd + prg; k++) {
            if (k == jd) {
                System.out.println("\nPRG521:");
            }

            System.out.println("\nStudent: " + (k - jd + 1));

            System.out.println("Please enter the marks for FA1: ");
            int fa1 = getIntInput();
            System.out.println("Please enter the marks for FA2: ");
            int fa2 = getIntInput();
            System.out.println("Please enter the marks for FA3: ");
            int fa3 = getIntInput();

            students[k] = new Student(k - jd + 1, "PRG521", fa1, fa2, fa3);
        }

        // Create students for SLD521
        for (int k = jd + prg; k < jd + prg + sld; k++) {
            if (k == jd + prg) {
                System.out.println("\nSLD521:");
            }

            System.out.println("\nStudent: " + (k - jd - prg + 1));

            System.out.println("Please enter the marks for FA1: ");
            int fa1 = getIntInput();
            System.out.println("Please enter the marks for FA2: ");
            int fa2 = getIntInput();
            System.out.println("Please enter the marks for FA3: ");
            int fa3 = getIntInput();

            students[k] = new Student(k - jd - prg + 1, "SLD521", fa1, fa2, fa3);
        }
    }

    // Method to get integer input from the user with error handling
    private static int getIntInput() {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                input = in.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                in.next(); // Clear the invalid input from the scanner
            }
        }

        return input;
    }

    // Method to display marks for a specific module
    public static void displayMarks() {
        in = new Scanner(System.in);
        
        String course = "";
        
        // Prompt the user until valid input is provided
        while (true) {
            System.out.println("\nWhich module do you wish to display? (JD521, PRG521, SLD521)");
            course = in.nextLine();

            if (course.equalsIgnoreCase("JD521") || course.equalsIgnoreCase("PRG521") ||
                    course.equalsIgnoreCase("SLD521")) {
                break; // Break the loop if valid input is provided
            } else {
                System.out.println("Invalid module name! Please try again.");
            }
        }

        String displayname = "";
        int lowest = 101, highest = -1;

        // Assign display name based on the selected module
        if (course.equalsIgnoreCase("JD521")) {
            displayname = "Beginner Java [JD521]";
        } else if (course.equalsIgnoreCase("PRG521")) {
            displayname = "Programming with C# [PRG521]";
        } else if (course.equalsIgnoreCase("SLD521")) {
            displayname = "Solutions Development [SLD521]";
        }

        System.out.println("\nWelcome to CTU Marks for\n" + displayname);
        System.out.println("\nThe marks are: \n");
        System.out.println("\t\tFormative1\tFormative2\tFormative3\tAverage");

        // Iterate through the students and display marks for the selected module
        for (int k = 0; k < students.length; k++) {
            if (students[k].getCourse().equalsIgnoreCase(course)) {
                int id = students[k].getid();
                int[] marks = students[k].getMarks();
                double avg = students[k].getAverageMarks();
                String displaystring = "Student " + id + "\t" + marks[0] + "\t\t" + marks[1] + "\t\t" + marks[2] + "\t\t"
                        + Math.round(avg * 100) / 100.0;

                System.out.println(displaystring);

                // Update lowest and highest marks
                if (marks[0] < lowest) {
                    lowest = marks[0];
                }
                if (marks[1] < lowest) {
                    lowest = marks[1];
                }
                if (marks[2] < lowest) {
                    lowest = marks[2];
                }

                if (marks[0] > highest) {
                    highest = marks[0];
                }
                if (marks[1] > highest) {
                    highest = marks[1];
                }
                if (marks[2] > highest) {
                    highest = marks[2];
                }
            }
        }

        if (lowest != 101) {
            System.out.println("\nLowest mark in the mark application is " + lowest);
        } else {
            System.out.println("\nData not available");
        }

        if (highest != -1) {
            System.out.println("Highest mark in the mark application is " + highest + "\n");
        } else {
            System.out.println("Data not available");
        }
    }

    // Method to display the mark distribution
    public static void displayMarkDistribution() {
        System.out.println("\nMark distribution: ");
        String[] lines = new String[11];

        for (int k = 0; k < lines.length; k++)
            lines[k] = new String("");

        // Iterate through the students and distribute marks into ranges
        for (int k = 0; k < students.length; k++) {
            int[] marks = students[k].getMarks();
            for (int j = 0; j < 3; j++) {
                if (marks[j] >= 0 && marks[j] < 10) {
                    lines[0] += "[*]";
                } else if (marks[j] >= 10 && marks[j] < 20) {
                    lines[1] += "[*]";
                } else if (marks[j] >= 20 && marks[j] < 30) {
                    lines[2] += "[*]";
                } else if (marks[j] >= 30 && marks[j] < 40) {
                    lines[3] += "[*]";
                } else if (marks[j] >= 40 && marks[j] < 50) {
                    lines[4] += "[*]";
                } else if (marks[j] >= 50 && marks[j] < 60) {
                    lines[5] += "[*]";
                } else if (marks[j] >= 60 && marks[j] < 70) {
                    lines[6] += "[*]";
                } else if (marks[j] >= 70 && marks[j] < 80) {
                    lines[7] += "[*]";
                } else if (marks[j] >= 80 && marks[j] < 90) {
                    lines[8] += "[*]";
                } else if (marks[j] >= 90 && marks[j] < 100) {
                    lines[9] += "[*]";
                } else {
                    lines[10] += "[*]";
                }
            }
        }

        // Print the mark distribution
        for (int k = 0; k < lines.length; k++) {
            int lower = k * 10;
            int upper = (k * 10) + 9;

            if (lower == 0) {
                System.out.println("\n  0-" + upper + ": " + lines[k]);
            } else if (k == 10) {
                System.out.println("  100: " + lines[k]);
            } else {
                System.out.println(lower + "-" + upper + ": " + lines[k]);
            }
        }
    }

    public static void main(String[] args) {
        createStudents();
        displayMarks();
        displayMarkDistribution();
        in.close();
    }
}



