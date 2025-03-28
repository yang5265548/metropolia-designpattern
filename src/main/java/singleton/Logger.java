package singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger logger;
    private String fileName;
    private BufferedWriter writer;

    private static final String DEFAULT_FILE_NAME = "default_log.txt";

    private Logger() {
        try {
            this.fileName = DEFAULT_FILE_NAME;
            this.writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.out.println("Error initializing logger: " + e.getMessage());
        }
    }
    public static synchronized Logger getInstance(){
        if (logger==null){
            logger = new Logger();
        }
            return logger;
    }

    public void write(String msg){
        try{
            if (writer!=null){
                writer.write(msg);
                writer.newLine();
                writer.flush();
            }

        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }

    public void setFileName(String fileName){
        try {
            if (writer != null) {
                writer.close();
            }
            this.fileName = fileName;
            this.writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.out.println("Error setting log file name: " + e.getMessage());
        }
    }

    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Error closing log file: " + e.getMessage());
        }
    }
}
