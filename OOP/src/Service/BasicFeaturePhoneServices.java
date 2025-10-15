package Service;

import Entity.BasicFeaturePhone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasicFeaturePhoneServices {
    public static List<BasicFeaturePhone> basicFeaturePhoneList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static BasicFeaturePhone addBasicFeaturePhone() {
        BasicFeaturePhone basicFeaturePhone = new BasicFeaturePhone();

        System.out.println("Adding Basic Feature Entity.Phone  ");
        boolean exitFlag = true;
        while (exitFlag) {
            // Enter ID of phone
            System.out.print("Enter Basic Feature Entity.Phone ID: ");
            Integer idOfPhone = scanner.nextInt();
            while (idOfPhone < 0 || checkIfBasicFeaturePhoneIdExists(idOfPhone)) {
                System.out.print("Invalid or duplicate ID. Enter a valid Basic Feature Entity.Phone ID: ");
                idOfPhone = scanner.nextInt();
            }
            basicFeaturePhone.setId(idOfPhone);
            scanner.nextLine();

            basicFeaturePhone.setPrimaryFunction("Calls and Text Messages");

            System.out.print("IS Screen color or monochrome? ");
            String screenColor = scanner.nextLine();
            while (!screenColor.equalsIgnoreCase("color") && !screenColor.equalsIgnoreCase("monochrome")){
                System.out.println("It should be either color or monochrome");
                screenColor = scanner.nextLine();
            }
            basicFeaturePhone.setColorScreen(screenColor);

            System.out.print("Does the phone have FM radio? (yes/no): ");
            String input = scanner.nextLine().trim().toLowerCase();
            boolean fmRadio = input.equals("yes");
            basicFeaturePhone.setFmRadio(fmRadio);

            // Continue or quit
            System.out.print("Press 'c' to add another or 'q' to quit: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("c")) {
                exitFlag = true;
            } else if (userInput.equalsIgnoreCase("q")) {
                exitFlag = false;
            }
        }
        return basicFeaturePhone;
    }

    public static void save(BasicFeaturePhone basicFeaturePhone) {
        basicFeaturePhoneList.add(basicFeaturePhone);
        System.out.println("Basic Feature Entity.Phone added successfully!\n");
    }

    public static BasicFeaturePhone editInput() {
        if (basicFeaturePhoneList.isEmpty()) {
            System.out.println("No Basic Feature Phones available to edit.");
            return null;
        }
        System.out.print("\nEnter Basic Feature Entity.Phone ID to edit: ");
        Integer editIDInput = scanner.nextInt();
        if (editIDInput < 0) {
            System.out.println("Invalid ID");
        } else if (!checkIfBasicFeaturePhoneIdExists(editIDInput)) {
            System.out.println("ID does not exist, Exiting");
        }
        BasicFeaturePhone basicFeaturePhoneToEdit = null;
        for (BasicFeaturePhone basicFeaturePhone : basicFeaturePhoneList) {
            if (checkIfBasicFeaturePhoneIdExists(editIDInput)) {
                basicFeaturePhoneToEdit = basicFeaturePhone;

                Integer selectToEdit = 0;
                while (selectToEdit != 4) {
                    showEditBasicFeaturePhoneMenu();
                    System.out.print("Choose what you’d like to update (1–3): ");
                    selectToEdit = scanner.nextInt();
                    scanner.nextLine();

                    if (selectToEdit == 1) {
                        System.out.print("Enter color Screen (color or monochrome): ");
                        String screenColor = scanner.nextLine();
                        basicFeaturePhoneToEdit.setColorScreen(screenColor);
                        System.out.println("Screen Color is: " + screenColor);
                    } else if (selectToEdit == 3) {
                        System.out.print("Does the phone have FM radio? (yes/no): ");
                        String input = scanner.nextLine();
                        boolean fmRadio = input.equals("yes");
                        basicFeaturePhone.setFmRadio(fmRadio);
                        basicFeaturePhoneToEdit.setFmRadio(fmRadio);
                        System.out.println("FM Radio updated to: " + fmRadio + "\n");
                    } else if (selectToEdit == 4) {
                        System.out.println("Exiting Edit Menu...");
                        selectToEdit = 4;
                    } else {
                        System.out.println("Invalid option. Please select 1, 2, 3.\n");
                    }
                }
            }
        }
        return basicFeaturePhoneToEdit;
    }

    public static void update(BasicFeaturePhone updatedBasicFeaturePhone) {
        if (updatedBasicFeaturePhone == null) {
            System.out.println("No updates to save.");
        }
        for (int i = 0; i < basicFeaturePhoneList.size(); i++) {
            if (basicFeaturePhoneList.get(i).getId().equals(updatedBasicFeaturePhone.getId())) {
                basicFeaturePhoneList.set(i, updatedBasicFeaturePhone);
                System.out.println("Basic Feature Entity.Phone updated successfully.");
            }
        }
        System.out.println("Updated Basic Feature Entity.Phone not found in list.");
    }


    public static void editBasicFeaturePhone() {
        BasicFeaturePhone edited = editInput();
        update(edited);
    }

    public static Integer getBasicFeaturePhoneIDToRemove() {
        if (basicFeaturePhoneList.isEmpty()) {
            System.out.println("No Basic Feature Phones available to remove.");
            return null;
        }

        System.out.print("Enter Basic Feature Entity.Phone ID to remove: ");
        Integer userInput = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (userInput < 0) {
            System.out.println("Invalid ID. Must be positive.");
            return null;
        }

        return userInput;
    }

    public static void removeBasicFeaturePhoneByID(Integer basicFeaturePhoneID) {
        if (basicFeaturePhoneID == null) {
            System.out.println("No Basic Feature Entity.Phone removed.");
            return;
        }
        if (checkIfBasicFeaturePhoneIdExists(basicFeaturePhoneID)) {
            basicFeaturePhoneList.removeIf(phone -> phone.getId().equals(basicFeaturePhoneID));
            System.out.println("Basic Feature Entity.Phone with ID " + basicFeaturePhoneID + " removed successfully.");
        } else {
            System.out.println("Basic Feature Entity.Phone not found.");
        }
    }

    public static void removeItem() {
        Integer id = getBasicFeaturePhoneIDToRemove();
        removeBasicFeaturePhoneByID(id);
    }

    public static void displayAllItems() {
        System.out.println("\n--- Displaying All Basic Feature Phones ---");
        if (basicFeaturePhoneList.isEmpty()) {
            System.out.println("No Basic Feature Phones found.");
        } else {
            for (BasicFeaturePhone basicFeaturePhone : basicFeaturePhoneList) {
                System.out.println("Primary Functions: " + basicFeaturePhone.getPrimaryFunction() +
                        "\n Screen color: " + basicFeaturePhone.getColorScreen() +
                        "\n Does the phone have FM radio? " + basicFeaturePhone.isFmRadio());
                System.out.println("-------------------------------");
            }
        }
    }

    public static boolean checkIfBasicFeaturePhoneIdExists(int idToCheck) {
        for (BasicFeaturePhone basicFeaturePhone : basicFeaturePhoneList) {
            if (basicFeaturePhone.getId().equals(idToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static void showEditBasicFeaturePhoneMenu() {
        System.out.print("""
                1- Edit Screen color
                2- Edit FM Radio
                3- Exit
                """);
    }
}
