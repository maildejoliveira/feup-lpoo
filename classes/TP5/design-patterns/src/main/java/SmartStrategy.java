import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy{
    private List<Order> orders = new ArrayList<>();
    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if(bar.isHappyHour()){
            bar.order(drink,recipe);
        }
        else{
            orders.add(new Order(bar,recipe,drink));
        }
    }

    @Override
    public void happyHourStarted(Bar bar) {
        for (Order o: orders) {
            o.order();
        }
    }

    @Override
    public void happyHourEnded(Bar bar) {

    }
}
