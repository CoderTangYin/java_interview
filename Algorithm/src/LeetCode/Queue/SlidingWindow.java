package LeetCode.Queue;

import java.util.*;

/**
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return new int[0];
        int[] windowMax = new int[nums.length - k + 1];
        int windowIdx = 0;
        // [头…………尾] 从尾部进去 头部出去
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 表示当前的位置已经超出了K 要把前边的删除掉
            while (!deque.isEmpty() && i - deque.peek() >= k) {
                // 删除队头元素
                deque.poll();
            }
            // 当前元素大于队尾元素 把队尾元素删除  未来保证队头是最大的值把队列中比当前小的全部从尾部移除
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                // 删除队尾元素
                deque.pollLast();
            }
            // 在队列的尾部加入当前索引
            deque.offer(i);
            // 2 >= 2 也就是从数组的第三个元素开始
            if (i >= k - 1) {
                windowMax[windowIdx++] = nums[deque.peek()]; // 获取队头元素
            }
        }
        return windowMax;

    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return new int[0];
        int[] windowMax = new int[nums.length - k + 1];

        // 队列里边加入的索引 从对头到对位是逐渐变小的
        Deque<Integer> integerDeque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // 如果当前的大于队尾的元素 则从队尾开始往前寻找直到找到大于它的为止
            while (!integerDeque.isEmpty() && nums[i] >= nums[integerDeque.getLast()]) {
                integerDeque.pollLast();
            }
            integerDeque.offer(i);
            // 确定滑动窗口的第一个元素的索引
            int w = i - k + 1;
            // 没到数组的第一个元素的情况 即为滑动窗口的数据还没满
            if (w < 0) continue;
            // 滑动窗口的对头索引 < w 即为已经超过K的个数
            if (integerDeque.peekFirst() < w) {
                integerDeque.pollFirst();
            }
            windowMax[w] = nums[integerDeque.peekFirst()];
        }
        return windowMax;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        SlidingWindow obj = new SlidingWindow();
        int[] windowMax = obj.maxSlidingWindow(nums, k);
        System.out.println("Output: " + Arrays.toString(windowMax));
    }
}

/**
 *
 * 1.添加元素
 *         addFirst(E e)在数组前面添加元素
 *         addLast(E e)在数组后面添加元素
 *         offerFirst(E e) 在数组前面添加元素，并返回是否添加成功
 *         offerLast(E e) 在数组后天添加元素，并返回是否添加成功
 *
 *   2.删除元素
 *         removeFirst()删除第一个元素，并返回删除元素的值,如果元素为null，将抛出异常
 *         pollFirst()删除第一个元素，并返回删除元素的值，如果元素为null，将返回null
 *         removeLast()删除最后一个元素，并返回删除元素的值，如果为null，将抛出异常
 *         pollLast()删除最后一个元素，并返回删除元素的值，如果为null，将返回null
 *         removeFirstOccurrence(Object o) 删除第一次出现的指定元素
 *         removeLastOccurrence(Object o) 删除最后一次出现的指定元素
 *
 *
 *    3.获取元素
 *         getFirst() 获取第一个元素,如果没有将抛出异常
 *         getLast() 获取最后一个元素，如果没有将抛出异常
 *
 *
 *     4.队列操作
 *         add(E e) 在队列尾部添加一个元素
 *         offer(E e) 在队列尾部添加一个元素，并返回是否成功
 *         remove() 删除队列中第一个元素，并返回该元素的值，如果元素为null，将抛出异常(其实底层调用的是removeFirst())
 *         poll()  删除队列中第一个元素，并返回该元素的值,如果元素为null，将返回null(其实调用的是pollFirst())
 *         element() 获取第一个元素，如果没有将抛出异常
 *         peek() 获取第一个元素，如果返回null
 *
 *
 *     5.栈操作
 *         push(E e) 栈顶添加一个元素
 *         pop(E e) 移除栈顶元素,如果栈顶没有元素将抛出异常
 *
 *
 *     6.其他
 *         size() 获取队列中元素个数
 *         isEmpty() 判断队列是否为空
 *         iterator() 迭代器，从前向后迭代
 *         descendingIterator() 迭代器，从后向前迭代
 *         contain(Object o) 判断队列中是否存在该元素
 *         toArray() 转成数组
 *         clear() 清空队列
 *         clone() 克隆(复制)一个新的队列
 *
 */