import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rico on 2016/11/7.
 */
public class Two_Sum {


    //利用hashtable来将一个数的检索时间降到O(1)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int supplement = target - nums[i];
            if(map.containsKey(supplement) &&
                    (map.get(supplement) != i)) {
                return new int[] {i + 1, map.get(supplement) + 1};
            }
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        Two_Sum two_sum = new Two_Sum();
        System.out.println(Arrays.toString(two_sum.twoSum(new int[] {3, 2, 4}, 6)));
    }
}
