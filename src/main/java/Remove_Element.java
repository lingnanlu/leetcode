/**
 * Created by rico on 2016/11/15.
 */
public class Remove_Element {
    public int removeElement(int[] nums, int val) {
        //利用两个指针, 一个指向新的数组, 一个指向当前遍历的数组

        int p = 0;      //p指向新数组中下一个空位置
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[p] = nums[i];
                p++;
            }
        }

        return p;
    }
}
