package abstract__factory;

public class Main {
    public static void main(String[] args) {
        UIFactory factoryA=new AFactory();
        Button ButtonA=factoryA.createButton("ButtonA");
        Checkbox CheckboxA=factoryA.createCheckbox("CheckboxA");
        TextField TextFieldA=factoryA.createTextField("TextFieldA");
        System.out.println("Factory A");
        ButtonA.display();
        CheckboxA.display();
        TextFieldA.display();

        UIFactory factoryB=new BFactory();
        Button ButtonB=factoryB.createButton("ButtonB");
        Checkbox CheckboxB=factoryB.createCheckbox("CheckboxB");
        TextField TextFieldB=factoryB.createTextField("TextFieldB");
        System.out.println("Factory B");
        ButtonB.display();
        CheckboxB.display();
        TextFieldB.display();

        System.out.println("chage the text of ButtonA to ButtonA1");
        ButtonA.setText("ButtonA1");
        ButtonA.display();


    }
}
