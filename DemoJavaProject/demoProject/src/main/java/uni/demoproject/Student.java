/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.demoproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Umar
 */
public class Student {
    private String firstName;
    private String lastName;
    private String sapID;

    // Constructor
    public Student(String firstName, String lastName, String sapID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sapID = sapID;
    }

    // Getter for firstName
    public String getFirstName() {
        return firstName;
    }

    // Setter for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter for lastName
    public String getLastName() {
        return lastName;
    }

    // Setter for lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter for sapID
    public String getSapID() {
        return sapID;
    }

    // Setter for sapID
    public void setSapID(String sapID) {
        this.sapID = sapID;
    }

    public static void writeStudentsToFile(ArrayList<Student> students, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Student student : students) {
                writer.write(student.getSapID());
                writer.newLine();
                writer.write(student.getFirstName());
                writer.newLine();
                writer.write(student.getLastName());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    
        public static ArrayList<Student> readStudentsFromFile(String fileName) {
        ArrayList<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String sapID;
            String firstName;
            String lastName;

            while ((sapID = reader.readLine()) != null) {
                firstName = reader.readLine();
                lastName = reader.readLine();
                students.add(new Student(firstName, lastName, sapID));
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

        return students;
    }
   @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sapID='" + sapID + '\'' +
                '}';
    }
}

