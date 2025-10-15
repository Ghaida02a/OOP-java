package Service;

import Entity.FoldablePhone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoldablePhoneServices {
    public static List<FoldablePhone> foldablePhoneList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static FoldablePhone addFoldablePhone() {
        FoldablePhone foldablePhone = new FoldablePhone();

        System.out.println("Adding Foldable Entity.Phone  ");
        boolean exitFlag = true;
        while (exitFlag) {
            // Enter ID of phone
            System.out.print("Enter Foldable Entity.Phone ID: ");
            Integer idOfPhone = scanner.nextInt();
            while (idOfPhone < 0 || checkIfFoldablePhoneIdExists(idOfPhone)) {
                System.out.print("Invalid or duplicate ID. Enter a valid Foldable Entity.Phone ID: ");
                idOfPhone = scanner.nextInt();
            }
            foldablePhone.setId(idOfPhone);
            scanner.nextLine();

            System.out.print("Enter folding Mechanism (Horizontal or Vertical): ");
            String  foldingMechanism = scanner.nextLine();
            //The input should be one of the 2 valid options
            while (!foldingMechanism.equalsIgnoreCase("Horizontal") &&
                    !foldingMechanism.equalsIgnoreCase("Vertical")) {
                System.out.print("Invalid input. Please enter either 'Horizontal' or 'Vertical': ");
                foldingMechanism = scanner.nextLine();
            }
            foldablePhone.setFoldingMechanism(foldingMechanism);

            System.out.print("Enter Screen Durability Folds: ");
            int screenDurability = scanner.nextInt();
            while (screenDurability <= 0) {
                System.out.print("Invalid input. Please enter a positive number for Screen Durability Folds: ");
                screenDurability = scanner.nextInt();
            }
            scanner.nextLine(); // consume leftover newline
            foldablePhone.setScreenDurabilityFolds(screenDurability);


            System.out.print("Enter outer Display Size (in inches): ");
            Float displaySize = scanner.nextFloat();
            while (displaySize <= 0) {
                System.out.print("Invalid input. Please enter a positive number for outer Display Size: ");
                displaySize = scanner.nextFloat();
            }
            scanner.nextLine();
            foldablePhone.setOuterDisplaySize(displaySize);

            // Continue or quit
            System.out.print("Press 'c' to add another or 'q' to quit: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("c")) {
                exitFlag = true;
            } else if (userInput.equalsIgnoreCase("q")) {
                exitFlag = false;
            }
        }
        return foldablePhone;
    }

    public static void save(FoldablePhone foldablePhone) {
        foldablePhoneList.add(foldablePhone);
        System.out.println("Foldable Entity.Phone added successfully!\n");
    }

    public static FoldablePhone editInput() {
        if (foldablePhoneList.isEmpty()) {
            System.out.println("No Foldable Phones available to edit.");
            return null;
        }
        System.out.print("\nEnter Foldable Entity.Phone ID to edit: ");
        Integer editIDInput = scanner.nextInt();
        if (editIDInput < 0) {
            System.out.println("Invalid ID");
        } else if (!checkIfFoldablePhoneIdExists(editIDInput)) {
            System.out.println("ID does not exist, Exiting");
        }
        FoldablePhone foldablePhoneToEdit = null;
        for (FoldablePhone foldablePhone : foldablePhoneList) {
            if (checkIfFoldablePhoneIdExists(editIDInput)) {
                foldablePhoneToEdit = foldablePhone;

                Integer selectToEdit = 0;
                while (selectToEdit != 4) {
                    showEditFoldablePhoneMenu();
                    System.out.print("Choose what you’d like to update (1–4): ");
                    selectToEdit = scanner.nextInt();
                    scanner.nextLine();

                    if (selectToEdit == 1) {
                        System.out.print("Enter updated Folding Mechanism (Horizontal or Vertical): ");
                        String updatedfoldingMechanism = scanner.nextLine();
                        foldablePhoneToEdit.setFoldingMechanism(updatedfoldingMechanism);
                        System.out.println("Folding Mechanism updated to: " + updatedfoldingMechanism + "\n");
                    } else if (selectToEdit == 2) {
                        System.out.print("Enter updated Screen Durability Folds: ");
                        Integer updatedScreenDurability = scanner.nextInt();
                        foldablePhoneToEdit.setScreenDurabilityFolds(updatedScreenDurability);
                        System.out.println("Screen Durability Folds updated to: " + updatedScreenDurability);
                    } else if (selectToEdit == 3) {
                        System.out.print("Enter updated Outer Display Size (in inches): ");
                        Float displaySize = scanner.nextFloat();
                        foldablePhoneToEdit.setOuterDisplaySize(displaySize);
                        System.out.println("Outer Display Size updated to (in inches): " + displaySize + "\n");
                    } else if (selectToEdit == 4) {
                        System.out.println("Exiting Edit Menu...");
                        selectToEdit = 4;
                    } else {
                        System.out.println("Invalid option. Please select 1, 2, 3 or 4.\n");
                    }
                }
            }
        }
        return foldablePhoneToEdit;
    }

    public static void update(FoldablePhone updatedFoldablePhone) {
        if (updatedFoldablePhone == null) {
            System.out.println("No updates to save.");
            return; // exit early
        }
        boolean found = false;
        for (int i = 0; i < foldablePhoneList.size(); i++) {
            if (foldablePhoneList.get(i).getId().equals(updatedFoldablePhone.getId())) {
                foldablePhoneList.set(i, updatedFoldablePhone);
                System.out.println("Foldable Entity.Phone updated successfully.");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Updated Foldable Entity.Phone not found in list.");
        }
    }


    public static void editFoldablePhone() {
        FoldablePhone edited = editInput();
        update(edited);
    }

    public static Integer getFoldablePhoneIDToRemove() {
        if (foldablePhoneList.isEmpty()) {
            System.out.println("No Foldable Phones available to remove.");
            return null;
        }

        System.out.print("Enter Foldable Entity.Phone ID to remove: ");
        Integer userInput = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (userInput < 0) {
            System.out.println("Invalid ID. Must be positive.");
            return null;
        }

        return userInput;
    }

    public static void removeFoldablePhoneByID(Integer foldablePhoneID) {
        if (foldablePhoneID == null) {
            System.out.println("No Foldable Entity.Phone removed.");
            return;
        }
        if (checkIfFoldablePhoneIdExists(foldablePhoneID)) {
            foldablePhoneList.removeIf(phone -> phone.getId().equals(foldablePhoneID));
            System.out.println("Foldable Entity.Phone with ID " + foldablePhoneID + " removed successfully.");
        }
        else {
            System.out.println("Foldable Entity.Phone not found.");
        }
    }

    public static void removeItem() {
        Integer id = getFoldablePhoneIDToRemove();
        removeFoldablePhoneByID(id);
    }

    public static void displayAllItems() {
        System.out.println("\n--- Displaying All Foldable Phones ---");
        if (foldablePhoneList.isEmpty()) {
            System.out.println("No Foldable Phones found.");
        } else {
            for (FoldablePhone foldablePhone : foldablePhoneList) {
                System.out.println("Folding Mechanism: " + foldablePhone.getFoldingMechanism() +
                        "\n Screen Durability Folds: " + foldablePhone.getScreenDurabilityFolds() +
                        "\n Outer Display Size: " + foldablePhone.getOuterDisplaySize());
                System.out.println("-------------------------------");
            }
        }
    }

    public static boolean checkIfFoldablePhoneIdExists(int idToCheck) {
        for (FoldablePhone foldablePhone : foldablePhoneList) {
            if (foldablePhone.getId().equals(idToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static void showEditFoldablePhoneMenu() {
        System.out.print("""
                1- Edit Folding Mechanism
                2- Edit Screen Durability Folds
                3- Edit Outer Display Size
                4- Exit
                """);
    }
}
