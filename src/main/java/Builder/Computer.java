package Builder;

public class Computer {
    private String processor;
    private int ram;
    private String storage;
    private String graphicsCard;
    private String opratingSystem;

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public String getOpratingSystem() {
        return opratingSystem;
    }

    public void setOpratingSystem(String opratingSystem) {
        this.opratingSystem = opratingSystem;
    }

    public void showDetails() {
        System.out.println("Computer Specifications:");
        System.out.println("Processor: " + processor);
        System.out.println("RAM: " + ram + "GB");
        System.out.println("Storage: " + storage);
        System.out.println("Graphics Card: " + graphicsCard);
        System.out.println("Operating System: " + opratingSystem);
    }
}
