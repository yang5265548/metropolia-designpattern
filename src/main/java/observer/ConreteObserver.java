package observer;

public class ConreteObserver implements WeatherObserver{
    private String name;

    public ConreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(name + " received temperature update: " + temperature);
    }
}
