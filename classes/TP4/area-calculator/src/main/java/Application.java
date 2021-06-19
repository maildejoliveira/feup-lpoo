import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        AreaAggregator areaAggregator = new AreaAggregator();

        areaAggregator.addShape(new Circle(5));
        areaAggregator.addShape(new Square(10));
        areaAggregator.addShape(new Ellipse(2,3));
        areaAggregator.addShape(new Rectangle(10,5));
        areaAggregator.addShape(new Triangle(10,2));
        areaAggregator.addShape(new House(100));

        AreaStringOutputter stringOutputter = new AreaStringOutputter(areaAggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(areaAggregator);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());

        List<House> houses = new ArrayList<>();
        houses.add(new House(50));
        houses.add(new House(150));

        City city = new City(houses);

        AreaStringOutputter cityStringOutputter = new AreaStringOutputter(city);
        AreaXMLOutputter cityXmlOutputter = new AreaXMLOutputter(city);

        System.out.println(cityStringOutputter.output());
        System.out.println(cityXmlOutputter.output());
    }
}
