package kz.proffix4.patterns;

import java.util.ArrayList;
import java.util.List;

/*
 * Паттерн Observer (Наблюдатель). Этот шаблон проектирования также известен под именами 
 * Dependents (Подчиненные) и Publisher-Subscriber (Издатель-Подписчик).
 * Реализация данного паттерна используется для наблюдения за состоянием объектов в системе. 
 * Если состояние объектов изменяется в процессе их жизненного цикла, то Наблюдатель оповещает 
 * другие части системы об этих событиях.
 */
interface IWeatherSubscriber {

    void notifyAboutTemperatureChange(float temperature);

    void notifyAboutHumidityChange(float humidity);

    void notifyAboutAllDataChange(IWeatherInfo weather);
}

interface IWeatherInfo {

    float getTemperature();

    float getHumidity();
}

class Weather implements IWeatherInfo {

    private float temperature;
    private float humidity;

    List<IWeatherSubscriber> subscribers = new ArrayList<IWeatherSubscriber>();

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyAboutTempChange();
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
        notifyAboutHumidityChange();
    }

    public void setTempAndHumidity(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyAboutDataChange();
    }

    public void addSubscriber(IWeatherSubscriber o) {
        subscribers.add(o);
    }

    public void removeSubscriber(IWeatherSubscriber o) {
        subscribers.remove(o);
    }

    private void notifyAboutTempChange() {
        for (IWeatherSubscriber subscriber : subscribers) {
            subscriber.notifyAboutTemperatureChange(temperature);
        }
    }

    private void notifyAboutHumidityChange() {
        for (IWeatherSubscriber subscriber : subscribers) {
            subscriber.notifyAboutHumidityChange(humidity);
        }
    }

    private void notifyAboutDataChange() {
        for (IWeatherSubscriber subscriber : subscribers) {
            subscriber.notifyAboutAllDataChange(this);
        }
    }

    @Override
    public String toString() {
        return "Weather [temperature=" + temperature + ", humidity=" + humidity + "]";
    }
}

class Subscriber1 implements IWeatherSubscriber {

    @Override
    public void notifyAboutTemperatureChange(float temperature) {
        System.out.println("первый наблюдатель: temperatureChange = " + temperature);
    }

    @Override
    public void notifyAboutHumidityChange(float humidity) {
        System.out.println("первый наблюдатель: humidityChange = " + humidity);
    }

    @Override
    public void notifyAboutAllDataChange(IWeatherInfo weather) {
        System.out.println("первый наблюдатель: " + weather);

    }
}

class Subscriber2 implements IWeatherSubscriber {

    @Override
    public void notifyAboutTemperatureChange(float temperature) {
        System.out.format("второй наблюдатель: temperatureChange = %.0f %% \n", 100 * temperature / 50);
    }

    @Override
    public void notifyAboutHumidityChange(float humidity) {
        System.out.format("второй наблюдатель: humidityChange = %.0f %% \n", humidity);
    }

    @Override
    public void notifyAboutAllDataChange(IWeatherInfo weather) {
        System.out.println("второй наблюдатель: " + weather);
    }
}

public class ObserverExample {

    public static void main(String[] args) {
        Weather weather = new Weather();
        weather.addSubscriber(new Subscriber1());
        weather.addSubscriber(new Subscriber2());
        weather.setTemperature(50);
        weather.setHumidity(90);
        weather.setTempAndHumidity(30, 75);
    }
}
