package bridge;

public class SmartTV implements Device{
    private boolean on;
    private int volume;
    private int channel;

    public SmartTV() {
        super();
        this.volume = 30;
        this.channel = 1;
        this.on = false;
    }
    @Override
    public boolean isEnbaled() {
        return on;
    }

    @Override
    public void enable() {
        on= true;
        System.out.println("Smart TV is now ON");
    }

    @Override
    public void disable() {
        on= false;
        System.out.println("Smart TV is now OFF");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume= Math.max(0, Math.min(volume, 100));

    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel= Math.max(0, Math.min(channel, 100));
    }

    public void browseInternet() {
        if(on){
            System.out.println("Browsing the internet on Smart TV");
        }else {
            System.out.println("Please turn on the Smart TV first");
        }

    }
}
