import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add Item");
            System.out.println("2. View Inventory");
            System.out.println("3. Update Stock");
            System.out.println("4. Delete Item");
            System.out.println("5. View Total Inventory Value");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Item ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Item Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();

                    manager.addItem(new Item(id, name, qty, price));
                    System.out.println("Item added successfully.");
                    break;

                case 2:
                    System.out.println("\n--- Current Inventory ---");
                    if (manager.getAllItems().isEmpty()) {
                        System.out.println("Inventory is empty.");
                    } else {
                        for (Item item : manager.getAllItems()) {
                            System.out.println(item);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Item ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQty = scanner.nextInt();
                    manager.updateStock(updateId, newQty);
                    System.out.println("Stock updated.");
                    break;

                case 4:
                    System.out.print("Enter Item ID to delete: ");
                    String deleteId = scanner.nextLine();
                    manager.deleteItem(deleteId);
                    System.out.println("Item deleted.");
                    break;

                case 5:
                    double totalValue = manager.calculateTotalValue();
                    System.out.printf("Total Inventory Value: $%.2f\n", totalValue);
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}