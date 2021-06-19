public class Order{
    private StringBar bar;
    private StringRecipe recipe;
    private StringDrink drink;

    public Order(StringBar b,StringRecipe r,StringDrink d){
        this.bar=b;
        this.recipe=r;
        this.drink=d;
    }

    public void order(){
        bar.order(drink,recipe);
    }
}
