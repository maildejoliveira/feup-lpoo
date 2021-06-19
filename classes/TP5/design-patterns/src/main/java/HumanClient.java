public class HumanClient implements Client{
    private OrderingStrategy orderingStrategy;

    public HumanClient(OrderingStrategy strategy){
        this.orderingStrategy=strategy;
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        orderingStrategy.wants(drink,recipe,bar);
    }

    @Override
    public void happyHourStarted(Bar bar) {
        orderingStrategy.happyHourStarted(bar);
    }

    @Override
    public void happyHourEnded(Bar bar) {
        orderingStrategy.happyHourEnded(bar);
    }
}
