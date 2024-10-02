// Subject (Weather Station)
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String temperature);
}

class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private String temperature;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

// Concrete Observers
class PhoneDisplay implements Observer {
    @Override
    public void update(String temperature) {
        System.out.println("Phone display: Temperature is now " + temperature);
    }
}

class TVDisplay implements Observer {
    @Override
    public void update(String temperature) {
        System.out.println("TV display: Temperature is now " + temperature);
    }
}

// Usage
public class ObserverPatternExample {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        PhoneDisplay phoneDisplay = new PhoneDisplay();
        TVDisplay tvDisplay = new TVDisplay();

        weatherStation.attach(phoneDisplay);
        weatherStation.attach(tvDisplay);

        weatherStation.setTemperature("80°C"); // Both displays get updated
    }
}
