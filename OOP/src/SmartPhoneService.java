import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmartPhoneService {
    public static List<SmartPhone> smartPhoneList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void addSmartPhone() {
        SmartPhone smartPhone = new SmartPhone();

        System.out.println("\n--- Adding a Smart Phone ---");

        boolean exitFlag = true;
        while (exitFlag) {
            // Enter ID of phone
            System.out.print("Enter Smart Phone ID: ");
            Integer idOfPhone = scanner.nextInt();
            while (idOfPhone < 0 || checkIfSmartPhoneIdExists(idOfPhone)) {
                System.out.print("Invalid or duplicate ID. Enter a valid Smart Phone ID: ");
                idOfPhone = scanner.nextInt();
            }
            smartPhone.setId(idOfPhone);
            scanner.nextLine();

            System.out.println("Enter the Operating System name: ");
            String osName = scanner.nextLine();
            while (osName.isBlank() || osName.isEmpty()) {
                System.out.print("Invalid input. Enter a valid Operating System name: ");
                osName = scanner.nextLine();
            }
            smartPhone.setOperatingSystem(osName);

            System.out.print("Is Bluetooth available? (true/false): ");
            boolean isBluetoothAvailable = scanner.nextBoolean();
            smartPhone.setBluetoothAvailable(isBluetoothAvailable);
            scanner.nextLine();


            smartPhoneList.add(smartPhone);
            System.out.println("Smart Phone added successfully!\n");

            // Continue or quit
            System.out.print("Press 'c' to add another or 'q' to quit: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("c")) {
                exitFlag = true;
            } else if (userInput.equalsIgnoreCase("q")) {
                exitFlag = false;
            }
        }
    }

    public static void editSmartPhone() {
        System.out.print("\nEnter Smart Phone ID to edit: ");
        Integer editIDInput = scanner.nextInt();
        if (editIDInput < 0) {
            System.out.println("Invalid ID");
        } else if (!checkIfSmartPhoneIdExists(editIDInput)) {
            System.out.println("ID does not exist. Exiting");
        }
        SmartPhone smartPhoneToEdit = null;
        for (SmartPhone smartPhone : smartPhoneList) {
            if (checkIfSmartPhoneIdExists(editIDInput)) {
                smartPhoneToEdit = smartPhone;

                Integer selectToEdit = 0;
                while (selectToEdit != 3) {
                    showEditSmartPhoneMenu();
                    System.out.print("Select an option to edit: ");
                    selectToEdit = scanner.nextInt();
                    scanner.nextLine();

                    if (selectToEdit == 1) {
                        System.out.print("Enter new Operating System: ");
                        String updatedOS = scanner.nextLine();
                        smartPhoneToEdit.setOperatingSystem(updatedOS);
                        System.out.println("Operating System updated to: " + updatedOS + "\n");
                    } else if (selectToEdit == 2) {
                        System.out.print("Enter new Bluetooth status (true/false): ");
                        Boolean updatedBluetooth = scanner.nextBoolean();
                        smartPhoneToEdit.setBluetoothAvailable(updatedBluetooth);
                        System.out.println("Bluetooth status updated to: " + updatedBluetooth + "\n");
                    } else if (selectToEdit == 3) {
                        System.out.println("Exiting Edit Menu...");
                        selectToEdit = 3;
                    } else {
                        System.out.println("Invalid option. Please select 1, 2, or 3.\n");
                    }
                }
            }
        }

    }
    public static void removeItem() {
        //remove phone item by ID
        System.out.print("\nEnter Smart Phone ID to remove: ");
        Integer userInput = scanner.nextInt();
        if (userInput < 0) {
            System.out.println("Invalid ID");
        }
        if(checkIfSmartPhoneIdExists(userInput)){
            smartPhoneList.removeIf(phone -> phone.getId().equals(userInput));
            System.out.println("Smart Phone with ID " + userInput + " has been removed.\n");
        }
        else {
            System.out.println("ID does not exist. Exiting...");
        }
    }

    public static void displayAllItems() {
        System.out.println("\n--- Displaying All Smart Phones ---");
        if (smartPhoneList.isEmpty()) {
            System.out.println("No Smart Phones found.");
        } else {
            for (SmartPhone smartPhone : smartPhoneList) {
                System.out.println("Operating System:" + smartPhone.getOperatingSystem() +
                        "\n Bluetooth Available: "  + smartPhone.isBluetoothAvailable() +
                        "\n-----------------------");
            }
        }
    }

    public static boolean checkIfSmartPhoneIdExists(int idToCheck) {
        for (SmartPhone smartPhone : smartPhoneList) {
            if (smartPhone.getId().equals(idToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static void showEditSmartPhoneMenu() {
        System.out.print("""
                \\n--- Edit Smart Phone Menu ---
                1- Edit Operating System
                2- Edit Bluetooth connection
                3- Exit
                """);
    }
}
