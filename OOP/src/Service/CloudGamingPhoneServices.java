package Service;

import Entity.CloudGamingPhone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CloudGamingPhoneServices {
    public static List<CloudGamingPhone> cloudGamingPhoneList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static CloudGamingPhone addCloudGamingPhone() {
        CloudGamingPhone cloudGamingPhone = new CloudGamingPhone();

        System.out.println("Adding Cloud Gaming Entity.Phone  ");
        boolean exitFlag = true;
        while (exitFlag) {
            // Enter ID of phone
            System.out.print("Enter Cloud Gaming Entity.Phone ID: ");
            Integer idOfPhone = scanner.nextInt();
            while (idOfPhone < 0 || checkIfCloudGamingPhoneIdExists(idOfPhone)) {
                System.out.print("Invalid or duplicate ID. Enter a valid Cloud Gaming Entity.Phone ID: ");
                idOfPhone = scanner.nextInt();
            }
            cloudGamingPhone.setId(idOfPhone);
            scanner.nextLine();

            System.out.print("Enter Wifi Standard: ");
            String wifiStandardInput = scanner.nextLine();
            cloudGamingPhone.setWifiStandard(wifiStandardInput);

            System.out.print("Does it support 5GHz Wi-Fi band? (true/false): ");
            boolean fiveGBandSupport = scanner.nextBoolean();
            cloudGamingPhone.setFiveGBandSupport(fiveGBandSupport);


            System.out.print("Enter Subscription Bundle (e.g., Spotify Premium, YouTube Premium, None): ");
            String subscriptionBundle = scanner.nextLine();
            cloudGamingPhone.setSubscriptionBundle(subscriptionBundle);


            // Continue or quit
            System.out.print("Press 'c' to add another or 'q' to quit: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("c")) {
                exitFlag = true;
            } else if (userInput.equalsIgnoreCase("q")) {
                exitFlag = false;
            }
        }
        return cloudGamingPhone;
    }

    public static void save(CloudGamingPhone cloudGamingPhone) {
        cloudGamingPhoneList.add(cloudGamingPhone);
        System.out.println("Cloud Gaming Entity.Phone added successfully!\n");
    }

    public static CloudGamingPhone editInput() {
        if (cloudGamingPhoneList.isEmpty()) {
            System.out.println("No cloud Gaming Phones available to edit.");
            return null;
        }
        System.out.print("\nEnter cloud Gaming Entity.Phone ID to edit: ");
        Integer editIDInput = scanner.nextInt();
        if (editIDInput < 0) {
            System.out.println("Invalid ID");
        } else if (!checkIfCloudGamingPhoneIdExists(editIDInput)) {
            System.out.println("ID does not exist, Exiting");
        }
        CloudGamingPhone cloudGamingPhoneToEdit = null;
        for (CloudGamingPhone cloudGamingPhone : cloudGamingPhoneList) {
            if (checkIfCloudGamingPhoneIdExists(editIDInput)) {
                cloudGamingPhoneToEdit = cloudGamingPhone;

                Integer selectToEdit = 0;
                while (selectToEdit != 4) {
                    showEditCloudGamingPhoneMenu();
                    System.out.print("Choose what you’d like to update (1–3): ");
                    selectToEdit = scanner.nextInt();
                    scanner.nextLine();

                    if (selectToEdit == 1) {
                        System.out.print("Enter updated Wifi Standard: ");
                        String updatedWifiStandard = scanner.nextLine();
                        cloudGamingPhoneToEdit.setWifiStandard(updatedWifiStandard);
                        System.out.println("Wifi Standard updated to: " + updatedWifiStandard + "\n");
                    } else if (selectToEdit == 2) {
                        System.out.print("Enter updated 5GHz Band Support (true/false): ");
                        boolean fiveGBandSupport = scanner.nextBoolean();
                        cloudGamingPhoneToEdit.setFiveGBandSupport(fiveGBandSupport);
                        System.out.println("5GHz Band Support updated to: " + fiveGBandSupport + "\n");
                        scanner.nextLine();
                    } else if (selectToEdit == 3) {
                        System.out.print("Enter updated Subscription Bundle (e.g., Spotify Premium, YouTube Premium, None): ");
                        String subscriptionBundle = scanner.nextLine();
                        cloudGamingPhoneToEdit.setSubscriptionBundle(subscriptionBundle);
                        System.out.println("Subscription Bundle updated to: " + subscriptionBundle + "\n");
                    } else if (selectToEdit == 4) {
                        System.out.println("Exiting Edit Menu...");
                        selectToEdit = 4;
                    } else {
                        System.out.println("Invalid option. Please select 1, 2, 3 or 4.\n");
                    }
                }
            }
        }
        return cloudGamingPhoneToEdit;
    }

    public static void update(CloudGamingPhone updatedCloudGamingPhone) {
        if (updatedCloudGamingPhone == null) {
            System.out.println("No updates to save.");
            return; // exit early
        }
        boolean found = false;
        for (int i = 0; i < cloudGamingPhoneList.size(); i++) {
            if (cloudGamingPhoneList.get(i).getId().equals(updatedCloudGamingPhone.getId())) {
                cloudGamingPhoneList.set(i, updatedCloudGamingPhone);
                System.out.println("Cloud Gaming Entity.Phone updated successfully.");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Updated Cloud Gaming Entity.Phone not found in list.");
        }
    }


    public static void editCloudGamingPhone() {
        CloudGamingPhone edited = editInput();
        update(edited);
    }

    public static Integer getCloudGamingPhoneIDToRemove() {
        if (cloudGamingPhoneList.isEmpty()) {
            System.out.println("No cloud Gaming Phones available to remove.");
            return null;
        }

        System.out.print("Enter cloud Gaming Entity.Phone ID to remove: ");
        Integer userInput = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (userInput < 0) {
            System.out.println("Invalid ID. Must be positive.");
            return null;
        }
        return userInput;
    }

    public static void removeCloudGamingPhoneByID(Integer cloudGamingPhoneID) {
        if (cloudGamingPhoneID == null) {
            System.out.println("No cloud Gaming Entity.Phone removed.");
            return;
        }
        if (checkIfCloudGamingPhoneIdExists(cloudGamingPhoneID)) {
            cloudGamingPhoneList.removeIf(phone -> phone.getId().equals(cloudGamingPhoneID));
            System.out.println("cloud Gaming Entity.Phone with ID " + cloudGamingPhoneID + " removed successfully.");
        } else {
            System.out.println("cloud Gaming Entity.Phone not found.");
        }
    }

    public static void removeItem() {
        Integer id = getCloudGamingPhoneIDToRemove();
        removeCloudGamingPhoneByID(id);
    }

    public static void displayAllItems() {
        System.out.println("\n--- Displaying All cloud Gaming Phones ---");
        if (cloudGamingPhoneList.isEmpty()) {
            System.out.println("No cloud Gaming Phones found.");
        } else {
            for (CloudGamingPhone cloudGamingPhone : cloudGamingPhoneList) {
                System.out.println("Wifi Standard: " + cloudGamingPhone.getWifiStandard() +
                        "\n Is 5G Band Support: " + cloudGamingPhone.isFiveGBandSupport() +
                        "\n Subscription Bundle: " + cloudGamingPhone.getSubscriptionBundle());
                System.out.println("-------------------------------");
            }
        }
    }

    public static boolean checkIfCloudGamingPhoneIdExists(int idToCheck) {
        for (CloudGamingPhone cloudGamingPhone : cloudGamingPhoneList) {
            if (cloudGamingPhone.getId().equals(idToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static void showEditCloudGamingPhoneMenu() {
        System.out.print("""
                1- Edit Wifi Standard
                2- Edit 5G Band Support
                3- Edit Subscription Bundle
                4- Exit
                """);
    }
}
