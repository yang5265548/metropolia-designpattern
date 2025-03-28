package singleton;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.write("This is a log message.");
        logger.write("This is another log message.");
        logger.write("This is yet another log message.");
        logger.setFileName("new_log.txt");
        logger.write("This is another log message.");
        logger.write("This is yet another log message.");
        logger.write("This is yet another log message.");
        logger.close();
    }
}
