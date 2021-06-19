import java.util.ArrayList;
import java.util.List;

public class StringTransformerGroup implements StringTransformer{
    private List<StringTransformer> transformerList=new ArrayList<>();

    public StringTransformerGroup(List<StringTransformer> transformers) {
        this.transformerList=transformers;
    }

    @Override
    public void execute(StringDrink drink) {
        String text = drink.getText();
        for (int i = 0; i < transformerList.size(); i++) {
            StringTransformer st = transformerList.get(i);
            st.execute(drink);
        }
    }

    @Override
    public void undo(StringDrink drink) {
        String text = drink.getText();
        for (int i = transformerList.size()-1; i >= 0; i--) {
            StringTransformer st = transformerList.get(i);
            st.execute(drink);
        }
    }


}
