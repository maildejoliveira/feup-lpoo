import java.util.ArrayList;
import java.util.List;

public class StringRecipe {
    private List<StringTransformer> transformerList = new ArrayList<>();

    public StringRecipe(List<StringTransformer> transformers) {
        this.transformerList=transformers;
    }

    public void mix(StringDrink drink) {
        String text = drink.getText();
        for (int i = 0; i < transformerList.size(); i++) {
            StringTransformer st = transformerList.get(i);
            st.execute(drink);
        }
    }
}
