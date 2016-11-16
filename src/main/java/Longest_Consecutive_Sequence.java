import java.util.HashSet;
import java.util.Set;

/**
 * Created by rico on 2016/11/7.
 */
public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums) {
            set.add(n);
        }

        int longest = 0;
        for(int n : nums) {
            if(set.contains(n)) {
                int length = 1;
                set.remove(n);
                int next = n + 1;
                while(set.contains(next)) {
                    length++;
                    set.remove(next);
                    next++;
                }

                next = n - 1;
                while(set.contains(next)) {
                    length++;
                    set.remove(next);
                    next--;
                }

                if(length > longest) {
                    longest = length;
                }
            }

        }

        return longest;
    }
}
