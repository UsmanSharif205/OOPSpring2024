/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package uni.demoproject;

/**
 *
 * @author Umar
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DemoProject {
    private static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        ArrayList<Student> students = readStudentsFromFile(FILE_NAME);
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Add new student");
            System.out.println("2. Show all students");
            System.out.println("3. Update a student");
            System.out.println("4. Delete a student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(students, scanner);
                    break;
                case 2:
                    showAllStudents(students);
                    break;
                case 3:
                    updateStudent(students, scanner);
                    break;
                case 4:
                    deleteStudent(students, scanner);
                    break;
                case 5:
                    saveStudentsToFile(students, FILE_NAME);
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }
        scanner.close();
    }

    private static ArrayList<Student> readStudentsFromFile(String fileName) {
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

    private static void saveStudentsToFile(ArrayList<Student> students, String fileName) {
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

    private static void addStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        System.out.print("Enter SAP ID: ");
        String sapID = scanner.next();
        boolean isUnique = students.stream().noneMatch(student -> student.getSapID().equals(sapID));
        if (isUnique) {
            students.add(new Student(firstName, lastName, sapID));
            saveStudentsToFile(students, FILE_NAME);
            System.out.println("Student added successfully!");
        } else {
            System.out.println("SAP ID must be unique. Student not added.");
        }
    }

    private static void showAllStudents(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static void updateStudent(ArrayList<Student> students, Scanner scanner) {
        if (students.isEmpty()) {
            System.out.println("No students available to update.");
            return;
        }
        System.out.print("Enter SAP ID of the student to update: ");
        String updateSapID = scanner.next();
        Student studentToUpdate = null;
        for (Student student : students) {
            if (student.getSapID().equals(updateSapID)) {
                studentToUpdate = student;
                break;
            }
        }
        if (studentToUpdate == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println("Update Menu:");
        System.out.println("1. Update SAP ID");
        System.out.println("2. Update first name");
        System.out.println("3. Update last name");
        System.out.println("4. Update everything");
        System.out.println("5. Go back");
        System.out.print("Enter your choice: ");
        int updateChoice = scanner.nextInt();
        switch (updateChoice) {
            case 1:
                System.out.print("Enter new SAP ID: ");
                String newSapID = scanner.next();
                boolean isUniqueID = students.stream().noneMatch(student -> student.getSapID().equals(newSapID));
                if (isUniqueID) {
                    studentToUpdate.setSapID(newSapID);
                    saveStudentsToFile(students, FILE_NAME);
                    System.out.println("SAP ID updated successfully!");
                } else {
                    System.out.println("SAP ID must be unique. Update failed.");
                }
                break;
            case 2:
                System.out.print("Enter new first name: ");
                String newFirstName = scanner.next();
                studentToUpdate.setFirstName(newFirstName);
                saveStudentsToFile(students, FILE_NAME);
                System.out.println("First name updated successfully!");
                break;
            case 3:
                System.out.print("Enter new last name: ");
                String newLastName = scanner.next();
                studentToUpdate.setLastName(newLastName);
                saveStudentsToFile(students, FILE_NAME);
                System.out.println("Last name updated successfully!");
                break;
            case 4:
                System.out.print("Enter new SAP ID: ");
                String updatedSapID = scanner.next();
                boolean isUniqueUpdatedID = students.stream().noneMatch(student -> student.getSapID().equals(updatedSapID));
                if (isUniqueUpdatedID) {
                    studentToUpdate.setSapID(updatedSapID);
                    System.out.print("Enter new first name: ");
                    String updatedFirstName = scanner.next();
                    studentToUpdate.setFirstName(updatedFirstName);
                    System.out.print("Enter new last name: ");
                    String updatedLastName = scanner.next();
                    studentToUpdate.setLastName(updatedLastName);
                    saveStudentsToFile(students, FILE_NAME);
                    System.out.println("Student updated successfully!");
                } else {
                    System.out.println("SAP ID must be unique. Update failed.");
                }
                break;
            case 5:
                System.out.println("Going back...");
                break;
            default:
                System.out.println("Invalid choice. Please enter a number from 1 to 5.");
        }
    }

    private static void deleteStudent(ArrayList<Student> students, Scanner scanner) {
        if (students.isEmpty()) {
            System.out.println("No students available to delete.");
            return;
        }
        System.out.print("Enter SAP ID of the student to delete: ");
        String deleteSapID = scanner.next();
        boolean removed = students.removeIf(student -> student.getSapID().equals(deleteSapID));
        if (removed) {
            saveStudentsToFile(students, FILE_NAME);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }
}
