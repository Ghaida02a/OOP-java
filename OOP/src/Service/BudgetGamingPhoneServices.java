package Service;

import Entity.BudgetGamingPhone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BudgetGamingPhoneServices {
    public static List<BudgetGamingPhone> budgetGamingPhoneList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static BudgetGamingPhone addBudgetGamingPhone() {
        BudgetGamingPhone budgetGamingPhone = new BudgetGamingPhone();

        System.out.println("Adding Budget Gaming Entity.Phone  ");
        boolean exitFlag = true;
        while (exitFlag) {
            // Enter ID of phone
            System.out.print("Enter Budget Gaming Entity.Phone ID: ");
            Integer idOfPhone = scanner.nextInt();
            while (idOfPhone < 0 || checkIfBudgetGamingPhoneIdExists(idOfPhone)) {
                System.out.print("Invalid or duplicate ID. Enter a valid Budget Gaming Entity.Phone ID: ");
                idOfPhone = scanner.nextInt();
            }
            budgetGamingPhone.setId(idOfPhone);
            scanner.nextLine();

            System.out.print("Enter Processor Clock Speed: ");
            Float processorClockSpeedInput = scanner.nextFloat();
            //The input should be one of the 2 valid options
            while (processorClockSpeedInput < 0) {
                System.out.print("Invalid input. Please enter Processor Clock Speed: ");
                processorClockSpeedInput = scanner.nextFloat();
            }
            budgetGamingPhone.setProcessorClockSpeed(processorClockSpeedInput);

            System.out.print("Enter RAM Size: ");
            int ramSize = scanner.nextInt();
            while (ramSize <= 0) {
                System.out.print("Invalid input. Please enter a positive number for RAM Size: ");
                ramSize = scanner.nextInt();
            }
            scanner.nextLine(); // consume leftover newline
            budgetGamingPhone.setRamSize(ramSize);


            System.out.print("Enter Game Booster Software (e.g., Game Turbo, Game Mode, Game Space): ");
            String gameBoosterSoftware = scanner.nextLine();
            budgetGamingPhone.setGameBoosterSoftware(gameBoosterSoftware);

            // Continue or quit
            System.out.print("Press 'c' to add another or 'q' to quit: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("c")) {
                exitFlag = true;
            } else if (userInput.equalsIgnoreCase("q")) {
                exitFlag = false;
            }
        }
        return budgetGamingPhone;
    }

    public static void save(BudgetGamingPhone budgetGamingPhone) {
        budgetGamingPhoneList.add(budgetGamingPhone);
        System.out.println("Budget Gaming Entity.Phone added successfully!\n");
    }

    public static BudgetGamingPhone editInput() {
        if (budgetGamingPhoneList.isEmpty()) {
            System.out.println("No Budget Gaming Phones available to edit.");
            return null;
        }
        System.out.print("\nEnter Budget Gaming Entity.Phone ID to edit: ");
        Integer editIDInput = scanner.nextInt();
        if (editIDInput < 0) {
            System.out.println("Invalid ID");
        } else if (!checkIfBudgetGamingPhoneIdExists(editIDInput)) {
            System.out.println("ID does not exist, Exiting");
        }
        BudgetGamingPhone BudgetGamingPhoneToEdit = null;
        for (BudgetGamingPhone budgetGamingPhone : budgetGamingPhoneList) {
            if (checkIfBudgetGamingPhoneIdExists(editIDInput)) {
                BudgetGamingPhoneToEdit = budgetGamingPhone;

                Integer selectToEdit = 0;
                while (selectToEdit != 4) {
                    showEditBudgetGamingPhoneMenu();
                    System.out.print("Choose what you’d like to update (1–4): ");
                    selectToEdit = scanner.nextInt();
                    scanner.nextLine();

                    if (selectToEdit == 1) {
                        System.out.print("Enter updated Processor Clock Speed: ");
                        Float updatedProcessorSpeed = scanner.nextFloat();
                        BudgetGamingPhoneToEdit.setProcessorClockSpeed(updatedProcessorSpeed);
                        System.out.println("Processor Clock Speed updated to: " + updatedProcessorSpeed + "\n");
                    } else if (selectToEdit == 2) {
                        System.out.print("Enter updated RAM Size: ");
                        Integer updatedRAMSize = scanner.nextInt();
                        BudgetGamingPhoneToEdit.setRamSize(updatedRAMSize);
                        System.out.println("RAM Size updated to: " + updatedRAMSize);
                    } else if (selectToEdit == 3) {
                        System.out.print("Enter updated Game Booster Software: ");
                        String gameSoftwareInput = scanner.nextLine();
                        BudgetGamingPhoneToEdit.setGameBoosterSoftware(gameSoftwareInput);
                        System.out.println("Game Booster Software updated to: " + gameSoftwareInput + "\n");
                    } else if (selectToEdit == 4) {
                        System.out.println("Exiting Edit Menu...");
                        selectToEdit = 4;
                    } else {
                        System.out.println("Invalid option. Please select 1, 2, 3 or 4.\n");
                    }
                }
            }
        }
        return BudgetGamingPhoneToEdit;
    }

    public static void update(BudgetGamingPhone updatedBudgetGamingPhone) {
        if (updatedBudgetGamingPhone == null) {
            System.out.println("No updates to save.");
            return; // exit early
        }
        boolean found = false;
        for (int i = 0; i < budgetGamingPhoneList.size(); i++) {
            if (budgetGamingPhoneList.get(i).getId().equals(updatedBudgetGamingPhone.getId())) {
                budgetGamingPhoneList.set(i, updatedBudgetGamingPhone);
                System.out.println("Budget Gaming Entity.Phone updated successfully.");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Updated Budget Gaming Entity.Phone not found in list.");
        }
    }


    public static void editBudgetGamingPhone() {
        BudgetGamingPhone edited = editInput();
        update(edited);
    }

    public static Integer getBudgetGamingPhoneIDToRemove() {
        if (budgetGamingPhoneList.isEmpty()) {
            System.out.println("No Budget Gaming Phones available to remove.");
            return null;
        }

        System.out.print("Enter Budget Gaming Entity.Phone ID to remove: ");
        Integer userInput = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (userInput < 0) {
            System.out.println("Invalid ID. Must be positive.");
            return null;
        }

        return userInput;
    }

    public static void removeBudgetGamingPhoneByID(Integer budgetGamingPhoneID) {
        if (budgetGamingPhoneID == null) {
            System.out.println("No Budget Gaming Entity.Phone removed.");
            return;
        }
        if (checkIfBudgetGamingPhoneIdExists(budgetGamingPhoneID)) {
            budgetGamingPhoneList.removeIf(phone -> phone.getId().equals(budgetGamingPhoneID));
            System.out.println("Budget Gaming Entity.Phone with ID " + budgetGamingPhoneID + " removed successfully.");
        } else {
            System.out.println("Budget Gaming Entity.Phone not found.");
        }
    }

    public static void removeItem() {
        Integer id = getBudgetGamingPhoneIDToRemove();
        removeBudgetGamingPhoneByID(id);
    }

    public static void displayAllItems() {
        System.out.println("\n--- Displaying All Budget Gaming Phones ---");
        if (budgetGamingPhoneList.isEmpty()) {
            System.out.println("No Budget Gaming Phones found.");
        } else {
            for (BudgetGamingPhone budgetGamingPhone : budgetGamingPhoneList) {
                System.out.println("Processor Clock Speed: " + budgetGamingPhone.getProcessorClockSpeed() +
                        "\n RAM Size: " + budgetGamingPhone.getRamSize() +
                        "\n Game Booster Software: " + budgetGamingPhone.getGameBoosterSoftware());
                System.out.println("-------------------------------");
            }
        }
    }

    public static boolean checkIfBudgetGamingPhoneIdExists(int idToCheck) {
        for (BudgetGamingPhone budgetGamingPhone : budgetGamingPhoneList) {
            if (budgetGamingPhone.getId().equals(idToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static void showEditBudgetGamingPhoneMenu() {
        System.out.print("""
                1- Edit Processor Clock Speed
                2- Edit RAM Size
                3- Edit Game Booster Software
                4- Exit
                """);
    }
}
