import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rico on 2016/11/14.
 *
 * 本题的难点在于消除重复结果
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int i = 0;
        while(i < (nums.length - 2)) {
            if(nums[i] > 0) break;

            //注意这个if用的很好
            if(i == 0 || nums[i] > nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;
                int remain = 0 - nums[i];
                while(j < k) {
                    int sum = nums[j] + nums[k];
                    if(sum == remain) {
                        results.add(Arrays.asList(nums[i], nums[j], nums[k]));

                        //将j移动到下一个不同的数上
                        int p = j + 1;
                        while(p < nums.length && (nums[p] == nums[j])) p++;
                        j = p;

                        p = k - 1;
                        while(p > i && (nums[p] == nums[k])) p--;
                        k = p;

                    }
                    else if(sum > remain) k--;
                    else j++;
                }

            }
            i++;
        }

        return results;

    }
}
