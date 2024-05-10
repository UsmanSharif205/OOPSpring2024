// Inheritance Questions and Java Solutions

//1. Animal Sounds:
//Question: Create a class Animal with a method makeSound() that prints "Generic Animal Sound". Create subclasses Dog and Cat that inherit from Animal and override makeSound() to print "Woof" and "Meow" respectively.

//Solution:

class Animal {
  public void makeSound() {
    System.out.println("Generic Animal Sound");
  }
}

class Dog extends Animal {
  @Override
  public void makeSound() {
    System.out.println("Woof");
  }
}

class Cat extends Animal {
  @Override
  public void makeSound() {
    System.out.println("Meow");
  }
}

public class Main {
  public static void main(String[] args) {
    Animal animal = new Animal();
    animal.makeSound(); // Generic Animal Sound

    Dog dog = new Dog();
    dog.makeSound(); // Woof

    Cat cat = new Cat();
    cat.makeSound(); // Meow
  }
}

/*
// 2. Employee Hierarchy:

// Question: Create a class Person with attributes firstName and lastName. Create a subclass Employee that inherits from Person and adds an attribute employeeId. Override the lastName method in Employee to return the last name with a job title appended.

// Solution:

class Person {
  private String firstName;
  private String lastName;

  // Getters and Setters for firstName and lastName
}

class Employee extends Person {
  private int employeeId;

  public Employee(String firstName, String lastName, int employeeId) {
    super(firstName, lastName); // Call superclass constructor
    this.employeeId = employeeId;
  }

  @Override
  public String getLastName() {
    return super.getLastName() + " (Employee)";
  }

  // Getters and Setters for employeeId
}

public class Main {
  public static void main(String[] args) {
    Employee emp = new Employee("John", "Doe", 1234);
    System.out.println(emp.getFirstName()); // John
    System.out.println(emp.getLastName()); // Doe (Employee)
  }
}

// 3. Shape Calculations:

// Question: Create an abstract class Shape with an abstract method getArea(). Create subclasses Circle and Square that inherit from Shape and implement the getArea() method to calculate their respective areas.

// Solution:

abstract class Shape {
  public abstract double getArea();
}

class Circle extends Shape {
  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return Math.PI * radius * radius;
  }
}

class Square extends Shape {
  private double side;

  public Square(double side) {
    this.side = side;
  }

  @Override
  public double getArea() {
    return side * side;
  }
}

public class Main {
  public static void main(String[] args) {
    Shape circle = new Circle(5);
    System.out.println("Circle Area: " + circle.getArea());

    Shape square = new Square(4);
    System.out.println("Square Area: " + square.getArea());
  }
}
*/
