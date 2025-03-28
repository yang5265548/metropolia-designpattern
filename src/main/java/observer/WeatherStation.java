package observer;


import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class WeatherStation implements Runnable{
    private final List<WeatherObserver> observers=new CopyOnWriteArrayList<>();
    private int temperature;
    private final Random random=new Random();
    private final int MIN_TEMP =-10;
    private final int MAX_TEMP =40;
    private volatile boolean running=true;

    public WeatherStation(){
        this.temperature=random.nextInt(MAX_TEMP -MIN_TEMP+1)+MIN_TEMP;
    }

    public void addObserver(WeatherObserver observer){
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer){
        observers.remove(observer);
    }
    public void notifyObservers(){
        for (WeatherObserver observer:observers){
            observer.update(temperature);
        }
    }

    public void stop(){
        running=false;
    }
    @Override
    public void run() {
        while (running){
            try {
                int sleepTime=random.nextInt(500)+100;
                Thread.sleep(sleepTime);

                int change=random.nextBoolean()? 1:-1;
                int newTemp=temperature+change;

                if(newTemp>=MIN_TEMP && newTemp<=MAX_TEMP){
                    temperature=newTemp;
                    System.out.println("WeatherStation: Temperature changed to " + temperature);
                    notifyObservers();
                    System.out.println(" ");
                }

            }catch (InterruptedException e){
                System.out.println("WeatherStation interrupted");
                break;
            }
        }

    }
}
