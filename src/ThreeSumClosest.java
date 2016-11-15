import java.util.Arrays;

/**
 * Created by rico on 2016/11/14.
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        int min_gap = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                int gap = Math.abs(sum - target);
                if(gap < min_gap) {
                    result = sum;
                    min_gap = gap;
                }

                //继续逼进,越逼进，距离就越小
                if(sum == target) return sum;
                else if(sum < target) j++;
                else k--;
            }
        }

        return result;

    }
}
