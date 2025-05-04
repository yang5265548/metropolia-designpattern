package command;

public class MoveCursorUpCommand implements Command {
    private final PixelArtEditorController controller;

    public MoveCursorUpCommand(PixelArtEditorController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.moveCursor(-1, 0);
    }
}