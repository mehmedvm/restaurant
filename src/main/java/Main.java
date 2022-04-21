import person.Person;
import restaurant.breakfast.BreakfastItem;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

    ////Class Fields
    private static final Scanner scanner = new Scanner(System.in);
    private static final Path filePath = Paths.get("C:\\java-Training\\java-projects\\restaurant\\restaurant\\src\\main\\resources\\register.txt");
    private static Person person1 = new Person();
    //Breakfast
    private static List<BreakfastItem> BreakfastMenuArray = new ArrayList<BreakfastItem>();
    private static BreakfastItem egg1 = new BreakfastItem("Egg","Sunny Side Up",4);
    private static BreakfastItem cheese1 = new BreakfastItem("Cheese","Feta",5);
    private static BreakfastItem crepe1 = new BreakfastItem("Crepe","With Nutella",6);
    //Check total
    private static Integer CheckTotal = 0;



    ////////////////////// Main Method //////////////////////////////
    public static void main(String[] args) {
        System.out.println("\nWelcome to Acme Restaurant!!!");

        // Menu1 (1- Manager Entry / 2- Customer Entry
        menuEntry();


        /// Excercise Start ///
        //Add Breakfast Menu "BreakfastItem" objects to "BreakfastMenuArray" ArrayList
        BreakfastMenuArray.add(egg1);
        BreakfastMenuArray.add(cheese1);
        BreakfastMenuArray.add(crepe1);
        System.out.println(BreakfastMenuArray);

        //Calculating the "CheckTotal" for things in BreakfastMenuArray ArrayList
        for (BreakfastItem breakfastItem: BreakfastMenuArray) {
            System.out.println("Breakfast Item Price: "+breakfastItem.getPrice());
            CheckTotal = CheckTotal + breakfastItem.getPrice();
        }
        System.out.println(CheckTotal);
        /// Excercise End ///


    }

    ////////////////// MENU ENTRY ////////////////////////////
    public static void menuEntry() {
        while(true) {
            switch (pickMenuEntry()) {
                case 1:
                    System.out.println("You selected Manager Entry...");
                    break;
                case 2:
                    System.out.println("You selected Customer Entry...");
                    register();
                    foodMenu();
                    break;
                case 3:
                    System.out.println("You selected to exit...");
                    System.exit(0);
            }
        }

    }

    public static int pickMenuEntry() {
        System.out.println("""
                \nENTRY MENU
                1- Manager Entry
                2- Customer Entry
                3- Exit\n
                """);
        return scanner.nextInt();
    }


    ///////////// Register ///////////////////////////////////////
    public static void register() {
        System.out.println("Let's get you registered for the waiting list");
        person1.addPerson();


        //Create file
        //if (createdFilePath != null) {
        if (Files.exists(filePath)) {
            System.out.println("\nFile already exists.");
        } else {
            System.out.println("\nCalling the create a file method...");
            createAFile();
        }

        //Update the file with the registered person
        System.out.println("\nCalling the update a file method...");
        //writeToAFile(firstName,lastName,age,userID,password);
        writeToAFile(person1);

        //Read from the file
        System.out.println("\nCalling the read a file method...");
        readFromAFile(person1);

    }


    //Creating file
    public static void createAFile() {
        try {
            Files.createFile(filePath);
            System.out.println("File created: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Write to a file
    public static void writeToAFile(Person person1)  {
        try {
            //Files.writeString(filePath, person1.getFirstName() + "\n");
            Files.writeString(filePath, person1.getFirstName() + "," + "\n");
            Files.writeString(filePath, person1.getLastName() + "," + "\n", StandardOpenOption.APPEND);
            Files.writeString(filePath, String.valueOf(person1.getPhoneNo()) + "," + "\n", StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Read from a file
    public static void readFromAFile(Person person1) {
        try {
            String tempFile = Files.readString(filePath);
            //System.out.println(Arrays.toString(tempFile.split(",")));
            // Transfer the file fields to an array...
            String[] tempArray = tempFile.split(","+"\n");
            //If you have multiple records in one file, you can have secondary delimiter like ";" or "\r\n"
            // String[] tempArray2 = tempFile.split(";");

            System.out.println("File/Record created for: " + tempArray[0] + " " + tempArray[1]);
            System.out.println("Phone No: " + tempArray[2]);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    ////////////////// FOOD MENU //////////////////////////////
    public static void foodMenu() {
        boolean whileCheck = true;
        while(whileCheck) {
            switch (pickFoodMenu()) {
                case 01:
                    System.out.println("You selected: Egg - Sunny side up  ($4)");
                    BreakfastMenuArray.add(egg1);
                    break;
                case 02:
                    System.out.println("You selected: Cheese - Feta  ($5)");
                    BreakfastMenuArray.add(cheese1);
                    break;
                case 03:
                    System.out.println("You selected: Crepe - with Nutella  ($6)");
                    BreakfastMenuArray.add(crepe1);
                    break;
                case 90:
                    System.out.println("You selected: Show all selected food and total");
                    //System.out.println(BreakfastMenuArray);
                    for (BreakfastItem breakfastItem: BreakfastMenuArray) {
                        System.out.println("Breakfast Item: " + breakfastItem.getItemName() + " " + breakfastItem.getItemNote() + " $" + breakfastItem.getPrice());
                        CheckTotal = CheckTotal + breakfastItem.getPrice();
                        }
                    System.out.println("Check Total:" + CheckTotal);
                    scanner.next();
                    break;
                case 99:
                    System.out.println("You selected to exit...");
                    System.exit(0);
                default:
                    System.out.println("Please select food menu code");
            }
        }

    }

    public static int pickFoodMenu() {
        System.out.println("""
                \nFOOD MENU
                Breakfast
                    01-Egg (Sunny side up)  ($4)
                    02-Cheese (Feta)  ($5)
                    03-Crepe (with Nutella)  ($6)
                Lunch
                    04-Kebab
                    05-Kefir
                    06-Salad
                Dinner
                    07-Steak
                    08-Soda
                    09-Salad
                90 - Show all selected food and check total
                99 - Exit
                """);
        return scanner.nextInt();
    }



}
