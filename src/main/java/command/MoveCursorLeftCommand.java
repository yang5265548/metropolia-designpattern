package command;

public class MoveCursorLeftCommand implements Command {
    private final PixelArtEditorController controller;

    public MoveCursorLeftCommand(PixelArtEditorController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.moveCursor(0, -1);
    }
}
