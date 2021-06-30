package bcsx.typeinfo;
/**
 * 在这个例子中
 * */
import java.util.Arrays;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

abstract class Shape{
	//注意this。如果某个对象出现在字符串表达式中(涉及"+")，toString()方法就会被自动调用 。
	void draw(){System.out.println(this+".drwa()");}
	
	abstract public String toString();//被声明 为abstract强制继承者覆写此方法。
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
