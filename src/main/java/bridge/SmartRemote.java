package bridge;

public class SmartRemote extends Remote{
    public SmartRemote(Device device) {
        super(device);
    }
    public void voiceCommand(String command){
        if (command.equalsIgnoreCase("volume up")) {
            volumeUp();
        } else if (command.equalsIgnoreCase("volume down")) {
            volumeDown();
        } else if (command.equalsIgnoreCase("channel up")) {
            channelUp();
        } else if (command.equalsIgnoreCase("channel down")) {
            channelDown();
        } else if (command.equalsIgnoreCase("toggle power")) {
            togglePower();
        }else if(command.equalsIgnoreCase("browse internet")){
            browseInternet();
        }else {
            System.out.println("Invalid command");
        }
    }

    public void browseInternet(){
        ((SmartTV)device) .browseInternet();
    }
}
