import java.util.*;

public class CafeOrder {
    private Map<String, Double> menu = new HashMap<>();
    private Map<String, Integer> order = new HashMap<>();

    public CafeOrder() {
        menu.put("Coffee", 50.0);
        menu.put("Tea", 30.0);
        menu.put("Cake", 70.0);
    }

    public void addItem(String item, int quantity) {
        order.put(item, order.getOrDefault(item, 0) + quantity);
    }

    public double calculateTotal() {
        double total = 0;

        for (String item : order.keySet()) {
            total += menu.get(item) * order.get(item);
        }

        if (total > 200) {
            total *= 0.9;
        }

        return total;
    }

    public void printReceipt() {
        System.out.println("=== RECEIPT ===");

        for (String item : order.keySet()) {
            System.out.println(item + " x" + order.get(item));
        }

        System.out.println("Total: " + calculateTotal());
    }

    public static void main(String[] args) {
        CafeOrder order = new CafeOrder();

        order.addItem("Coffee", 2);
        order.addItem("Cake", 1);

        order.printReceipt();
    }
}