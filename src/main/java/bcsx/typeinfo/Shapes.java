package bcsx.typeinfo;
/**
 * �����������
 * */
import java.util.Arrays;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

abstract class Shape{
	//ע��this�����ĳ������������ַ������ʽ��(�漰"+")��toString()�����ͻᱻ�Զ����� ��
	void draw(){System.out.println(this+".drwa()");}
	
	abstract public String toString();//������ Ϊabstractǿ�Ƽ̳��߸�д�˷�����
}

class Circle extends Shape{
	@Override
	public String toString() {
		return "Circle";
	}
}

class Square extends Shape{
	@Override
	public String toString() {
		return "Square";
	}
}

class Triangle extends Shape{
	@Override
	public String toString() {
		return "Triangle";
	}
}

public class Shapes {

	public static void main(String[] args) {
		
		List<Shape> shapeList = Arrays.asList(new Circle(),new Square(),new Triangle());
		for(Shape shape: shapeList){
			shape.draw();
		}
	}

}
