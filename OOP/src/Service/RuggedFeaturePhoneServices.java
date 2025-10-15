package Service;

import Entity.RuggedFeaturePhone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RuggedFeaturePhoneServices {
    public static List<RuggedFeaturePhone> ruggedFeaturePhoneList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static RuggedFeaturePhone addRuggedFeaturePhone() {
        RuggedFeaturePhone ruggedFeaturePhone = new RuggedFeaturePhone();

        System.out.println("Adding Rugged Feature Entity.Phone  ");
        boolean exitFlag = true;
        while (exitFlag) {
            // Enter ID of phone
            System.out.print("Enter Rugged Feature Entity.Phone ID: ");
            int idOfPhone = scanner.nextInt();
            while (idOfPhone < 0 || checkIfRuggedFeaturePhoneIdExists(idOfPhone)) {
                System.out.print("Invalid or duplicate ID. Enter a valid Rugged Feature Entity.Phone ID: ");
                idOfPhone = scanner.nextInt();
            }
            ruggedFeaturePhone.setId(idOfPhone);
            scanner.nextLine();

            System.out.print("Enter IP Rating: ");
            Integer  ipRating = scanner.nextInt();
            while (ipRating < 0) {
                System.out.print("Invalid input. Please enter valid IP Rating: ");
                ipRating = scanner.nextInt();
            }
            ruggedFeaturePhone.setIpRating(ipRating);

            System.out.print("Enter Drop Test Height: ");
            Float dropHeightInput = scanner.nextFloat();
            while (dropHeightInput <= 0) {
                System.out.print("Invalid input. Please enter a valid height (in meters or feet): ");
                dropHeightInput = scanner.nextFloat();
            }
            scanner.nextLine(); // consume leftover newline
            ruggedFeaturePhone.setDropTestHeight(dropHeightInput);


            System.out.print("Enter Battery Stand by Days: ");
            int batteryLifeInDays = scanner.nextInt();
            while (dropHeightInput <= 0) {
                System.out.print("Invalid input. Please enter a positive number for Battery Life: ");
                batteryLifeInDays = scanner.nextInt();
            }
            scanner.nextLine();
            ruggedFeaturePhone.setBatteryStandbyDays(batteryLifeInDays);

            // Continue or quit
            System.out.print("Press 'c' to add another or 'q' to quit: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("c")) {
                exitFlag = true;
            } else if (userInput.equalsIgnoreCase("q")) {
                exitFlag = false;
            }
        }
        return ruggedFeaturePhone;
    }

    public static void save(RuggedFeaturePhone ruggedFeaturePhone) {
        ruggedFeaturePhoneList.add(ruggedFeaturePhone);
        System.out.println("Rugged Feature Entity.Phone added successfully!\n");
    }

    public static RuggedFeaturePhone editInput() {
        if (ruggedFeaturePhoneList.isEmpty()) {
            System.out.println("No Rugged Feature Phones available to edit.");
            return null;
        }
        System.out.print("\nEnter Rugged Feature Entity.Phone ID to edit: ");
        Integer editIDInput = scanner.nextInt();
        if (editIDInput < 0) {
            System.out.println("Invalid ID");
        } else if (!checkIfRuggedFeaturePhoneIdExists(editIDInput)) {
            System.out.println("ID does not exist, Exiting");
        }
        RuggedFeaturePhone ruggedFeaturePhoneToEdit = null;
        for (RuggedFeaturePhone ruggedFeaturePhone : ruggedFeaturePhoneList) {
            if (checkIfRuggedFeaturePhoneIdExists(editIDInput)) {
                ruggedFeaturePhoneToEdit = ruggedFeaturePhone;

                Integer selectToEdit = 0;
                while (selectToEdit != 4) {
                    showEditRuggedFeaturePhoneMenu();
                    System.out.print("Choose what you’d like to update (1–3): ");
                    selectToEdit = scanner.nextInt();
                    scanner.nextLine();

                    if (selectToEdit == 1) {
                        System.out.print("Enter updated IP Rating: ");
                        int ipRating = scanner.nextInt();
                        ruggedFeaturePhoneToEdit.setIpRating(ipRating);
                        System.out.println("IP Rating updated to: " + ipRating + "\n");
                    } else if (selectToEdit == 2) {
                        System.out.print("Enter updated Drop Test Height (in meters or feet): ");
                        Float dropTestHeightInput = scanner.nextFloat();
                        ruggedFeaturePhoneToEdit.setDropTestHeight(dropTestHeightInput);
                        System.out.println("Drop Test Height updated to: " + dropTestHeightInput);
                    } else if (selectToEdit == 3) {
                        System.out.print("Enter updated Battery Stand by Days: ");
                        int batteryInHours = scanner.nextInt();
                        ruggedFeaturePhoneToEdit.setBatteryStandbyDays(batteryInHours);
                        System.out.println("Battery Stand by Days updated to: " + batteryInHours + "\n");
                    } else if (selectToEdit == 4) {
                        System.out.println("Exiting Edit Menu...");
                        selectToEdit = 4;
                    } else {
                        System.out.println("Invalid option. Please select 1, 2, 3 or 4.\n");
                    }
                }
            }
        }
        return ruggedFeaturePhoneToEdit;
    }

    public static void update(RuggedFeaturePhone updatedRuggedFeaturePhone) {
        if (updatedRuggedFeaturePhone == null) {
            System.out.println("No updates to save.");
        }
        boolean found = false;
        for (int i = 0; i < ruggedFeaturePhoneList.size(); i++) {
            if (ruggedFeaturePhoneList.get(i).getId().equals(updatedRuggedFeaturePhone.getId())) {
                ruggedFeaturePhoneList.set(i, updatedRuggedFeaturePhone);
                System.out.println("Rugged Feature Entity.Phone updated successfully.");
                found = true;
            }
        }
        if(!found) {
            System.out.println("Updated Rugged Feature Entity.Phone not found in list.");
        }
    }


    public static void editRuggedFeaturePhone() {
        RuggedFeaturePhone edited = editInput();
        update(edited);
    }

    public static Integer getRuggedFeaturePhoneIDToRemove() {
        if (ruggedFeaturePhoneList.isEmpty()) {
            System.out.println("No Rugged Feature Phones available to remove.");
            return null;
        }

        System.out.print("Enter Rugged Feature Entity.Phone ID to remove: ");
        Integer userInput = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (userInput < 0) {
            System.out.println("Invalid ID. Must be positive.");
            return null;
        }

        return userInput;
    }

    public static void removeRuggedFeaturePhoneByID(Integer ruggedFeaturePhoneID) {
        if (ruggedFeaturePhoneID == null) {
            System.out.println("No Rugged Feature Entity.Phone removed.");
            return;
        }
        if (checkIfRuggedFeaturePhoneIdExists(ruggedFeaturePhoneID)) {
            ruggedFeaturePhoneList.removeIf(phone -> phone.getId().equals(ruggedFeaturePhoneID));
            System.out.println("Rugged Feature Entity.Phone with ID " + ruggedFeaturePhoneID + " removed successfully.");
        }
        else {
            System.out.println("Rugged Feature Entity.Phone not found.");
        }
    }

    public static void removeItem() {
        Integer id = getRuggedFeaturePhoneIDToRemove();
        removeRuggedFeaturePhoneByID(id);
    }

    public static void displayAllItems() {
        System.out.println("\n--- Displaying All Rugged Feature Phones ---");
        if (ruggedFeaturePhoneList.isEmpty()) {
            System.out.println("No Rugged Feature Phones found.");
        } else {
            for (RuggedFeaturePhone ruggedFeaturePhone : ruggedFeaturePhoneList) {
                System.out.println("IP Rating: " + ruggedFeaturePhone.getIpRating() +
                        "\n Drop Test Height: " + ruggedFeaturePhone.getDropTestHeight() +
                        "\n Battery Stand by Days: " + ruggedFeaturePhone.getBatteryStandbyDays());
                System.out.println("-------------------------------");
            }
        }
    }

    public static boolean checkIfRuggedFeaturePhoneIdExists(int idToCheck) {
        for (RuggedFeaturePhone ruggedFeaturePhone : ruggedFeaturePhoneList) {
            if (ruggedFeaturePhone.getId().equals(idToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static void showEditRuggedFeaturePhoneMenu() {
        System.out.print("""
                1- Edit IP Rating
                2- Edit Drop Test Height
                3- Edit Battery Stand by Days
                4- Exit
                """);
    }
}
