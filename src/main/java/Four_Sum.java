import java.util.*;

/**
 * Created by rico on 2016/11/15.
 *
 * 思路同3Sum 将之转化成一个3Sum的问题
 */
public class Four_Sum {

//    public List<List<Integer>> fourSumByHashMap(int[] nums, int target) {
//
//        Arrays.sort(nums);
//        List<List<Integer>> result = new ArrayList<>();
//        Map<Integer, List<Pair>> cache = new HashMap<>();
//
//        for(int i = 0; i < (nums.length - 1); i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                List<Pair> pairList = cache.get(nums[i] + nums[j]);
//                if(pairList == null) {
//                    pairList = new ArrayList<>();
//                }
//
//                pairList.add
//            }
//        }
//        for(int i = 0; i < (nums.length - 1); i++) {
//            for(int j = i + 1; j < nums.length;j++){
//                //确保下一对数与之前的不同
//                boolean initOfDiffI = (i == 0) || (nums[i - 1] != nums[i]); //2 2 .... 5
//                boolean initOfDiffJ = (j == (i + 1)) || (nums[j - 1] != nums[j]); // 2....5 5
//                if(initOfDiffI && initOfDiffJ) {
//                    int remain = target - nums[i] - nums[j];
//                    if(cache.containsKey(remain)) {
//                        Pair remainPair = cache.get(remain);
//                        if(remainPair.notExactlyEqual(new Pair(i, j))){
//
//                        }
//                    }
//                }
//            }
//        }
//
//
//    }
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        int i = 0;
        while(i < (nums.length - 3)) {

            if(i == 0 || (nums[i - 1] != nums[i])) {
                //here, is a sub question threeSum
                int j = i + 1;
                while(j < (nums.length - 2)) {
                    if(j == (i + 1) || (nums[j - 1] != nums[j])) {
                        int k = j + 1;
                        int l = nums.length - 1;
                        while (k < l) {
                            int sum = nums[i] + nums[j] + nums[k] + nums[l];
                            if(sum == target) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                                //利用循环不变式确定下一个指向不同元素的k与l
                                k++;
                                while((k < (nums.length - 1)) && (nums[k] == nums[k - 1])) k++;

                                l--;
                                while((l > k) && (nums[l] == nums[l + 1])) l--;

                            } else if(sum < target) k++;
                            else l--;
                        }
                    }

                    j++;
                }
            }

            i++;
        }

        return result;
    }
}
