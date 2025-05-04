package command;

// PixelArtEditorController.java (Final Fixed Version)
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PixelArtEditorController {
    private static final int SIZE = 8;
    private static final int CELL_SIZE = 30;

    private Rectangle[][] cells = new Rectangle[SIZE][SIZE];
    private boolean[][] pixelState = new boolean[SIZE][SIZE];
    private int cursorRow = 0, cursorCol = 0;

    @FXML private GridPane pixelGrid;
    @FXML private Button generateButton;
    @FXML private Button clearButton;

    @FXML
    public void initialize() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Rectangle rect = new Rectangle(CELL_SIZE, CELL_SIZE);
                rect.setFill(Color.WHITE);
                rect.setStroke(Color.GRAY);
                cells[row][col] = rect;
                pixelGrid.add(rect, col, row);
            }
        }
        updateCursor();

        pixelGrid.setFocusTraversable(true);
        pixelGrid.setOnKeyPressed(this::handleKeyPress);

        generateButton.setOnAction(e -> {
            Command generate = new GenerateCodeCommand(this);
            generate.execute();
        });
        clearButton.setOnAction(e -> {
            clearGrid();
            pixelGrid.requestFocus();
        });
    }
    public void clearGrid() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                pixelState[row][col] = false;
            }
        }
        updateCursor();
    }

    private void handleKeyPress(KeyEvent event) {
        Command command = null;
        if (event.getCode() == KeyCode.UP) {
            command = new MoveCursorUpCommand(this);
        } else if (event.getCode() == KeyCode.DOWN) {
            command = new MoveCursorDownCommand(this);
        } else if (event.getCode() == KeyCode.LEFT) {
            command = new MoveCursorLeftCommand(this);
        } else if (event.getCode() == KeyCode.RIGHT) {
            command = new MoveCursorRightCommand(this);
        } else if (event.getCode() == KeyCode.SPACE) {
            command = new TogglePixelCommand(this);
        }
        if (command != null) {
            command.execute();
            updateCursor();
            event.consume();
        }
    }

    public void moveCursor(int rowDelta, int colDelta) {
        cursorRow = Math.max(0, Math.min(cursorRow + rowDelta, SIZE - 1));
        cursorCol = Math.max(0, Math.min(cursorCol + colDelta, SIZE - 1));
    }

    public void togglePixel() {
        pixelState[cursorRow][cursorCol] = !pixelState[cursorRow][cursorCol];
    }

    public void generateCode() {
        System.out.println("int[][] pixelArt = {");
        for (int row = 0; row < SIZE; row++) {
            System.out.print("    {");
            for (int col = 0; col < SIZE; col++) {
                System.out.print((pixelState[row][col] ? "1" : "0") + (col < SIZE - 1 ? ", " : ""));
            }
            System.out.println("}" + (row < SIZE - 1 ? "," : ""));
        }
        System.out.println("};");

        pixelGrid.requestFocus();
    }

    private void updateCursor() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                boolean isCursor = (row == cursorRow && col == cursorCol);
                boolean isOn = pixelState[row][col];
                cells[row][col].setFill(isOn ? Color.BLACK : Color.WHITE);
                cells[row][col].setStroke(isCursor ? Color.RED : Color.GRAY);
                cells[row][col].setStrokeWidth(isCursor ? 2 : 1);
            }
        }
    }
}
