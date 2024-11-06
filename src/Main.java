import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Contain main execution of the program
 */
public class Main {

    static final Cart cart = new Cart();
    static final Scanner scan = new Scanner(System.in);

    /**
     * Main exection method of program
     */
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

    /**
     * Show available program menu
     */
    public static void showMenu() {
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

    /**
     * Prompts the user to enter an integer and handles invalid input.
     *
     * <p>
     * This method will continually prompt the user until a valid integer is
     * entered.
     * If the user inputs a non-integer value, an error message is displayed, and
     * the
     * user is asked to try again.
     * </p>
     *
     * @return the integer entered by the user.
     */
    public static int getUserInput() {
        int input = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Your answer: ");
                input = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scan.nextLine();
            }
        }
        return input;

    }

    /**
     * Display item in cart
     */
    public static void handleShow() {
        cart.showItem();
    }

    /**
     * Retrieve string contains new item to be added
     */
    public static void handleAdd() {
        System.out.print("Enter new Item : ");
        String newItem = scan.nextLine();
        System.out.println();
        cart.addItem(newItem);

    }

    /**
     * Retrieve index to be updated from user and update corresponding item
     */
    public static void handleUpdate() {
        try {
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
        } catch (InputMismatchException e) {
            System.out.println("Invalid index");
            scan.nextLine();
        }

    }

    /**
     * Retrieve index to be deleted from user and delete corresponding item
     */
    public static void handleDelete() {
        try {
            System.out.print("Enter index to delete : ");
            int idx = scan.nextInt();
            scan.nextLine();
            System.out.println();
            if (cart.isOutOfBounds(idx - 1)) {
                System.out.println("Index out of bounds !");
                return;
            }
            cart.remove(idx - 1);

        } catch (InputMismatchException e) {
            System.out.println("Invalid index");
            scan.nextLine();
        }
    }

    /**
     * Display exit message and exit program
     */
    public static void handleExit() {
        System.out.println("Exit");
        return;
    }

}
