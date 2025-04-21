package Builder;

public class ComputerDirector {
    private ComputerBuilder computerBuilder;

    public ComputerDirector(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public void constructComputer(String processor, int ram, String storage, String graphicsCard, String opratingSystem) {
        computerBuilder.buildProcessor(processor);
        computerBuilder.buildRam(ram);
        computerBuilder.buildStorage(storage);
        computerBuilder.buildGraphicsCard(graphicsCard);
        computerBuilder.buildOpratingSystem(opratingSystem);
    }

    public Computer getComputer() {
        return computerBuilder.getComputer();
    }
}
