package Service;

import Entity.Phone;
import main.PhoneDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneService {
    public static List<Phone> phoneList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void addItem() {
        Phone phone = new Phone();

        System.out.println("Adding an item...");

        boolean exitFlag = true;
        while (exitFlag) {
            // Enter ID of phone
            System.out.print("Enter id: ");
            Integer idOfPhone = scanner.nextInt();
            while (idOfPhone < 0 || idOfPhone == null || checkIfPhoneIdExists(idOfPhone)) {
                System.out.print("Enter a valid id: ");
                idOfPhone = scanner.nextInt();
            }
            phone.setId(idOfPhone);
            scanner.nextLine();

            // Enter Name of phone
            System.out.print("Enter item name: ");
            String itemName = scanner.nextLine();
            while (itemName.isBlank() || itemName.isEmpty()) {
                System.out.print("Enter a valid phone name: ");
                itemName = scanner.nextLine();
            }
            phone.setName(itemName);

            // Enter Brand of phone
            System.out.print("Enter phone brand: ");
            String brand = scanner.nextLine();
            while (brand.isBlank()) {
                System.out.print("Enter a valid phone brand: ");
                brand = scanner.nextLine();
            }
            phone.setBrand(brand);

            // Enter Color of phone
            System.out.print("Enter phone color: ");
            String color = scanner.nextLine();
            while (color.isBlank()) {
                System.out.print("Enter a valid color of phone: ");
                color = scanner.nextLine();
            }
            phone.setColor(color);

            // Enter Price of phone
            System.out.print("Enter phone price (OMR): ");
            double price = scanner.nextDouble();
            while (price <= 0) {
                System.out.print("Enter a valid price of phone: ");
                price = scanner.nextDouble();
            }
            phone.setPrice(price);

            //Enter quantity
            System.out.print("Enter quantity: ");
            Integer quantity = scanner.nextInt();
            if (quantity <= 0) {
                quantity = 1;  // default
            }
            phone.setQuantity(quantity);
            scanner.nextLine();

            phoneList.add(phone);
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
        if (editIDInput < 0 && editIDInput == null) {
            System.out.println("Invalid ID");
        } else if (!checkIfPhoneIdExists(editIDInput)) {
            System.out.println("ID does not exist, exiting");
        }
        Phone phoneToEdit = null;
        for (Phone phone : phoneList) {
            if (checkIfPhoneIdExists(editIDInput)) {
                phoneToEdit = phone;


                Integer selectToEdit = 0;
                while (selectToEdit != 6) {
                    PhoneDriver.showEditMenu();
                    System.out.print("What do you to edit: ");
                    selectToEdit = scanner.nextInt();
                    scanner.nextLine();

                    if (selectToEdit == 1) {
                        System.out.print("Enter updated name: ");
                        String itemNameUpdated = scanner.nextLine();
                        phoneToEdit.setName(itemNameUpdated);

                    } else if (selectToEdit == 2) {
                        System.out.print("Enter updated Brand: ");
                        String itemBrandUpdated = scanner.nextLine();
                        phoneToEdit.setBrand(itemBrandUpdated);
                    } else if (selectToEdit == 3) {
                        System.out.print("Enter updated Price: ");
                        Double itemPriceUpdated = scanner.nextDouble();
                        phoneToEdit.setPrice(itemPriceUpdated);
                    } else if (selectToEdit == 4) {
                        System.out.print("Enter updated Color: ");
                        String itemColorUpdated = scanner.nextLine();
                        phoneToEdit.setColor(itemColorUpdated);
                    } else if (selectToEdit == 5) {
                        System.out.print("Enter updated Quantity: ");
                        Integer itemQuantityUpdated = scanner.nextInt();
                        phoneToEdit.setQuantity(itemQuantityUpdated);
                    } else if (selectToEdit == 6) {
                        System.out.println("Exiting Edit Menu...");
                        selectToEdit = 6;
                    } else {
                        System.out.println("Invalid option");
                    }
                }
            }
        }
    }

    public static void removeItem() {
        //remove phone item by ID
        System.out.print("Enter id phone to remove: ");
        Integer userInput = scanner.nextInt();
        if (userInput < 0 && userInput == null) {
            System.out.println("Invalid ID");
        }
        if(checkIfPhoneIdExists(userInput)){
            phoneList.removeIf(phone -> phone.getId() == userInput);
            System.out.println("Entity.Phone item is removed");
        }
        else {
            System.out.println("ID does not exist, Exiting...");
        }

    }

    public static void displayAllItems() {
        System.out.println("Display All Items");
        if (phoneList.isEmpty()) {
            System.out.println("No items found.");
        } else {
            for (Phone phone : phoneList) {
                System.out.println(" Entity.Phone name: " + phone.getName() +
                        "\n Brand name: " + phone.getBrand() +
                        "\n Entity.Phone color: " + phone.getColor() +
                        "\n Entity.Phone price: " + phone.getPrice() +
                        "\n Quantity: " + phone.getQuantity() + "\n");
            }
        }
    }

    public static boolean checkIfPhoneIdExists(int idToCheck) {
        for (Phone phone : phoneList) {
            if (phone.getId() == idToCheck) {
                return true;
            }
        }
        return false;
    }
}
