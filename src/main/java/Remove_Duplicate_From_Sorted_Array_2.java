/**
 * Created by rico on 2016/10/10.
 */
public class Remove_Duplicate_From_Sorted_Array_2 {

    public int removeDuplicates(int[] sorted) {

        int length = sorted.length;
        if(length <= 2) return length;

        int index = 2;
        //[0, index)是处理完毕的数组
        for(int i = 2; i < length; i++) {
            if (sorted[i] != sorted[index - 2]) {
                sorted[index] = sorted[i];
                index++;
            }
        }

        return index;
    }
}
