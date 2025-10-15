package Service;

import Entity.ProGamingPhone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProGamingPhoneServices {
    public static List<ProGamingPhone> proGamingPhoneList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static ProGamingPhone addProGamingPhone() {
        ProGamingPhone proGamingPhone = new ProGamingPhone();

        System.out.println("Adding Pro Gaming Entity.Phone  ");
        boolean exitFlag = true;
        while (exitFlag) {
            // Enter ID of phone
            System.out.print("Enter Pro Gaming Entity.Phone ID: ");
            Integer idOfPhone = scanner.nextInt();
            while (idOfPhone < 0 || checkIfProGamingPhoneIdExists(idOfPhone)) {
                System.out.print("Invalid or duplicate ID. Enter a valid Pro Gaming Entity.Phone ID: ");
                idOfPhone = scanner.nextInt();
            }
            proGamingPhone.setId(idOfPhone);
            scanner.nextLine();

            System.out.print("Enter Shoulder Triggers (Physical or touch-sensitive): ");
            String shoulderTriggerInput = scanner.nextLine();
            //The input should be one of the 2 valid options
            while (!shoulderTriggerInput.equalsIgnoreCase("Physical") &&
                    !shoulderTriggerInput.equalsIgnoreCase("touch-sensitive") && !shoulderTriggerInput.equalsIgnoreCase("touch sensitive")) {
                System.out.print("Invalid input. Please enter either 'Physical' or 'touch-sensitive': ");
                shoulderTriggerInput = scanner.nextLine();
            }
            proGamingPhone.setShoulderTriggers(shoulderTriggerInput);

            System.out.print("Enter Cooling System Type: ");
            String coolingType = scanner.nextLine();
            proGamingPhone.setCoolingSystemType(coolingType);

            // Continue or quit
            System.out.print("Press 'c' to add another or 'q' to quit: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("c")) {
                exitFlag = true;
            } else if (userInput.equalsIgnoreCase("q")) {
                exitFlag = false;
            }
        }
        return proGamingPhone;
    }

    public static void save(ProGamingPhone proGamingPhone) {
        proGamingPhoneList.add(proGamingPhone);
        System.out.println("Pro Gaming Entity.Phone added successfully!\n");
    }

    public static ProGamingPhone editInput() {
        if (proGamingPhoneList.isEmpty()) {
            System.out.println("No Pro Gaming Phones available to edit.");
            return null;
        }
        System.out.print("\nEnter Pro Gaming  Entity.Phone ID to edit: ");
        Integer editIDInput = scanner.nextInt();
        if (editIDInput < 0) {
            System.out.println("Invalid ID");
        } else if (!checkIfProGamingPhoneIdExists(editIDInput)) {
            System.out.println("ID does not exist, Exiting");
        }
        ProGamingPhone proGamingPhoneToEdit = null;
        for (ProGamingPhone proGamingPhone : proGamingPhoneList) {
            if (checkIfProGamingPhoneIdExists(editIDInput)) {
                proGamingPhoneToEdit = proGamingPhone;

                Integer selectToEdit = 0;
                while (selectToEdit != 4) {
                    showEditProGamingPhoneMenu();
                    System.out.print("Choose what you’d like to update (1–4): ");
                    selectToEdit = scanner.nextInt();
                    scanner.nextLine();

                    if (selectToEdit == 1) {
                        System.out.print("Enter updated Shoulder Triggers: ");
                        String updatedShoulderTriggers = scanner.nextLine();
                        proGamingPhoneToEdit.setShoulderTriggers(updatedShoulderTriggers);
                        System.out.println("Shoulder Trigger updated to: " + updatedShoulderTriggers + "\n");
                    } else if (selectToEdit == 2) {
                        System.out.print("Enter updated Cooling System Type: ");
                        String updatedCoolingType = scanner.nextLine();
                        proGamingPhoneToEdit.setCoolingSystemType(updatedCoolingType);
                        System.out.println("Cooling System Type updated to: " + updatedCoolingType);
                    } else if (selectToEdit == 3) {
                        System.out.println("Exiting Edit Menu...");
                        selectToEdit = 3;
                    } else {
                        System.out.println("Invalid option. Please select 1, 2 or 3.\n");
                    }
                }
            }
        }
        return proGamingPhoneToEdit;
    }

    public static void update(ProGamingPhone updatedProGamingPhone) {
        if (updatedProGamingPhone == null) {
            System.out.println("No updates to save.");
            return; // exit early
        }
        boolean found = false;
        for (int i = 0; i < proGamingPhoneList.size(); i++) {
            if (proGamingPhoneList.get(i).getId().equals(updatedProGamingPhone.getId())) {
                proGamingPhoneList.set(i, updatedProGamingPhone);
                System.out.println("Pro Gaming Entity.Phone updated successfully.");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Updated Pro Gaming Entity.Phone not found in list.");
        }
    }


    public static void editProGamingPhone() {
        ProGamingPhone edited = editInput();
        update(edited);
    }

    public static Integer getProGamingPhoneIDToRemove() {
        if (proGamingPhoneList.isEmpty()) {
            System.out.println("No Pro Gaming  Phones available to remove.");
            return null;
        }

        System.out.print("Enter Pro Gaming  Entity.Phone ID to remove: ");
        Integer userInput = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (userInput < 0) {
            System.out.println("Invalid ID. Must be positive.");
            return null;
        }

        return userInput;
    }

    public static void removeProGamingPhoneByID(Integer proGamingPhoneID) {
        if (proGamingPhoneID == null) {
            System.out.println("No Pro Gaming Entity.Phone removed.");
            return;
        }
        if (checkIfProGamingPhoneIdExists(proGamingPhoneID)) {
            proGamingPhoneList.removeIf(phone -> phone.getId().equals(proGamingPhoneID));
            System.out.println("Pro Gaming  Entity.Phone with ID " + proGamingPhoneID + " removed successfully.");
        } else {
            System.out.println("Pro Gaming  Entity.Phone not found.");
        }
    }

    public static void removeItem() {
        Integer id = getProGamingPhoneIDToRemove();
        removeProGamingPhoneByID(id);
    }

    public static void displayAllItems() {
        System.out.println("\n--- Displaying All Pro Gaming  Phones ---");
        if (proGamingPhoneList.isEmpty()) {
            System.out.println("No Pro Gaming  Phones found.");
        } else {
            for (ProGamingPhone proGamingPhone : proGamingPhoneList) {
                System.out.println("Shoulder Trigger: " + proGamingPhone.getShoulderTriggers() +
                        "\n coolingSystem Type: " + proGamingPhone.getCoolingSystemType());
                System.out.println("-------------------------------");
            }
        }
    }

    public static boolean checkIfProGamingPhoneIdExists(int idToCheck) {
        for (ProGamingPhone proGamingPhone : proGamingPhoneList) {
            if (proGamingPhone.getId().equals(idToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static void showEditProGamingPhoneMenu() {
        System.out.print("""
                1- Edit Shoulder Trigger
                2- Edit Cooling System Type
                3- Exit
                """);
    }
}
