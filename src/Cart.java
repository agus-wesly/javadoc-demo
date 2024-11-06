import java.util.ArrayList;

/**
 * Contain cart to be used in program
 */
public class Cart {
    ArrayList<String> items;

    public Cart() {
        this.items = new ArrayList<String>();
    }

    /**
     * Display current items in the cart;
     */
    public void showItem() {
        System.out.println("\n\nITEM IN THE CART : ");
        if (isEmpty()) {
            System.out.println("NO ITEM");
        } else {
            for (int i = 0; i < items.size(); ++i) {
                System.out.print(i + 1 + ") ");
                System.out.println(items.get(i));

            }
        }
        System.out.println("\n\n");
    }

    /**
     * Add new item to the cart
     *
     * @param newItem New item to be added
     */
    public void addItem(String newItem) {
        items.add(newItem);
    }

    /**
     * Edit item with corresponding index
     *
     * @param newItem New item that replacing old item
     * @param idx     The index of item to be edited
     */
    public void editItem(String newItem, int idx) {
        if (isEmpty()) {
            System.out.println("Cannot edit : Empty cart");
            return;
        }
        items.set(idx, newItem);
    }

    /**
     * Remove item in the cart with corresponding index
     *
     * @param idx The index of item to be removed
     */
    public void remove(int idx) {
        if (isEmpty()) {
            System.out.println("Cannot delete : Empty cart");
            return;
        }
        items.remove(idx);
    }

    /**
     * Check if index is out of bounds
     *
     * @param idx The index of item to be removed
     * @return true if the index provided is out of bounds from the cart
     */
    public boolean isOutOfBounds(int idx) {
        return idx >= items.size();
    }

    /**
     * Check if the cart is empty
     *
     * @return true when cart is empty
     */
    private boolean isEmpty() {
        return items.isEmpty();
    }
}
