package command;

public class MoveCursorDownCommand implements Command{
    private final PixelArtEditorController controller;

    public MoveCursorDownCommand(PixelArtEditorController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.moveCursor(1, 0);
    }
}
