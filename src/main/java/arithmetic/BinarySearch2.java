package arithmetic;




/**
 * @author l
 * @date 2021/12/10 10:16
 * @description
 * 二分查找 int溢出问题
 *
 * >>：带符号右移。 正数右移高位补0，负数右移高位补1
 * 例： 4 >> 1，结果是2； -4 >> 1结果是-2
 * >>>：无符号右移。无论是正数还是负数，高位通通补0。
 * 对于正数而言，>>和>>>没区别。
 *
 */
public class BinarySearch2 {
    public static void main(String[] args) {
        int l=0;
        int r = Integer.MAX_VALUE -1;
        int m = (l+r) /2 ;
        System.out.println(m);

        //值在右侧
        l = m+1;
//        m = (l + r) / 2;  //得到负数 -536870913
        //溢出解决方法1
        //优化过程  (l + r) / 2 --> l/2+r/2 --> l-l/2 +r/2
        // --> l+(-l/2 +r/2) --> l + (r-l)/2
        m = l + (r-l)/2 ;
        System.out.println(m);
        //溢出解决方法2
        m = (l + r) >>> 1;
        System.out.println(m);


    }


}
