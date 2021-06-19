public class Ellipse implements Shape{
    private double xradius, yradius;

    Ellipse(double xradius, double yradius){
        this.xradius=xradius;
        this.yradius=yradius;
    }

    public void setXradius(double xradius) {
        this.xradius = xradius;
    }

    public void setYradius(double yradius) {
        this.yradius = yradius;
    }

    public double getXradius() {
        return xradius;
    }

    public double getYradius() {
        return yradius;
    }

    @Override
    public double getArea(){
        return Math.PI*xradius*yradius;
    }

    @Override
    public void draw() {
        System.out.println("Ellipse");
    }
}
