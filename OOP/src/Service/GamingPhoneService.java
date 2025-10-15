package Service;

import Entity.GamingPhone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamingPhoneService {
    public static List<GamingPhone> gamingPhoneList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void addGamingPhone() {
        GamingPhone gamingPhone = new GamingPhone();

        System.out.println("\n--- Adding a Gaming Entity.Phone ---");
        boolean exitFlag = true;
        while (exitFlag) {
            // Enter ID of phone
            System.out.print("Enter Gaming Entity.Phone ID: ");
            Integer idOfPhone = scanner.nextInt();
            while (idOfPhone < 0 || checkIfGamingPhoneIdExists(idOfPhone)) {
                System.out.print("Invalid or duplicate ID. Enter a valid Gaming Entity.Phone ID: ");
                idOfPhone = scanner.nextInt();
            }
            gamingPhone.setId(idOfPhone);
            scanner.nextLine(); // consume newline

            //Enter GPU
            System.out.print("Enter Graphics Processing Unit (GPU) model: ");
            String gpu = scanner.nextLine();
            while (gpu.isBlank() || gpu.isEmpty()) {
                System.out.print("Invalid input. Enter a valid GPU model: ");
                gpu = scanner.nextLine();
            }
            gamingPhone.setGpu(gpu);

            System.out.print("Enter screen refresh rate in Hz (e.g., 120): ");
            Integer screenRefreshRate = scanner.nextInt();
            while (screenRefreshRate <= 0) {
                System.out.print("Invalid input. Enter screen refresh rate in Hz: ");
                screenRefreshRate = scanner.nextInt();
            }
            gamingPhone.setScreenRefreshRate(screenRefreshRate);
            scanner.nextLine();

            gamingPhoneList.add(gamingPhone);
            System.out.println("Gaming Entity.Phone added successfully!\n");

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

    public static void editGamingPhone() {
        System.out.print("\nEnter Gaming Entity.Phone ID to edit: ");
        Integer editIDInput = scanner.nextInt();
        if (editIDInput < 0) {
            System.out.println("Invalid ID");
        } else if (!checkIfGamingPhoneIdExists(editIDInput)) {
            System.out.println("ID does not exist, Exiting");
        }
        GamingPhone gamingPhoneToEdit = null;
        for (GamingPhone gamingPhone : gamingPhoneList) {
            if (checkIfGamingPhoneIdExists(editIDInput)) {
                gamingPhoneToEdit = gamingPhone;

                Integer selectToEdit = 0;
                while (selectToEdit != 3) {
                    showEditGamingPhoneMenu();
                    System.out.print("Select an option to edit: ");
                    selectToEdit = scanner.nextInt();
                    scanner.nextLine();

                    if (selectToEdit == 1) {
                        System.out.print("Enter new GPU model: ");
                        String updatedGPU = scanner.nextLine();
                        gamingPhoneToEdit.setGpu(updatedGPU);
                        System.out.println("GPU updated to: " + updatedGPU + "\n");
                    } else if (selectToEdit == 2) {
                        System.out.print("Enter new screen refresh rate in Hz: ");
                        Integer updatedRefreshRate = scanner.nextInt();
                        gamingPhoneToEdit.setScreenRefreshRate(updatedRefreshRate);
                        System.out.println("Screen refresh rate updated to: " + updatedRefreshRate + "Hz\n");
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
        System.out.print("Enter Gaming Entity.Phone ID to remove: ");
        Integer userInput = scanner.nextInt();
        if (userInput < 0 && userInput == null) {
            System.out.println("Invalid ID");
        }
        if (checkIfGamingPhoneIdExists(userInput)) {
            gamingPhoneList.removeIf(phone -> phone.getId().equals(userInput));
            System.out.println("Gaming Entity.Phone with ID " + userInput + " has been removed.\n");
        } else {
            System.out.println("ID does not exist, Exiting...");
        }
    }

    public static void displayAllItems() {
        System.out.println("\n--- Displaying All Gaming Phones ---");
        if (gamingPhoneList.isEmpty()) {
            System.out.println("No Gaming Phones found.");
        } else {
            for (GamingPhone gamingPhone : gamingPhoneList) {
                System.out.println("GPU: " + gamingPhone.getGpu() +
                        "\n Screen Refresh Rate " + gamingPhone.getScreenRefreshRate());
                System.out.println("-------------------------------");
            }
        }
    }

    public static boolean checkIfGamingPhoneIdExists(int idToCheck) {
        for (GamingPhone gamingPhone : gamingPhoneList) {
            if (gamingPhone.getId().equals(idToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static void showEditGamingPhoneMenu() {
        System.out.print("""
                1- Edit GPU
                2- Edit Screen Refresh Rate
                3- Exit
                """);
    }
}
