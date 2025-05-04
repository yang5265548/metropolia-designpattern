package command;

public class MoveCursorRightCommand implements Command {
    private final PixelArtEditorController controller;

    public MoveCursorRightCommand(PixelArtEditorController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.moveCursor(0, 1);
    }
}