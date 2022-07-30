package LeetCode;

import java.util.Arrays;

/**
 * 选择找最少的硬币个数
 */
public class CoinChange {

    public void coinChange() {
        int[] faces = {25, 5, 10, 1};
        // 钱面额由大到小排序
        Arrays.sort(faces);
        int money = 41, coins = 0, i = 0;
        while (i < faces.length) {
            // 钱小于要选的面额 不符合情况
            if (money < faces[i]) {
                i++;
                continue;
            }
            // 这里使用i的好处是 本次选完了 下次的如果符合还可以接着选
            money -= faces[i];
            coins++;
            System.out.println(faces[i]);
        }
    }

}
