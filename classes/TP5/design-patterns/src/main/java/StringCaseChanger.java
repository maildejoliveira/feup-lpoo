public class StringCaseChanger implements StringTransformer{

    @Override
    public void execute(StringDrink drink) {
        String text = drink.getText();
        StringBuffer result = new StringBuffer();
        for (int i=0; i<text.length(); i++){
            if(Character.isLowerCase(text.charAt(i))){
                result.append(Character.toUpperCase(text.charAt(i)));
            }
            else{
                result.append(Character.toLowerCase(text.charAt(i)));
            }
        }
        drink.setText(result.toString());
    }

    public void undo(StringDrink drink){
        this.execute(drink);
    }
}
