import java.util.ArrayList;
import java.util.List;

public class City implements SumProvider{
    List<House> houseList= new ArrayList<>();

    public City(List<House> houses){
        this.houseList=houses;
    }

    public double sum(){
        double sum=0;
        for (House house:houseList) {
            sum+=house.getArea();
        }
        return sum;
    }

}
