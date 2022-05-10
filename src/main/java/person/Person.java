package person;

import interfaces.IPay;

import java.util.Scanner;

public class Person implements IPay {
    //Fields
    private String firstName;
    private String lastName;
    private int phoneNo;

    //Constructors
    public Person() {
    }

    public Person(String firstName, String lastName, int phoneNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
    }

    //Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    // To String
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNo=" + phoneNo +
                '}';
    }

    //Methods
    public void addPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First Name: ");
        this.firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        this.lastName = scanner.nextLine();
        System.out.print("Phone No: ");
        this.phoneNo = scanner.nextInt();
    }

    @Override
    public void pay() {
        System.out.println("This is where you pay, enter the amount to pay:");
    }
}

