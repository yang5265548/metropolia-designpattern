package bridge;

public class Main {
    public static void main(String[] args) {
        Device tv = new Tv();
        Remote remote = new Remote(tv);
        remote.togglePower();
        remote.volumeUp();
        remote.channelUp();
        remote.channelDown();
        remote.volumeDown();
        remote.togglePower();

        System.out.println("=====================================");

        Device radio = new Radio();
        Remote radioRemote = new Remote(radio);
        radioRemote.togglePower();
        radioRemote.volumeUp();
        radioRemote.channelUp();
        radioRemote.channelDown();
        radioRemote.volumeDown();
        radioRemote.togglePower();


        System.out.println("=====================================");

        Device smartTv = new SmartTV();
        SmartRemote smartRemote = new SmartRemote(smartTv);
        smartRemote.voiceCommand("toggle power");
        smartRemote.voiceCommand("volume up");
        smartRemote.voiceCommand("channel up");
        smartRemote.voiceCommand("channel down");
        smartRemote.voiceCommand("volume down");
        smartRemote.voiceCommand("browse internet");
        smartRemote.voiceCommand("toggle power");
        smartRemote.browseInternet();
    }
}
