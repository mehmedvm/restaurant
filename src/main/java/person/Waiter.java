package person;

import java.util.Scanner;

public class Waiter extends Person {
    //Fields
    private String employeeID;
    private String shift;

    //Constructors
    public Waiter() {
    }

    public Waiter(String employeeID, String shift) {
        this.employeeID = employeeID;
        this.shift = shift;
    }

    public Waiter(String firstName, String lastName, int phoneNo, String employeeID, String shift) {
        super(firstName, lastName, phoneNo);
        this.employeeID = employeeID;
        this.shift = shift;
    }

    //Getters and Setters
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    //To String


    @Override
    public String toString() {
                return  "Waiter{" +
                        ", Name='" + this.getFirstName() +
                        ", LastName: '" + this.getLastName() +
                        ", employeeID='" + employeeID + '\'' +
                        ", shift='" + shift + '\'' +
                        '}';
    }



    //Methods
    public void addWaiter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First Name: ");
        this.setFirstName(scanner.nextLine());
        System.out.print("Last Name: ");
        this.setLastName(scanner.nextLine());
        System.out.print("Phone No: ");
        this.setPhoneNo(scanner.nextInt());
           scanner.nextLine();
        System.out.print("Waiter Employee ID: ");
        this.employeeID = scanner.nextLine();
        System.out.print("Waiter Shift: ");
        this.shift = scanner.nextLine();
    }
}
