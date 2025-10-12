import java.util.Scanner;

public class PhoneDriver {

    public static Scanner scanner = new Scanner(System.in);
    public static Integer mainMenuOption = 0;


    public static void main(String[] args) {

        while (mainMenuOption != 5) {
            showMainMenu();
            mainMenuOption = scanner.nextInt();
            scanner.nextLine();
            if (mainMenuOption == 1) {
                PhoneService.addItem();
            } else if (mainMenuOption == 2) {
                PhoneService.editItem();
            } else if (mainMenuOption == 3) {
                PhoneService.removeItem();
            } else if (mainMenuOption == 4) {
                PhoneService.displayAllItems();
            } else if (mainMenuOption == 5) {
                System.out.println("Exiting the main menu");
                mainMenuOption = 5;
            } else {
                System.out.println("Please enter a valid option");
            }
        }
    }

    public static void showMainMenu() {
        System.out.println("=====Item management menu =====");
        System.out.print("""
                1- Add a new item
                2- Edit an existing item
                3- Remove an item
                4- Display all items
                5- Exit
                """);
        System.out.println("===============");
        System.out.print("Please enter your choice: ");
    }
    public static void showEditMenu() {
        System.out.print("""
                1- Edit Phone Name
                2- Edit Phone Brand
                3- Edit Phone Price
                4- Edit Phone Color
                5- Edit Phone Quantity
                6- Exit
                """);
    }
}
