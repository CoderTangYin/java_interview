package LeetCode;

import java.util.Arrays;

/**
 *
 *  给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间
 *  [[s1,e1],[s2,e2],...] (si < ei)，请你判断一个人是否能够参加这里面的全部会议。
 *
 * 示例 1:
 * 输入: [[0,30],[5,10],[15,20]]
 * 输出: false
 *
 * 示例 2:
 * 输入: [[7,10],[2,4]]
 * 输出: true
 *
 */
public class CanAttendMeetings {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return false;
        // 给二维数组按照首元素进行从小到大的排序
        Arrays.sort(intervals,(m1, m2) -> m1[0] - m2[0]);
        // 后一个开始时间 < 前一个结束时间
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        }
        return true;
    }

}
