/**
 * Created by rico on 2016/10/10.
 */
public class Remove_Duplicate_From_Sorted_Array {

    public static int removeDuplicates(int[] sorted) {
        int length = sorted.length;
        if(length == 0) return 0;

        int index = 1;
        // [0, index)是处理好的子数组
        for(int i = 1; i < length; i++) {
            if (sorted[i] != sorted[index - 1]) {
                sorted[index] = sorted[i];
                index++;
            }
        }

        return index;


    }
    public static void main(String[] args) {

    }
}
