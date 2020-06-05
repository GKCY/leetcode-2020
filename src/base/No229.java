package base;

import java.util.ArrayList;
import java.util.List;

public class No229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int candidate1 = 0, candidate2 = 1, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }  else if (count1 != 0 && count2 != 0) {
                count1--;
                count2--;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1)
                count1++;
            if (num == candidate2)
                count2++;
        }

        if (count1 > nums.length / 3)
            res.add(candidate1);
        if (count2 > nums.length / 3)
            res.add(candidate2);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new No229().majorityElement(nums));
    }
}