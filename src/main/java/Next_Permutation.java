import java.util.Arrays;

/**
 * Created by rico on 2016/11/16.
 *
 * 1. http://blog.csdn.net/qq575787460/article/details/41215475
 * 2. http://blog.csdn.net/qq575787460/article/details/41206601
 */
public class Next_Permutation {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        Next_Permutation s = new Next_Permutation();
        s.nextPermutation(nums);
        System.out.println(nums.toString());
    }
    public void nextPermutation(int[] nums) {

        int p = nums.length - 1;

        //不变式[p, nums.length - 1]为递减数列
        while ((p > 0) && (nums[p - 1] >= nums[p])) p--;

        if (p == 0) {         //说明整个数列为递减数列
            reverse(nums, 0, nums.length - 1);
        } else {
            int pivot = p - 1;
            int firstGreaterElementsIndex = findFirstGreaterElementsFromRight(nums, nums[pivot]);
            swap(nums, pivot, firstGreaterElementsIndex);
            reverse(nums, pivot + 1, nums.length - 1);
        }
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    //找到从右起第一个比val大的元素的坐标
    private int findFirstGreaterElementsFromRight(int[] nums, int val) {
        int p = nums.length - 1;
        while((p >= 0) && (nums[p] <= val)) p--;

        if(p < 0) return -1;
        else return p;
    }
}
