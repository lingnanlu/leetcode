import java.util.Arrays;

/**
 * Created by rico on 2016/11/17.
 */
public class Permutation_Sequence {


    // k based 0
    public String getPermutation(int n, int k) {

        int[] factorials = generateFactorials(n);

        //标记某个数是否已经出现过,如果 appeared[i] == true, 那么i在之前已经出现过
        boolean[] appeared = new boolean[n + 1];
        Arrays.fill(appeared, false);


        //依次求得第i位的数字，最低位为第0位
        StringBuilder permutationOfK = new StringBuilder();
        int reminder = k;
        for(int i = n - 1; i >= 1; i--) {
            int countOfSmallerThenRealNumber = reminder / factorials[i];
            int realNumber = getRealNumber(countOfSmallerThenRealNumber, appeared);
            permutationOfK.append(realNumber);
            reminder = reminder % factorials[i];
        }

        //最后一位数字
        permutationOfK.append(getLastPositionNumber(appeared));
        return permutationOfK.toString();
    }

    private int getLastPositionNumber(boolean[] appeared) {

        int i = 1;
        while(appeared[i]) i++;

        return i;
    }

    //最关键的地方
    private int getRealNumber(int countOfSmallerThenRealNumber, boolean[] appeared) {

        int count = 0,i = 1;

        //count 表示 [1, i)中未出现过的数的个数
        //循环的条件是A || B,当循环结束时，为!A && !B
        //在这里就是， count == countOfSmallerThenRealNumber && appeared[i] == false
        while((count != countOfSmallerThenRealNumber) || (appeared[i] == true)) {
            if(appeared[i] == false) {
                count++;
            }
            i++;
        }

        appeared[i] = true;

        return i;
    }

    // result[i] 为 i 的阶乘
    public int[] generateFactorials(int n) {
        int[] factorials = new int[n + 1];
        factorials[1] = 1;
        for(int i = 2; i < factorials.length; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        return factorials;
    }

    public static void main(String[] args) {
        Permutation_Sequence ps = new Permutation_Sequence();

        System.out.println(ps.getPermutation(2, 2));
        System.out.println(Arrays.toString(ps.generateFactorials(9)));
    }

}
