package memento;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private String creationTime;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.creationTime = formatter.format(new Date());
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public String getInfo() {
        return options[0]+" "+options[1]+" "+options[2]+" "+creationTime;
    }
}
