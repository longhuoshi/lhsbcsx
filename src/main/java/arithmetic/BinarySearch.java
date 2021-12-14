package arithmetic;




/**
 * @author l
 * @date 2021/12/10 10:16
 * @description
 * 二分查找
 * 条件 待查找的列表是有序的
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr ={1,3,7,8,10,15,19,23,27,31,36,40,52,55};
        int index = myBinarySearch(arr,1);
        System.out.println(index);
    }

    //查到i返回被查找数的索引。
    //没有查到返回 -1
    private static int myBinarySearch(int[] arr, int i) {
        int l = 0 , r = arr.length, middleIndex;

        while (l <= r){
            middleIndex = (l + r) / 2;
            if (arr[middleIndex] == i)
                return middleIndex;
            else if(arr[middleIndex] > i)
                r = middleIndex-1;
            else //中间值小于被查找的值
                l = middleIndex+1;


        }
        return -1;
    }


}
