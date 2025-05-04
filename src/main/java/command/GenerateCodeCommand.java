package command;

public class GenerateCodeCommand implements Command {
    private final PixelArtEditorController controller;

    public GenerateCodeCommand(PixelArtEditorController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.generateCode();
    }
}