public class StringReplacer implements StringTransformer{
    private char replaceThis, toThis;

    public StringReplacer(char r, char t){
        this.replaceThis=r;
        this.toThis=t;
    }

    @Override
    public void execute(StringDrink drink) {
        /*String text = drink.getText();

        text.replace(replaceThis,toThis);*/

        String text = drink.getText();
        StringBuffer result = new StringBuffer();
        for (int i=0; i<text.length(); i++){
            if(text.charAt(i) == replaceThis){
                result.append(toThis);
            }
            else{
                result.append(text.charAt(i));
            }
        }
        drink.setText(result.toString());
    }

    public void undo(StringDrink drink){
        String text = drink.getText();
        StringBuffer result = new StringBuffer();
        for (int i=0; i<text.length(); i++){
            if(text.charAt(i) == toThis){
                result.append(replaceThis);
            }
            else{
                result.append(text.charAt(i));
            }
        }
        drink.setText(result.toString());
    }
}
