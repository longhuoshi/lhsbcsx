package reflect.notebook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class NoteBookMain {
    public static void main(String[] args) throws Exception {
        NoteBook book = new NoteBook();
        book.run();

        book.useUSB(null);
        //希望后期出现了设备以后，可不可以不用修改NoteBookMain代码 ，还可以不断的加入新设备
//        book.useUSB(new MouseByUSB());   用反射解决

        File file = new File("usb.properties");
        if (!file.exists()){
            file.createNewFile();
        }

        FileInputStream fis = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fis);
        for (int i = 1; i <= prop.size(); i++) {
            String className = prop.getProperty("usb"+i);
            //对指定的类进行加载
            Class cla = Class.forName(className);
            USB usb = (USB) cla.newInstance();
            book.useUSB(usb);

        }
        fis.close();


    }

}
