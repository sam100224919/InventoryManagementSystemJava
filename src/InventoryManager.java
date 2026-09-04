import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<String, Item> inventory = new HashMap<>();

    public void addItem(Item item) {
        inventory.put(item.getId(), item);
    }

    public Item getItem(String id) {
        return inventory.get(id);
    }

    public Collection<Item> getAllItems() {
        return inventory.values();
    }

    public void updateStock(String id, int newQuantity) {
        Item item = inventory.get(id);
        if (item != null) {
            item.setQuantity(newQuantity);
        }
    }

    public void deleteItem(String id) {
        inventory.remove(id);
    }

    public double calculateTotalValue() {
        double total = 0;
        for (Item item : inventory.values()) {
            total += item.getQuantity() * item.getPrice();
        }
        return total;
    }
}