import java.util.ArrayList;
import java.util.List;

public class AreaAggregator implements SumProvider{
    private List<HasArea> hasAreas = new ArrayList<>();

    public void addShape(HasArea shape){
        hasAreas.add(shape);
    }

    public double sum(){
        double sum=0;
        for (HasArea shape:hasAreas) {
            sum+=shape.getArea();
        }
        return sum;
    }
}
