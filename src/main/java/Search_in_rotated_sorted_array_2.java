/**
 * Created by rico on 2016/11/7.
 */
public class Search_in_rotated_sorted_array_2 {


    public boolean search(int[] nums, int target) {

        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int middle = (low + high) / 2;
            if(nums[middle] == target) return true;
            if(nums[low] < nums[middle]) {      //[low, middle]是递增数列
                if(nums[low] <= target && target < nums[middle]) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            } else if(nums[low] > nums[middle]) {  //[middle, high]是递增数列
                if(nums[middle] < target && target <= nums[high]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            } else {
                //nums[low] == nums[middle], 此时，排除一个即可
                low++;
            }
        }

        return false;
    }
}

