package bridge;

public class Radio implements Device{
    private int volume;
    private int channel;
    private boolean enabled;

    public Radio() {
        super();
        this.volume = 10;
        this.channel = 1;
        this.enabled = false;
    }

    @Override
    public boolean isEnbaled() {
        return enabled;
    }

    @Override
    public void enable() {
        enabled = true;
        System.out.println("Radio is enabled");
    }

    @Override
    public void disable() {
        enabled = false;
        System.out.println("Radio is disabled");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }
}
