package reflect.kuangshen;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author l
 * @date 2021/11/23 16:15
 * @description
 * 通过反射操作泛型
 */
public class OperateGenericByReflect {
    public void test01(Map<String,User> map, List<User> list){
        System.out.println("test01");
    }
    public Map<String,User> test02(){
        System.out.println("test02");
        return null;
    }
    public static void main(String[] args) throws NoSuchMethodException {
        //获得参数泛型
        Method method = OperateGenericByReflect.class.getMethod("test01", Map.class, List.class);

        Type[] genericParameterTypes = method.getGenericParameterTypes();//得到参数化泛型
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("# "+genericParameterType);
            if (genericParameterType instanceof ParameterizedType){
                //得到泛型里的真实类型
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }

            }
        }
        System.out.println("==============================");
        //获得返回泛型
        method = OperateGenericByReflect.class.getMethod("test02",null);
        Type genericReturnType = method.getGenericReturnType();
        System.out.println("# "+genericReturnType);
        if (genericReturnType instanceof ParameterizedType){
            //得到泛型里的真实类型
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }


    }
}
