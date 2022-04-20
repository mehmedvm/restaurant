import person.Person;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    ////Class Fields
    private static final Scanner scanner = new Scanner(System.in);
    private static final Path filePath = Paths.get("C:\\java-Training\\java-projects\\restaurant\\src\\main\\resources\\register.txt");
    private static Person person1 = new Person();
    

    public static void main(String[] args) {



        System.out.println("Welcome to Acme Restaurant!!!");
    }
}
