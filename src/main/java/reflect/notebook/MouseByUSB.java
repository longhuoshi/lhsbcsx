package reflect.notebook;

public class MouseByUSB implements USB {

    @Override
    public void open() {
        System.out.println("mouse 插入");
    }

    @Override
    public void close() {
        System.out.println("mouse 拨出");
    }
}
