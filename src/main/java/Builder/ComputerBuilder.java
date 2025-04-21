package Builder;

public interface ComputerBuilder {
    void buildProcessor(String processor);

    void buildRam(int ram);

    void buildStorage(String storage);

    void buildGraphicsCard(String graphicsCard);

    void buildOpratingSystem(String opratingSystem);

    Computer getComputer();
}
