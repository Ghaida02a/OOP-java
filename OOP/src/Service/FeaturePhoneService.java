package Service;

import Entity.FeaturePhone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FeaturePhoneService {
    public static List<FeaturePhone> featurePhoneList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void addFeaturePhone() {
        FeaturePhone featurePhone = new FeaturePhone();

        System.out.println("\n--- Adding a Feature Entity.Phone ---");
        boolean exitFlag = true;
        while (exitFlag) {
            // Enter ID of phone
            System.out.print("Enter Feature Entity.Phone ID: ");
            Integer idOfPhone = scanner.nextInt();
            while (idOfPhone < 0 || checkIfFeaturePhoneIdExists(idOfPhone)) {
                System.out.print("Invalid or duplicate ID. Enter a valid Feature Entity.Phone ID: ");
                idOfPhone = scanner.nextInt();
            }
            featurePhone.setId(idOfPhone);
            scanner.nextLine();

            System.out.print("Enter battery life in hours (e.g., 48): ");
            Integer batteryLifeInput = scanner.nextInt();
            while (batteryLifeInput < 0) {
                System.out.print("Invalid input. Enter battery life in hours (e.g., 48): ");
                batteryLifeInput = scanner.nextInt();
            }
            featurePhone.setBatteryLife(batteryLifeInput);

            featurePhoneList.add(featurePhone);
            System.out.println("Feature Entity.Phone added successfully!\n");

            System.out.print("Press 'c' to add another or 'q' to quit: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("c")) {
                exitFlag = true;
            } else if (userInput.equalsIgnoreCase("q")) {
                exitFlag = false;
            }
        }
    }

    public static void editFeaturePhone() {
        System.out.print("\nEnter Feature Entity.Phone ID to edit: ");
        Integer editIDInput = scanner.nextInt();
        if (editIDInput < 0) {
            System.out.println("Invalid ID");
        } else if (!checkIfFeaturePhoneIdExists(editIDInput)) {
            System.out.println("ID does not exist. Exiting edit.");
        }
        FeaturePhone featurePhoneToEdit = null;
        for (FeaturePhone featurePhone : featurePhoneList) {
            if (checkIfFeaturePhoneIdExists(editIDInput)) {
                featurePhoneToEdit = featurePhone;

                Integer selectToEdit = 0;
                while (selectToEdit != 3) {
                    showEditFeaturePhoneMenu();
                    System.out.print("Select an option to edit: ");
                    selectToEdit = scanner.nextInt();
                    scanner.nextLine();

                    if (selectToEdit == 1) {
                        System.out.print("Enter new battery life in hours: ");
                        Integer updatedBatteryLife = scanner.nextInt();
                        featurePhoneToEdit.setBatteryLife(updatedBatteryLife);
                        System.out.println("Battery life updated to " + updatedBatteryLife + " hours.\n");
                    } else if (selectToEdit == 2) {
                        System.out.println("Exiting Edit Menu...");
                        selectToEdit = 2;
                    } else {
                        System.out.println("Invalid option. Please select 1 or 2.\n");
                    }
                }
            }
        }

    }
    public static void removeItem() {
        //remove phone item by ID
        System.out.print("\nEnter Feature Entity.Phone ID to remove: ");
        Integer userInput = scanner.nextInt();
        if (userInput < 0) {
            System.out.println("Invalid ID");
        }
        if(checkIfFeaturePhoneIdExists(userInput)){
            featurePhoneList.removeIf(phone -> phone.getId().equals(userInput));
            System.out.println("Feature Entity.Phone with ID " + userInput + " has been removed.\n");
        }
        else {
            System.out.println("ID does not exist, Exiting...");
        }
    }

    public static void displayAllItems() {
        System.out.println("\n--- Displaying All Feature Phones ---");
        if (featurePhoneList.isEmpty()) {
            System.out.println("No Feature Phones found.");
        } else {
            for (FeaturePhone featurePhone : featurePhoneList) {
                System.out.println("battery Life: " + featurePhone.getBatteryLife());
                System.out.println("------------------------");

            }
        }
    }

    public static boolean checkIfFeaturePhoneIdExists(int idToCheck) {
        for (FeaturePhone featurePhone : featurePhoneList) {
            if (featurePhone.getId().equals(idToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static void showEditFeaturePhoneMenu() {
        System.out.print("""
                "\\n--- Edit Feature Entity.Phone Menu ---"
                1- Edit Battery Life
                2- Exit
                """);
    }
}
