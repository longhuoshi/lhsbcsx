package myjava;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author l
 * @date 2021/12/14 10:44
 * @description
 * 通过debug工具跟踪，计算，修改变量的值
 */


public class DebugVariable {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Aoaaoo{
        private String name;
        private int age;
        private double salary;

    }

    private static boolean isRobotAoaaoo(Aoaaoo aoaaoo){
        return aoaaoo.getName().equals("robot");
    }

    private static Map<String,String> objToMap(Aoaaoo aoaaoo){
        System.out.println("coming in objToMap...");

        Map<String,String> result = new HashMap<>();
        boolean isRobot = isRobotAoaaoo(aoaaoo);
        if (isRobot){
            throw new RuntimeException("aoaaoo is robot");
        }
        if (StringUtils.isEmpty(aoaaoo.getName())){
            aoaaoo.setName("ao-qinyi");
        }
        result.put("name",aoaaoo.getName());
        result.put("age",String.valueOf(aoaaoo.getAge()));
        result.put("salary",String.valueOf(aoaaoo.getSalary()));

        return result;
    }

    public static void main(String[] args) {
        Aoaaoo aoaaoo = new Aoaaoo("qinyi",19,0.1);
        System.out.println(objToMap(aoaaoo));
    }


}
