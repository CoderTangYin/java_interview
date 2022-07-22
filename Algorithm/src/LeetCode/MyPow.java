package LeetCode;

public class MyPow {

    // 递归
    public double myPow(double x, int n) {
        // 任何数的0次幂都是1
        if (n == 0) return 1;
        // 任何数的-1次幂都是它的分之一
        if (n == -1) return 1 / x;
        // 判断是奇数
        boolean odd = (n & 1) == 1;
        // 使用递归份治 一半
        double half = myPow(x,n>>1);
        half *= half;
        return odd ? (half * x) : half;
    }

    
}
