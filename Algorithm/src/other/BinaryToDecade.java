package other;

/**
 * 十进制转成二进制
 */
public class BinaryToDecade {

    public int convert(int val) {
        String result = "";
        while (val != 0) {
            result = result + (val % 2);
            val /= 2;
        }
        System.out.println(result);
        return 0;
    }

    public static void main(String[] args) {
        BinaryToDecade binaryToDecade = new BinaryToDecade();
        binaryToDecade.convert(2);
    }

}
