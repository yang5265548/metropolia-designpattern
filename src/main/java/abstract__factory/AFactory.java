package abstract__factory;

public class AFactory extends UIFactory{
    @Override
    public Button createButton(String text) {
        return super.button=new ButtonA(text);
    }

    @Override
    public TextField createTextField(String text) {
        return super.textField=new TextFieldA(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return super.checkbox=new CheckboxA(text);
    }
}
