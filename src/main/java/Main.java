import person.Person;
import restaurant.breakfast.BreakfastItem;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    ////Class Fields
    private static final Scanner scanner = new Scanner(System.in);
    private static final Path filePath = Paths.get("C:\\java-Training\\java-projects\\restaurant\\restaurant\\src\\main\\resources\\register.txt");
    private static Person person1 = new Person();
    //Breakfast
    private static List<BreakfastItem> BreakfastMenuArray = new ArrayList<BreakfastItem>();
    private static BreakfastItem egg1 = new BreakfastItem("Egg","Sunny Side Up",5);
    private static BreakfastItem cheese1 = new BreakfastItem("Cheese","Feta",5);
    private static BreakfastItem crepe1 = new BreakfastItem("Crepe","With Nutella",5);




    public static void main(String[] args) {
        System.out.println("\nWelcome to Acme Restaurant!!!");
        BreakfastMenuArray.add(egg1);
        BreakfastMenuArray.add(cheese1);
        BreakfastMenuArray.add(crepe1);
        System.out.println(BreakfastMenuArray);


    }
}
