package Service;

import Entity.BaseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseService {
    public static List<BaseEntity> baseEntityList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void addItem() {
        BaseEntity baseEntity = new BaseEntity();

        System.out.println("Adding an ID...");

        boolean exitFlag = true;
        while (exitFlag) {
            // Enter ID of phone
            System.out.print("Enter id: ");
            Integer idOfPhone = scanner.nextInt();
            while (idOfPhone < 0 || checkIfIdExists(idOfPhone)) {
                System.out.print("Enter a valid id: ");
                idOfPhone = scanner.nextInt();
            }
            baseEntity.setId(idOfPhone);
            scanner.nextLine();

            //CreatedDate
            String createdDate = String.valueOf(LocalDateTime.now());
            ;
            baseEntity.setCreatedDate(createdDate);

            baseEntityList.add(baseEntity);
            System.out.println("Successfully added");

            System.out.print("To continue press (c) or press (q) + Enter to quit: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("c")) {
                exitFlag = true;
            } else if (userInput.equalsIgnoreCase("q")) {
                exitFlag = false;
            }
        }
    }

    public static void editItem() {
        System.out.print("Enter id phone to edit: ");
        Integer editIDInput = scanner.nextInt();
        scanner.nextLine();
        BaseEntity entityToEdit = null;
        if (editIDInput < 0 && editIDInput == null) {
            System.out.println("Invalid ID");
        } else if (!checkIfIdExists(editIDInput)) {
            System.out.println("ID does not exist, exiting");
        } else {
            String newUpdatedDate = String.valueOf(LocalDateTime.now());
            entityToEdit.setUpdatedDate(newUpdatedDate);

            System.out.println("Updated 'updatedDate' to: " + newUpdatedDate);
        }

    }

    public static void removeItem() {
        //remove phone item by ID
        System.out.print("Enter ID to remove: ");
        Integer userInput = scanner.nextInt();
        scanner.nextLine();
        if (userInput < 0 && userInput == null) {
            System.out.println("Invalid ID");
        }
        if (checkIfIdExists(userInput)) {
            baseEntityList.removeIf(phone -> phone.getId() == userInput);
            System.out.println("Item is removed");
        }
    }

    public static void displayAllItems() {
        System.out.println("Display All Items");
        if (baseEntityList.isEmpty()) {
            System.out.println("No items found.");
        } else {
            for (BaseEntity baseEntity : baseEntityList) {
                System.out.println("Created Date: " + baseEntity.getCreatedDate() +
                        "\n Updated Date: " + baseEntity.getUpdatedDate() +
                        "\n");
            }
        }
    }

    public static boolean checkIfIdExists(int idToCheck) {
        for (BaseEntity baseEntity : baseEntityList) {
            if (baseEntity.getId() == idToCheck) {
                return true;
            }
        }
        return false;
    }
}
