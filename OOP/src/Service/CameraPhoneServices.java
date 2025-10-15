package Service;

import Entity.CameraPhone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CameraPhoneServices {
    public static List<CameraPhone> cameraPhoneList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static CameraPhone addCameraPhone() {
        CameraPhone cameraPhone = new CameraPhone();

        System.out.println("Adding Camera Entity.Phone  ");
        boolean exitFlag = true;
        while (exitFlag) {
            // Enter ID of phone
            System.out.print("Enter Camera Entity.Phone ID: ");
            Integer idOfPhone = scanner.nextInt();
            while (idOfPhone < 0 || checkIfCameraPhoneIdExists(idOfPhone)) {
                System.out.print("Invalid or duplicate ID. Enter a valid Smart Entity.Phone ID: ");
                idOfPhone = scanner.nextInt();
            }
            cameraPhone.setId(idOfPhone);
            scanner.nextLine();

            System.out.print("Enter main Sensor Mega pixels: ");
            Float pixels = scanner.nextFloat();
            while (pixels < 0) {
                System.out.print("Invalid input. Enter a valid megapixel value: ");
                pixels = scanner.nextFloat();
            }
            cameraPhone.setMainSensorMegapixels(pixels);

            System.out.print("Enter optical Zoom Level: ");
            Float zoomLevel = scanner.nextFloat();
            cameraPhone.setOpticalZoomLevel(zoomLevel);
            scanner.nextLine();

            System.out.print("Enter pro Mode Features: ");
            String modeFeature = scanner.nextLine();
            cameraPhone.setProModeFeatures(modeFeature);

            // Continue or quit
            System.out.print("Press 'c' to add another or 'q' to quit: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("c")) {
                exitFlag = true;
            } else if (userInput.equalsIgnoreCase("q")) {
                exitFlag = false;
            }
        }
        return cameraPhone;
    }

    public static void save(CameraPhone cameraPhone) {
        cameraPhoneList.add(cameraPhone);
        System.out.println("Camera Smart Entity.Phone added successfully!\n");
    }

    public static CameraPhone editInput() {
        if (cameraPhoneList.isEmpty()) {
            System.out.println("No Camera Phones available to edit.");
            return null;
        }
        System.out.print("\nEnter Camera Entity.Phone ID to edit: ");
        Integer editIDInput = scanner.nextInt();
        if (editIDInput < 0) {
            System.out.println("Invalid ID");
        } else if (!checkIfCameraPhoneIdExists(editIDInput)) {
            System.out.println("ID does not exist, Exiting");
        }
        CameraPhone cameraPhoneToEdit = null;
        for (CameraPhone cameraPhone : cameraPhoneList) {
            if (checkIfCameraPhoneIdExists(editIDInput)) {
                cameraPhoneToEdit = cameraPhone;

                Integer selectToEdit = 0;
                while (selectToEdit != 4) {
                    showEditCameraPhoneMenu();
                    System.out.print("Choose what you’d like to update (1–4): ");
                    selectToEdit = scanner.nextInt();
                    scanner.nextLine();

                    if (selectToEdit == 1) {
                        System.out.print("Enter main Sensor Mega pixels: ");
                        Float updatedPixels = scanner.nextFloat();
                        cameraPhoneToEdit.setMainSensorMegapixels(updatedPixels);
                        System.out.println("Main Sensor Mega pixels updated to: " + updatedPixels + "\n");
                    } else if (selectToEdit == 2) {
                        System.out.print("Enter optical Zoom Level: ");
                        Float updatedZoomLevel = scanner.nextFloat();
                        cameraPhoneToEdit.setOpticalZoomLevel(updatedZoomLevel);
                        System.out.println("Zoom Level updated to: " + updatedZoomLevel + "Hz\n");
                    } else if (selectToEdit == 3) {
                        System.out.print("Enter pro Mode Features: ");
                        String modeFeatures = scanner.nextLine();
                        cameraPhoneToEdit.setProModeFeatures(modeFeatures);
                        System.out.println("Pro Mode Feature updated to: " + modeFeatures + "\n");
                    } else if (selectToEdit == 4) {
                        System.out.println("Exiting Edit Menu...");
                        selectToEdit = 4;
                    } else {
                        System.out.println("Invalid option. Please select 1, 2, 3 or 4.\n");
                    }
                }
            }
        }
        return cameraPhoneToEdit;
    }

    public static void update(CameraPhone updatedCameraPhone) {
        if (updatedCameraPhone == null) {
            System.out.println("No updates to save.");
            return; // exit early
        }

        boolean found = false;
        for (int i = 0; i < cameraPhoneList.size(); i++) {
            if (cameraPhoneList.get(i).getId().equals(updatedCameraPhone.getId())) {
                cameraPhoneList.set(i, updatedCameraPhone);
                System.out.println("Camera Entity.Phone updated successfully.");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Updated Camera Entity.Phone not found in list.");
        }
    }


    public static void editCameraPhone() {
        CameraPhone edited = editInput();
        update(edited);
    }

    //    public static void removeItem() {
//        //remove phone item by ID
//        System.out.print("Enter Camera Entity.Phone ID to remove: ");
//        Integer userInput = scanner.nextInt();
//        if (userInput < 0) {
//            System.out.println("Invalid ID");
//        }
//        if (checkIfCameraPhoneIdExists(userInput)) {
//            cameraPhoneList.removeIf(phone -> phone.getId().equals(userInput));
//            System.out.println("Camera Entity.Phone with ID " + userInput + " has been removed.");
//        } else {
//            System.out.println("ID does not exist, Exiting...");
//        }
//    }
    public static Integer getCameraPhoneIDToRemove() {
        if (cameraPhoneList.isEmpty()) {
            System.out.println("No Camera Phones available to remove.");
            return null;
        }

        System.out.print("Enter Camera Entity.Phone ID to remove: ");
        Integer userInput = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (userInput < 0) {
            System.out.println("Invalid ID. Must be positive.");
            return null;
        }

        return userInput;
    }

    public static void removeCameraPhoneByID(Integer cameraPhoneID) {
        if (cameraPhoneID == null) {
            System.out.println("No Camera Entity.Phone removed.");
            return;
        }
        if (checkIfCameraPhoneIdExists(cameraPhoneID)) {
            cameraPhoneList.removeIf(phone -> phone.getId().equals(cameraPhoneID));
            System.out.println("Camera Entity.Phone with ID " + cameraPhoneID + " removed successfully.");
        }
        else {
            System.out.println("Camera Entity.Phone not found.");
        }
    }

    public static void removeItem() {
        Integer id = getCameraPhoneIDToRemove();
        removeCameraPhoneByID(id);
    }

    public static void displayAllItems() {
        System.out.println("\n--- Displaying All Camera Phones ---");
        if (cameraPhoneList.isEmpty()) {
            System.out.println("No Camera Phones found.");
        } else {
            for (CameraPhone cameraPhone : cameraPhoneList) {
                System.out.println("main Sensor Mega pixels: " + cameraPhone.getMainSensorMegapixels() +
                        "\n optical Zoom Level: " + cameraPhone.getOpticalZoomLevel() +
                        "\n pro Mode Features: " + cameraPhone.getProModeFeatures());
                System.out.println("-------------------------------");
            }
        }
    }

    public static boolean checkIfCameraPhoneIdExists(int idToCheck) {
        for (CameraPhone cameraPhone : cameraPhoneList) {
            if (cameraPhone.getId().equals(idToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static void showEditCameraPhoneMenu() {
        System.out.print("""
                1- Edit main Sensor Mega pixels
                2- Edit optical Zoom Level
                3- Edit pro Mode Features
                4- Exit
                """);
    }
}
