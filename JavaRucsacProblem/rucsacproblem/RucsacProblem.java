
package rucsacproblem;
import java.util.ArrayList;
import java.util.List;


public class RucsacProblem {
   private static int maxProfit = 0;
    private static List<Item> bestItems = new ArrayList<>();

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(4, 12));  // obiectul 1
        items.add(new Item(2, 1));   // obiectul 2
        items.add(new Item(10, 4));  // obiectul 3
        items.add(new Item(2, 2));   // obiectul 4
        items.add(new Item(1, 1));   // obiectul 5

        List<Item> selectedItems = new ArrayList<>();
        rucsacBacktracking(items, selectedItems, 0, 0, 15);

        System.out.println("Valoarea maxima: " + maxProfit);
        System.out.println("Obiectele pentru profitul maxim: ");
        for (Item item : bestItems) {
            System.out.println("Valoare: " + item.value + "$ Greutate: " + item.weight + "kg");
        }

    
    }
    private static void rucsacBacktracking(List<Item> items, List<Item> selectedItems, int totalValue, int totalWeight, int maxWeight) {
        if (totalWeight > maxWeight) {
            return;
        }

        if (totalValue > maxProfit) {
            maxProfit = totalValue;
            bestItems = new ArrayList<>(selectedItems);
        }

        for (int i = 0; i < items.size(); i++) {
            Item currentItem = items.get(i);

            if (!selectedItems.contains(currentItem)) {
                selectedItems.add(currentItem);
                rucsacBacktracking(items, selectedItems, totalValue + currentItem.value, totalWeight + currentItem.weight, maxWeight);
                selectedItems.remove(currentItem);
    

           }
        }
    }
}