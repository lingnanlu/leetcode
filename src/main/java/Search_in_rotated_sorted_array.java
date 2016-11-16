/**
 * Created by rico on 2016/11/7.
 */
public class Search_in_rotated_sorted_array {

    public int search(int[] nums, int target) {
        int minElementIndex = findMinElementIndex(nums);

        int low, high;
        if(nums[nums.length - 1] >= target) {
            low = minElementIndex;
            high = nums.length - 1;
        } else {
            low = 0;
            high = minElementIndex - 1;
        }

        //tranditional binary search
        while(low <= high) {
            int middle = (low + high) / 2;
            if(nums[middle] == target) return middle;
            else if(nums[middle] > target) high = middle - 1;
            else low = middle + 1;
        }

        return -1;
    }

    public int findMinElementIndex(int[] nums) {
        int low = 0, high = nums.length - 1;

        //我们知道最小元素肯定存在， 所以退出时low， high所指元素就是最小元素
        while(low != high) {
            int middle = (low + high) / 2;
            if(nums[middle] > nums[high]) low = middle + 1;
            else high = middle;
        }

        return low;

    }

    public int search2(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int middle = (low + high) / 2;
            if(nums[middle] == target) return middle;
            if(nums[low] <= nums[middle]) {
                if(nums[low] <= target && target < nums[middle]) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            } else {
                if(nums[high] >= target && target > nums[middle]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }
        }

        return -1;
    }
}
