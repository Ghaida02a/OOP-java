package Service;

import Entity.FlagshipPhone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlagshipPhoneServices {
    public static List<FlagshipPhone> flagshipPhoneList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static FlagshipPhone addFlagshipPhone() {
        FlagshipPhone flagshipPhone = new FlagshipPhone();

        System.out.println("Adding Flagship Entity.Phone  ");
        boolean exitFlag = true;
        while (exitFlag) {
            // Enter ID of phone
            System.out.print("Enter Flagship Entity.Phone ID: ");
            Integer idOfPhone = scanner.nextInt();
            while (idOfPhone < 0 || checkIfFlagshipPhoneIdExists(idOfPhone)) {
                System.out.print("Invalid or duplicate ID. Enter a valid Flagship Entity.Phone ID: ");
                idOfPhone = scanner.nextInt();
            }
            flagshipPhone.setId(idOfPhone);
            scanner.nextLine();

            System.out.print("Enter Processor Model: ");
            String processorModel = scanner.nextLine();
            flagshipPhone.setProcessorModel(processorModel);

            showBiometricSecurityMenu();
            Integer biometricSecurityInput = scanner.nextInt();
            while (biometricSecurityInput != 4) {
                if (biometricSecurityInput == 1) {
                    flagshipPhone.setBiometricSecurity("Fingerprint Scanner");
                    System.out.println("Biometric Security set to: Fingerprint Scanner");
                } else if (biometricSecurityInput == 2) {
                    flagshipPhone.setBiometricSecurity("Face Recognition");
                    System.out.println("Biometric Security set to: Face Recognition");
                } else if (biometricSecurityInput == 3) {
                    flagshipPhone.setBiometricSecurity("Voice Recognition");
                    System.out.println("Biometric Security set to: Voice Recognition");
                } else if (biometricSecurityInput == 4) {
                    System.out.println("Exiting Edit Menu...");
                    biometricSecurityInput = 4;
                } else {
                    System.out.println("Invalid option. Please select 1, 2, 3 or 4.\n");
                }
            }

            System.out.print("Enter outer Display Size (in inches): ");
            Float wirelessChargingSpeed = scanner.nextFloat();
            while (wirelessChargingSpeed <= 0) {
                System.out.print("Invalid input. Please enter a positive number for Wireless Charging Speed: ");
                wirelessChargingSpeed = scanner.nextFloat();
            }
            scanner.nextLine();
            flagshipPhone.setWirelessChargingSpeed(wirelessChargingSpeed);

            // Continue or quit
            System.out.print("Press 'c' to add another or 'q' to quit: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("c")) {
                exitFlag = true;
            } else if (userInput.equalsIgnoreCase("q")) {
                exitFlag = false;
            }
        }
        return flagshipPhone;
    }

    public static void save(FlagshipPhone flagshipPhone) {
        flagshipPhoneList.add(flagshipPhone);
        System.out.println("Flagship Entity.Phone added successfully!\n");
    }

    public static FlagshipPhone editInput() {
        if (flagshipPhoneList.isEmpty()) {
            System.out.println("No Flagship Phones available to edit.");
            return null;
        }
        System.out.print("\nEnter Flagship Entity.Phone ID to edit: ");
        Integer editIDInput = scanner.nextInt();
        if (editIDInput < 0) {
            System.out.println("Invalid ID");
        } else if (!checkIfFlagshipPhoneIdExists(editIDInput)) {
            System.out.println("ID does not exist, Exiting");
        }
        FlagshipPhone flagshipPhoneToEdit = null;
        for (FlagshipPhone flagshipPhone : flagshipPhoneList) {
            if (checkIfFlagshipPhoneIdExists(editIDInput)) {
                flagshipPhoneToEdit = flagshipPhone;

                Integer selectToEdit = 0;
                while (selectToEdit != 4) {
                    showEditFlagshipPhoneMenu();
                    System.out.print("Choose what you’d like to update (1–3): ");
                    selectToEdit = scanner.nextInt();
                    scanner.nextLine();

                    if (selectToEdit == 1) {
                        System.out.print("Enter updated Processor Model: ");
                        String updatedProcessorModel = scanner.nextLine();
                        flagshipPhoneToEdit.setProcessorModel(updatedProcessorModel);
                        System.out.println("Processor Model updated to: " + updatedProcessorModel + "\n");
                    } else if (selectToEdit == 2) {
                        showBiometricSecurityMenu();
                        Integer biometricSecurityInput = scanner.nextInt();
                        while (biometricSecurityInput != 4) {
                            if (biometricSecurityInput == 1) {
                                flagshipPhone.setBiometricSecurity("Fingerprint Scanner");
                                System.out.println("Biometric Security set to: Fingerprint Scanner");
                            } else if (biometricSecurityInput == 2) {
                                flagshipPhone.setBiometricSecurity("Face Recognition");
                                System.out.println("Biometric Security set to: Face Recognition");
                            } else if (biometricSecurityInput == 3) {
                                flagshipPhone.setBiometricSecurity("Voice Recognition");
                                System.out.println("Biometric Security set to: Voice Recognition");
                            } else if (biometricSecurityInput == 4) {
                                System.out.println("Exiting Edit Menu...");
                                biometricSecurityInput = 4;
                            } else {
                                System.out.println("Invalid option. Please select 1, 2, 3 or 4.\n");
                            }
                        }
                        System.out.println("Biometric Security updated to: " + biometricSecurityInput);
                    } else if (selectToEdit == 3) {
                        System.out.print("Enter updated Wireless Charging Speed: ");
                        Float wirelessSpeed = scanner.nextFloat();
                        flagshipPhoneToEdit.setWirelessChargingSpeed(wirelessSpeed);
                        System.out.println("Wireless Charging Speed: " + wirelessSpeed + "\n");
                    } else if (selectToEdit == 4) {
                        System.out.println("Exiting Edit Menu...");
                        selectToEdit = 4;
                    } else {
                        System.out.println("Invalid option. Please select 1, 2, 3 or 4.\n");
                    }
                }
            }
        }
        return flagshipPhoneToEdit;
    }

    public static void update(FlagshipPhone updatedFlagshipPhone) {
        if (updatedFlagshipPhone == null) {
            System.out.println("No updates to save.");
        }
        boolean found = false;
        for (int i = 0; i < flagshipPhoneList.size(); i++) {
            if (flagshipPhoneList.get(i).getId().equals(updatedFlagshipPhone.getId())) {
                flagshipPhoneList.set(i, updatedFlagshipPhone);
                System.out.println("Flagship Entity.Phone updated successfully.");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Updated Flagship Entity.Phone not found in list.");
        }
    }


    public static void editFlagshipPhone() {
        FlagshipPhone edited = editInput();
        update(edited);
    }

    public static Integer getFlagshipPhoneIDToRemove() {
        if (flagshipPhoneList.isEmpty()) {
            System.out.println("No Flagship Phones available to remove.");
            return null;
        }

        System.out.print("Enter Flagship Entity.Phone ID to remove: ");
        Integer userInput = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (userInput < 0) {
            System.out.println("Invalid ID. Must be positive.");
            return null;
        }

        return userInput;
    }

    public static void removeFlagshipPhoneByID(Integer flagshipPhoneID) {
        if (flagshipPhoneID == null) {
            System.out.println("No Flagship Entity.Phone removed.");
            return;
        }
        if (checkIfFlagshipPhoneIdExists(flagshipPhoneID)) {
            flagshipPhoneList.removeIf(phone -> phone.getId().equals(flagshipPhoneID));
            System.out.println("Flagship Entity.Phone with ID " + flagshipPhoneID + " removed successfully.");
        } else {
            System.out.println("Flagship Entity.Phone not found.");
        }
    }

    public static void removeItem() {
        Integer id = getFlagshipPhoneIDToRemove();
        removeFlagshipPhoneByID(id);
    }

    public static void displayAllItems() {
        System.out.println("\n--- Displaying All Flagship Phones ---");
        if (flagshipPhoneList.isEmpty()) {
            System.out.println("No Flagship Phones found.");
        } else {
            for (FlagshipPhone flagshipPhone : flagshipPhoneList) {
                System.out.println("Processor Model: " + flagshipPhone.getProcessorModel() +
                        "\n Biometric Security: " + flagshipPhone.getBiometricSecurity() +
                        "\n Wireless Charging Speed: " + flagshipPhone.getWirelessChargingSpeed());
                System.out.println("-------------------------------");
            }
        }
    }

    public static boolean checkIfFlagshipPhoneIdExists(int idToCheck) {
        for (FlagshipPhone flagshipPhone : flagshipPhoneList) {
            if (flagshipPhone.getId().equals(idToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static void showEditFlagshipPhoneMenu() {
        System.out.print("""
                1- Edit Processor Model
                2- Edit Biometric Security
                3- Edit Wireless Charging Speed
                4- Exit
                """);
    }

    public static void showBiometricSecurityMenu() {
        System.out.print("""
                1- Fingerprint Scanner
                2- Face Recognition
                3- Voice Recognition
                4- Exit
                 Enter your choice:
                """);
    }
}
