package command;

public class TogglePixelCommand implements Command {
    private final PixelArtEditorController controller;

    public TogglePixelCommand(PixelArtEditorController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.togglePixel();
    }
}
