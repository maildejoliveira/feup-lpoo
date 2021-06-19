public class House implements HasArea{
    private double size;
    public House(double size) {
        this.size=size;
    }

    @Override
    public double getArea() {
        return size;
    }
}
