package bridge;

public  class Remote {
    protected  Device device;
    public Remote(Device device) {
        this.device = device;
    }
    public void togglePower(){
        if (device.isEnbaled()) {
            device.disable();
        } else {
            device.enable();
        }
    }
    public void volumeUp(){
        device.setVolume(device.getVolume() + 10);
        System.out.println("Volume up");
        System.out.println("Present Volume: " + device.getVolume());
    }
    public void volumeDown(){
        device.setVolume(device.getVolume() - 10);
        System.out.println("Volume down");
        System.out.println("Present Volume: " + device.getVolume());
    }
    public void channelUp(){
        device.setChannel(device.getChannel() + 1);
        System.out.println("Channel up");
        System.out.println("Present Channel: " + device.getChannel());
    }
    public void channelDown(){
        device.setChannel(device.getChannel() - 1);
        System.out.println("Channel down");
        System.out.println("Present Channel: " + device.getChannel());
    }
}
