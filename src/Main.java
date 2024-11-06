import java.util.Scanner;

public class Main {

    static final Cart cart = new Cart();
    static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("========== WELCOME TO CART APPLICATION ==========");
        int input = 0;
        do {
            showMenu();
            input = getUserInput();
            switch (input) {
                case 1 -> handleShow();
                case 2 -> handleAdd();
                case 3 -> handleUpdate();
                case 4 -> handleDelete();
                case 5 -> handleExit();
                default -> System.out.println("Invalid choice. Please try again");
            }

        } while (input != 5);
        scan.close();
    }

    private static void showMenu() {
        System.out.println("""
                ========== SELECT MENU ==========
                1) VIEW ITEM
                2) ADD ITEM
                3) UPDATE ITEM
                4) DELETE ITEM
                5) EXIT MENU
                =================================
                """);
    }

    private static int getUserInput() {
        System.out.print("Your answer : ");
        int input = scan.nextInt();
        scan.nextLine();
        return input;

    }

    private static void handleShow() {
        cart.showItem();
    }

    private static void handleAdd() {
        System.out.print("Enter new Item : ");
        String newItem = scan.nextLine();
        System.out.println();
        cart.addItem(newItem);

    }

    private static void handleUpdate() {
        System.out.print("Enter index to update : ");
        int idx = scan.nextInt();
        scan.nextLine();
        System.out.println();
        if (cart.isOutOfBounds(idx - 1)) {
            System.out.println("Index out of bounds !");
            return;
        }
        System.out.print("Enter new value : ");
        String newItem = scan.next();
        System.out.println();
        cart.editItem(newItem, idx - 1);
        return;

    }

    private static void handleDelete() {
        System.out.print("Enter index to delete : ");
        int idx = scan.nextInt();
        scan.nextLine();
        System.out.println();
        if (cart.isOutOfBounds(idx - 1)) {
            System.out.println("Index out of bounds !");
            return;
        }
        cart.remove(idx - 1);
        return;
    }

    private static void handleExit() {
        System.out.println("Exit.");
        return;
    }

}
