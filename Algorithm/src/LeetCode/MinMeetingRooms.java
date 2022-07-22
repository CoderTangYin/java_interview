package LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],…] (si < ei)，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 *
 * 示例 1:
 * 输入: [[0, 30],[5, 10],[15, 20]]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [[7,10],[2,4]]
 * 输出: 1
 *
 * 作者：放开那个BUG
 * 链接：https://www.jianshu.com/p/bbece9223198
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MinMeetingRooms {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // 按照会议开始的时间排序
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        //存结束时间由小到大 即为堆顶的时间是需要开会议室的最小时间  始终让堆顶保存最小的时间
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // 把第一个会议室的结束时间加进去
        priorityQueue.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            // 当次开始时间 > 前边结束时间  表面前边的会议结束了可以使用
            if (intervals[i][0] >= priorityQueue.peek()) {
                priorityQueue.remove();
            }
            priorityQueue.add(intervals[i][1]);
        }
        return priorityQueue.size();
    }

}
