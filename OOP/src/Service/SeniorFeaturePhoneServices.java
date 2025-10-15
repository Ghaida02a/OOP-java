package Service;

import Entity.SeniorFeaturePhone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeniorFeaturePhoneServices {
    public static List<SeniorFeaturePhone> seniorFeaturePhoneList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static SeniorFeaturePhone addSeniorFeaturePhone() {
        SeniorFeaturePhone seniorFeaturePhone = new SeniorFeaturePhone();

        System.out.println("Adding Senior Feature Entity.Phone  ");
        boolean exitFlag = true;
        while (exitFlag) {
            // Enter ID of phone
            System.out.print("Enter Senior Feature Entity.Phone ID: ");
            Integer idOfPhone = scanner.nextInt();
            while (idOfPhone < 0 || checkIfSeniorFeaturePhoneIdExists(idOfPhone)) {
                System.out.print("Invalid or duplicate ID. Enter a valid Senior Feature Entity.Phone ID: ");
                idOfPhone = scanner.nextInt();
            }
            seniorFeaturePhone.setId(idOfPhone);
            scanner.nextLine();

            System.out.print("Enter large Button Size: ");
            int buttonSize = scanner.nextInt();
            while (buttonSize < 0) {
                System.out.print("Invalid input, Re-Enter positive size: ");
                buttonSize = scanner.nextInt();
            }
            scanner.nextLine();
            seniorFeaturePhone.setLargeButtonSize(buttonSize);

            System.out.print("Does the phone have a dedicated SOS Button? (yes/no): ");
            String sosInput = scanner.nextLine();
            while (!sosInput.equalsIgnoreCase("yes") && !sosInput.equalsIgnoreCase("no")) {
                System.out.print("Invalid input. Please enter 'yes' or 'no': ");
                sosInput = scanner.nextLine();
            }
            boolean sosButton = sosInput.equalsIgnoreCase("yes");
            seniorFeaturePhone.setSosButton(sosButton);
            System.out.println("SOS Button set to: " + sosButton);

            System.out.print("Is the phone compatible with hearing aids? (yes/no): ");
            String hearingAidInput = scanner.nextLine();
            while (!hearingAidInput.equalsIgnoreCase("yes") && !hearingAidInput.equalsIgnoreCase("no")) {
                System.out.print("Invalid input. Please enter 'yes' or 'no': ");
                hearingAidInput = scanner.nextLine();
            }
            boolean hearingAidCompatibility = hearingAidInput.equalsIgnoreCase("yes");
            seniorFeaturePhone.setHearingAidCompatibility(hearingAidCompatibility);
            System.out.println("Hearing Aid Compatibility set to: " + hearingAidCompatibility);

            // Continue or quit
            System.out.print("Press 'c' to add another or 'q' to quit: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("c")) {
                exitFlag = true;
            } else if (userInput.equalsIgnoreCase("q")) {
                exitFlag = false;
            }
        }
        return seniorFeaturePhone;
    }

    public static void save(SeniorFeaturePhone seniorFeaturePhone) {
        seniorFeaturePhoneList.add(seniorFeaturePhone);
        System.out.println("Senior Feature Entity.Phone added successfully!\n");
    }

    public static SeniorFeaturePhone editInput() {
        if (seniorFeaturePhoneList.isEmpty()) {
            System.out.println("No Senior Feature Phones available to edit.");
            return null;
        }
        System.out.print("\nEnter Senior Feature Entity.Phone ID to edit: ");
        Integer editIDInput = scanner.nextInt();
        if (editIDInput < 0) {
            System.out.println("Invalid ID");
        } else if (!checkIfSeniorFeaturePhoneIdExists(editIDInput)) {
            System.out.println("ID does not exist, Exiting");
        }
        SeniorFeaturePhone seniorFeaturePhoneToEdit = null;
        for (SeniorFeaturePhone seniorFeaturePhone : seniorFeaturePhoneList) {
            if (checkIfSeniorFeaturePhoneIdExists(editIDInput)) {
                seniorFeaturePhoneToEdit = seniorFeaturePhone;

                Integer selectToEdit = 0;
                while (selectToEdit != 4) {
                    showEditSeniorFeaturePhoneMenu();
                    System.out.print("Choose what you’d like to update (1–3): ");
                    selectToEdit = scanner.nextInt();
                    scanner.nextLine();

                    if (selectToEdit == 1) {
                        System.out.print("Enter updated Button Size: ");
                        int buttonSizeInput = scanner.nextInt();
                        seniorFeaturePhoneToEdit.setLargeButtonSize(buttonSizeInput);
                        System.out.println("Button Size updated to: " + buttonSizeInput + "\n");
                    } else if (selectToEdit == 2) {
                        System.out.print("Does the phone have a dedicated SOS Button? (yes/no): ");
                        String sosInput = scanner.nextLine();
                        boolean updatedSosButton = sosInput.equalsIgnoreCase("yes");
                        seniorFeaturePhoneToEdit.setSosButton(updatedSosButton);
                        System.out.println("SOS Button updated to: " + updatedSosButton + "\n");
                    } else if (selectToEdit == 3) {
                        System.out.print("Is the phone rated for use with hearing aids? (yes/no): ");
                        String hearingAidInput = scanner.nextLine().trim();
                        boolean updatedHearingAidCompatibility = hearingAidInput.equalsIgnoreCase("yes");
                        seniorFeaturePhoneToEdit.setHearingAidCompatibility(updatedHearingAidCompatibility);
                        System.out.println("Hearing Aid Compatibility updated to: " + updatedHearingAidCompatibility + "\n");
                    } else if (selectToEdit == 4) {
                        System.out.println("Exiting Edit Menu...");
                        selectToEdit = 4;
                    } else {
                        System.out.println("Invalid option. Please select 1, 2, 3 or 4.\n");
                    }
                }
            }
        }
        return seniorFeaturePhoneToEdit;
    }

    public static void update(SeniorFeaturePhone updatedSeniorFeaturePhone) {
        if (updatedSeniorFeaturePhone == null) {
            System.out.println("No updates to save.");
            return;
        }
        for (int i = 0; i < seniorFeaturePhoneList.size(); i++) {
            if (seniorFeaturePhoneList.get(i).getId().equals(updatedSeniorFeaturePhone.getId())) {
                seniorFeaturePhoneList.set(i, updatedSeniorFeaturePhone);
                System.out.println("Senior Feature Phone updated successfully.");
                return;
            }
        }
        System.out.println("Senior Feature Phone not found.");
    }


    public static void editSeniorFeaturePhone() {
        SeniorFeaturePhone edited = editInput();
        update(edited);
    }

    public static Integer getSeniorFeaturePhoneIDToRemove() {
        if (seniorFeaturePhoneList.isEmpty()) {
            System.out.println("No Senior Feature Phones available to remove.");
            return null;
        }

        System.out.print("Enter Senior Feature Entity.Phone ID to remove: ");
        Integer userInput = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (userInput < 0) {
            System.out.println("Invalid ID. Must be positive.");
            return null;
        }

        return userInput;
    }

    public static void removeSeniorFeaturePhoneByID(Integer seniorFeaturePhoneID) {
        if (seniorFeaturePhoneID == null) {
            System.out.println("No Senior Feature Entity.Phone removed.");
            return;
        }
        if (checkIfSeniorFeaturePhoneIdExists(seniorFeaturePhoneID)) {
            seniorFeaturePhoneList.removeIf(phone -> phone.getId().equals(seniorFeaturePhoneID));
            System.out.println("Senior Feature Entity.Phone with ID " + seniorFeaturePhoneID + " removed successfully.");
        } else {
            System.out.println("Senior Feature Entity.Phone not found.");
        }
    }

    public static void removeItem() {
        Integer id = getSeniorFeaturePhoneIDToRemove();
        removeSeniorFeaturePhoneByID(id);
    }

    public static void displayAllItems() {
        System.out.println("\n--- Displaying All Senior Feature Phones ---");
        if (seniorFeaturePhoneList.isEmpty()) {
            System.out.println("No Senior Feature Phones found.");
        } else {
            for (SeniorFeaturePhone seniorFeaturePhone : seniorFeaturePhoneList) {
                System.out.println("Large Button Size: " + seniorFeaturePhone.getLargeButtonSize() +
                        "\nSOS Button: " + seniorFeaturePhone.isSosButton() +
                        "\nHearing Aid Compatible: " + seniorFeaturePhone.isHearingAidCompatibility());

                System.out.println("-------------------------------");
            }
        }
    }

    public static boolean checkIfSeniorFeaturePhoneIdExists(int idToCheck) {
        for (SeniorFeaturePhone seniorFeaturePhone : seniorFeaturePhoneList) {
            if (seniorFeaturePhone.getId().equals(idToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static void showEditSeniorFeaturePhoneMenu() {
        System.out.print("""
                1- Edit Large Button Size
                2- Edit SOS Button
                3- Edit Hearing Aid Compatibility
                4- Exit
                """);
    }
}
