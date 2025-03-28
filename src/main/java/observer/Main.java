package observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        Thread stationThread = new Thread(weatherStation);
        ConreteObserver observer1 = new ConreteObserver("Observer 1");
        ConreteObserver observer2 = new ConreteObserver("Observer 2");
        ConreteObserver observer3 = new ConreteObserver("Observer 3");

        weatherStation.addObserver(observer1);
        weatherStation.addObserver(observer2);
        weatherStation.addObserver(observer3);

        stationThread.start();

        try{
            Thread.sleep(1000);
            System.out.println("Removing Observer 2");
            weatherStation.removeObserver(observer2);

            Thread.sleep(1000);
            System.out.println("stopping the station");
            weatherStation.stop();

            stationThread.join();

        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
