import interfaces.IPay;
import person.Person;
import person.Waiter;
import restaurant.breakfast.BreakfastItem;
import restaurant.dinner.DinnerItem;
import restaurant.lunch.LunchItem;

import javax.xml.transform.Source;
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
    private static final Path filePath = Paths.get("C:\\java-Training\\java-projects\\restaurant\\restaurant\\src\\main\\resources\\CustomerRegistry.txt");
    //private static final Path filePathW = Paths.get("C:\\java-Training\\java-projects\\restaurant\\restaurant\\src\\main\\resources\\WaiterRegistry.txt");

    private static Person person1 = new Person();
    //private static Waiter waiterTemp = new Waiter();

    private static List<Waiter> WaiterArray = new ArrayList<Waiter>();
    private static Waiter John = new Waiter("John","Smith", 111,"ID001","DayShift");
    private static Waiter Mike = new Waiter("Mike","Kane", 222,"ID002","NightShift");


    //Check total
    private static Integer checkTotal = 0;
    //Breakfast
    private static List<BreakfastItem> BreakfastMenuArray = new ArrayList<BreakfastItem>();
    private static BreakfastItem egg1 = new BreakfastItem("Egg","Sunny Side Up",4);
    private static BreakfastItem cheese1 = new BreakfastItem("Cheese","Feta",5);
    private static BreakfastItem crepe1 = new BreakfastItem("Crepe","With Nutella",6);
    //Lunch
    private static List<LunchItem> LunchMenuArray = new ArrayList<LunchItem>();
    private static LunchItem kebab1 = new LunchItem("Kebab", "Adana", 12);
    private static LunchItem kefir1 = new LunchItem("Kefir", "Organic", 9);
    private static LunchItem salad1 = new LunchItem("Salad", "Ceasar", 7);
    //Dinner
    private static List<DinnerItem> DinnerMenuArray = new ArrayList<DinnerItem>();
    private static DinnerItem steak1 = new DinnerItem("Steak", "Well-done", 20);
    private static DinnerItem soda1 = new DinnerItem("Soda", "Coke", 3);
    private static DinnerItem salad2 = new DinnerItem("Salad", "Shephard", 8);


    ////////////////////// Main Method //////////////////////////////
    public static void main(String[] args) {
        System.out.println("\nWelcome to Acme Restaurant!!!");

        // Menu1 (1- Manager Entry / 2- Customer Entry
        menuEntry();


//        /// Excercise Start ///
//        //Add Breakfast Menu "BreakfastItem" objects to "BreakfastMenuArray" ArrayList
//        BreakfastMenuArray.add(egg1);
//        BreakfastMenuArray.add(cheese1);
//        BreakfastMenuArray.add(crepe1);
//        System.out.println(BreakfastMenuArray);
//
//        //Calculating the "CheckTotal" for things in BreakfastMenuArray ArrayList
//        for (BreakfastItem breakfastItem: BreakfastMenuArray) {
//            System.out.println("Breakfast Item Price: "+breakfastItem.getPrice());
//            CheckTotal = CheckTotal + breakfastItem.getPrice();
//        }
//        System.out.println(CheckTotal);
//        /// Excercise End ///


    }

    ////////////////// MENU ENTRY ////////////////////////////
    public static void menuEntry() {
        while(true) {
            switch (pickMenuEntry()) {
                case 1:
                    System.out.println("You selected Manager Entry...");
                    managerMenu();
                    break;
                case 2:
                    System.out.println("You selected Customer Entry...");
                    register();
                    foodMenu();
                    break;
                case 3:
                    System.out.println("You selected to exit...");
                    System.exit(0);
                default:
                    System.out.println("Incorrect Entry, please select between 1-3");
            }
        }

    }

    public static int pickMenuEntry() {
        System.out.println("""
                \n=================
                ENTRY MENU
                1- Manager Entry
                2- Customer Entry
                3- Exit
                =================
                """);
        return scanner.nextInt();
    }


    public static void managerMenu() {
        Waiter waiterTemp = new Waiter();
        WaiterArray.add(John);
        WaiterArray.add(Mike);
        //System.out.println("Current Waiters: " + WaiterArray);
        //Here to add a waiter per manager entry, to add to ArrayList

        //Also how will the waiter be deleted from ArrayList?

        boolean whileCheck = true;
        while (whileCheck) {
            switch (pickManagerMenu()) {
                case 1:
                    System.out.println("You selected to add a waiter...");
                    waiterTemp.addWaiter();
                    WaiterArray.add(waiterTemp);
                    //System.out.println("List of waiters: " + WaiterArray);
                    break;

                case 2:
                    System.out.println("You selected to delete a waiter...");
                    System.out.println("Select the waiter (index No) to be deleted from the list below:");
                    for (Waiter waiter: WaiterArray) {
                        System.out.println("Index: " + WaiterArray.indexOf(waiter));
                        System.out.println("Name: " + waiter.getFirstName());
                        System.out.println("Last Name: " + waiter.getLastName());
                        System.out.println("Employee ID: " + waiter.getEmployeeID());
                        System.out.println();
                    }
                    int indexSelection = scanner.nextInt();
                    WaiterArray.remove(indexSelection);
                    System.out.printf("Waiter with index No %s has been removed.",indexSelection);
                    System.out.println();
                    break;
                case 3:
                    System.out.println(" You selected to see list of waiters...");
                    for (Waiter waiter: WaiterArray) {
                        System.out.println("Index: " + WaiterArray.indexOf(waiter));
                        System.out.println("Name: " + waiter.getFirstName());
                        System.out.println("Last Name: " + waiter.getLastName());
                        System.out.println("Phone No: " + waiter.getPhoneNo());
                        System.out.println("Employee ID: " + waiter.getEmployeeID());
                        System.out.println("Shift: " + waiter.getShift());
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("You selected to exit...");
                    whileCheck = false;
                    break;
                default:
                    System.out.println("Wrong entry, please select between 1-4.");
            }
        }
    }

    public static int pickManagerMenu() {
        System.out.println("""
                \n==================
                MANAGER MENU
                1- Add Waiter
                2- Delete Waiter
                3- List of Waiters
                4- Exit
                ==================
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

            //List<String> tempArrayList = new ArrayList<>();
        //    Transfer from Array to ArrayList
       //     for (var e: tempArray) {
       //         tempArrayList.add(e);
       //     }
        //    System.out.println("Who do you want to remove, choose the index");
       //     System.out.println(tempArrayList);
       //     tempArrayList.remove(scanner.nextInt());

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
                case 1:
                    System.out.println("You selected: Egg - Sunny side up  ($4)");
                    BreakfastMenuArray.add(egg1);
                    checkTotal = checkTotal + egg1.getPrice();
                    break;
                case 2:
                    System.out.println("You selected: Cheese - Feta  ($5)");
                    BreakfastMenuArray.add(cheese1);
                    checkTotal = checkTotal + cheese1.getPrice();
                    break;
                case 3:
                    System.out.println("You selected: Crepe - with Nutella  ($6)");
                    BreakfastMenuArray.add(crepe1);
                    checkTotal = checkTotal + crepe1.getPrice();
                    break;
                case 4:
                    System.out.println("You selected: Kebab - Adana  ($12)");
                    LunchMenuArray.add(kebab1);
                    checkTotal = checkTotal + kebab1.getPrice();
                    break;
                case 5:
                    System.out.println("You selected: Kefir - Organic  ($9)");
                    LunchMenuArray.add(kefir1);
                    checkTotal = checkTotal + kefir1.getPrice();
                    break;
                case 6:
                    System.out.println("You selected: Salad - Caesar  ($7)");
                    LunchMenuArray.add(salad1);
                    checkTotal = checkTotal + salad1.getPrice();
                    break;
                case 7:
                    System.out.println("You selected: Steak - Well done  ($20)");
                    DinnerMenuArray.add(steak1);
                    checkTotal = checkTotal + steak1.getPrice();
                    break;
                case 8:
                    System.out.println("You selected: Soda - Coke  ($3)");
                    DinnerMenuArray.add(soda1);
                    checkTotal = checkTotal + salad1.getPrice();
                    break;
                case 9:
                    System.out.println("You selected: Salad - Shephard  ($8)");
                    DinnerMenuArray.add(salad2);
                    checkTotal = checkTotal + salad2.getPrice();
                    break;

                case 90:
                    System.out.println("You selected: 90 - Show all selected food and total:");
                    System.out.println("----------------------------------------------------");
                    //System.out.println(BreakfastMenuArray);
                    for (BreakfastItem breakfastItem: BreakfastMenuArray) {
                        System.out.println("Breakfast Item: " + breakfastItem.getItemName() + " " + breakfastItem.getItemNote() + " $" + breakfastItem.getPrice());
                    }
                    for (LunchItem lunchItem: LunchMenuArray) {
                        System.out.println("Lunch Item: " + lunchItem.getItemName() + " " + lunchItem.getItemNote() + " $" + lunchItem.getPrice());
                    }
                    for (DinnerItem dinnerItem: DinnerMenuArray) {
                        System.out.println("Dinner Item: " + dinnerItem.getItemName() + " " + dinnerItem.getItemNote() + " $" + dinnerItem.getPrice());
                    }
                    System.out.print("Check Total: $" + checkTotal + "\n");
                    scanner.nextLine();
                    //scanner.nextLine();
                    // Payment and checking against the checkTotal:
                    IPay ipayP = new Person();
                    ipayP.pay();
                    int paidAmount = scanner.nextInt();

                    while(paidAmount<checkTotal) {
                        ipayP.pay();
                        System.out.println("Please pay the remaining amount: $" + (checkTotal-paidAmount));
                        int diff = scanner.nextInt();
                        paidAmount = paidAmount + diff;
                    }
                    if (paidAmount >= checkTotal) {
                        System.out.println("You paid in full, Thanks!!");
                    }
                    break;

                case 99:
                    System.out.println("You selected to exit Food Menu...");
                    whileCheck = false;
                    break;
                default:
                    System.out.println("Incorrect Entry, please select food menu code");
            }
        }

    }

    public static int pickFoodMenu() {
        System.out.println("""
                \n============================================
                FOOD MENU
                Breakfast
                    1-Egg (Sunny side up)  ($4)
                    2-Cheese (Feta)  ($5)
                    3-Crepe (with Nutella)  ($6)
                Lunch
                    4-Kebab (Adana)  ($12)
                    5-Kefir (Organic)  ($9)
                    6-Salad (Caesar)  ($7)
                Dinner
                    7-Steak (Well done)  ($20)
                    8-Soda (Coke)  ($3)
                    9-Salad (Shepherd)  ($8)
                    
                90 - Show all selected food and check total
                99 - Exit
                ============================================
                Please select from the menu above:
                """);
        return scanner.nextInt();
    }



}
