package memento;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<IMemento> redoHistory; // Redo history
    private List<IMemento> allHistory; // All history

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
        this.allHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");
            IMemento previousState = history.remove(history.size() - 1);
            IMemento currentState = model.createMemento();
            redoHistory.add(currentState); // Save current state to redo history
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo(){
        if (!redoHistory.isEmpty()) {
            System.out.println("Redoing last action");
            IMemento redoState = redoHistory.remove(redoHistory.size() - 1);
            IMemento currentState = model.createMemento();
            history.add(currentState); // Save current state to history
            model.restoreState(redoState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
        redoHistory.clear();
        allHistory.add(currentState);
    }
    public List<IMemento> getHistory() {
        return history;
    }

    public Model getModel() {
        return model;
    }

    public List<IMemento> getAllHistory() {
        return allHistory;
    }
}
