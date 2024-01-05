package annotation.version2;

import bcsx.typeinfo.interfacea.A;

/**
 * @author l
 * @date 2023/7/17 10:40
 * @description
 * 使用注解
 */

@ClassAnnotation(name = "annotationDemoBean",version = "1.2.1")
public class AnnotationDemo {


    //影响 测试先注释掉
//    @ConstructorAnnotation(constructorName = "AnnotationDemo()")
//    public AnnotationDemo(String description){
//        this.description = description;
//    }

    @FieldAnnotation(name = "description",value = "This my demo annotation!")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @MethodAnnotation(name = "sayHello",type = MethodTypeEnum.TYPE2)
    public void sayHello(){
        System.out.println("Hello Annotation!");
    }
}
