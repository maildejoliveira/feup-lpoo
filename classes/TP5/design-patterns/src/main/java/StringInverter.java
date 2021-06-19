public class StringInverter implements StringTransformer{
    @Override
    public void execute(StringDrink drink) {
        String text = drink.getText();
        StringBuilder text1 = new StringBuilder();
        text1.append(text);
        text1.reverse();
        drink.setText(text1.toString());
    }

    public void undo(StringDrink drink){
        this.execute(drink);
    }
}
