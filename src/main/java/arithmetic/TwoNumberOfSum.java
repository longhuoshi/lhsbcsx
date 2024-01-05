package arithmetic;

import java.util.HashMap;

/**
 * @author l
 * @date 2023/5/29 10:30
 * @description
 *
 *https://leetcode.cn/problems/two-sum/
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 */
public class TwoNumberOfSum {
    public static void main(String[] args) {
        TwoNumberOfSum t = new TwoNumberOfSum();
        int[] nums = {2,5,8,20,3,30};
        int[] ints = t.twoSum(nums, 5);
        for (int anInt : ints) {
            System.out.println(anInt);
        }


    }

    public int[]  twoSum(int[] nums , int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target-nums[i]),i};
            }
            hashMap.put(nums[i],i);
        }

        return new int[]{};
    }
}
