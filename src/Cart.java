import java.util.ArrayList;

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
     * @param newItem New item to be added
     */
    public void addItem(String newItem) {
        items.add(newItem);
    }

    /**
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
     * @param idx The index of item to be removed
     * @return true if the index provided is out of bounds from the items
     */
    public boolean isOutOfBounds(int idx) {
        return idx >= items.size();
    }

    /**
     * @return true when items is empty
     */
    private boolean isEmpty() {
        return items.isEmpty();
    }
}
