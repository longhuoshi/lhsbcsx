package reflect.notebook;

public class KeyByUSB implements USB {

    @Override
    public void open() {
        System.out.println("key close");
    }

    @Override
    public void close() {
        System.out.println("key open");

    }
}
