package bridge;

public class Tv implements Device{
    private boolean on ;
    private int volume ;
    private int channel ;

    public Tv() {
        super();
        this.volume = 20;
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
        System.out.println("TV is now ON");
    }

    @Override
    public void disable() {
        on= false;
        System.out.println("TV is now OFF");
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
}
