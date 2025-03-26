package abstract__factory;

public abstract class UIFactory {
    public Button button;
    public TextField textField;
    public Checkbox checkbox;
    public abstract Button createButton(String text);
    public abstract TextField createTextField(String text);
    public abstract Checkbox createCheckbox(String text);
}
