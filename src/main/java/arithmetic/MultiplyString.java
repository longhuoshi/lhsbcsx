package arithmetic;

/**
 * @author l
 * @date 2021/10/13 15:16
 * @description
 *
 * Multiply Strings
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 * 关键点1、 "23".charAt(0) 得到的是char类型，要转换成int需要进行-'0'操作。如： "23".charAt(0)-'0' 。
 *          变成int了我们才能进行计算。
 * 关键点2、任何两个数字相乘得到 结果 的位数，都不会超过这两个数的位数之和。
 *  例如 99*99 = 9801   解释:99是二位数，9801是四位数  2+2 = 4
 */
public class MultiplyString {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        String result = multiply(num1,num2);
        System.out.println(result);
        String result2 = multiply2(num1,num2);
        System.out.println(result2);


    }

    public static String multiply(String num1,String num2){
        if (num1 == null || num1.isEmpty() || num1 == null || num1.isEmpty() ) return "";

        int[] temp = new int[num1.length()+num2.length()];
        for (int i = num1.length()-1; i >=0 ; i--) {
            for (int j = num2.length()-1; j >=0 ; j--) {
                temp[i+j+1] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
            }
        }

        //temp: 0,4,13,28,27,18
//     for(int i : temp){
//         System.out.print(i+",");
//     }
        for (int i = temp.length-1; i >0 ; i--) {
            temp[i-1] += temp[i]/10; //依次进位
            temp[i] = temp[i]%10;//取每个元素的个位数
        }

        //temp: 0,5,6,0,8,8

        //delete the leading zero
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            if (sb.length()==0 && temp[i]==0)
                continue;
            sb.append(temp[i]);
        }


        return sb.toString();
    }

    public static String multiply2(String num1,String num2){
        if (num1.equals("0") || num2.equals("0")) return "0";

        int[] res = new int[num1.length()+num2.length()];
        for (int i = num1.length()-1; i >=0; i--) {
            for (int j = num2.length()-1; j >=0; j--) {
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int last = i+j;
                int cur = last + 1;
                int sum = mul + res[cur];

                res[last] += sum/10;
                res[cur] = sum%10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (result.length() == 0 && res[i]== 0)
                continue;
            result.append(res[i]);
        }
        return result.toString();

    }


}
