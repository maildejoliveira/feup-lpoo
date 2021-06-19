import java.util.ArrayList;
import java.util.List;

public abstract class Bar {
    private List<BarObserver> observers=new ArrayList<>();
    private boolean isHappyHour =false;
    public boolean isHappyHour(){
        return isHappyHour;
    }
    public void startHappyHour(){
        isHappyHour=true;
        this.notifyObservers();
    }
    public void endHappyHour(){
        isHappyHour=false;
        this.notifyObservers();
    }

    public void addObserver(BarObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (BarObserver observer : observers)
            if (isHappyHour()) observer.happyHourStarted(this);
            else observer.happyHourEnded(this);
    }
}
