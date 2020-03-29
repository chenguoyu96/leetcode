package org.chenguoyu.leetcode.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * 735. 行星碰撞
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 * <p>
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * <p>
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。
 * 如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 */
public class Solution735 {
    /*
    输入:
    asteroids = [5, 10, -5]
    输出: [5, 10]
    解释:
    10 和 -5 碰撞后只剩下 10。 5 和 10 永远不会发生碰撞。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/asteroid-collision
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            while (!stack.isEmpty() && (asteroid < 0 && stack.peek() > 0) && (Math.abs(stack.peek()) < Math.abs(asteroid))) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(asteroid);
                continue;
            }
            if ((stack.peek() < 0 && asteroid < 0)
                    || (stack.peek() > 0 && asteroid > 0)
                    || (asteroid > 0 && stack.peek() < 0)) {
                stack.push(asteroid);
                continue;
            }
            if (!stack.isEmpty() && Math.abs(stack.peek()) > Math.abs(asteroid)) {
                continue;
            }
            if (!stack.isEmpty() && stack.peek() == -asteroid) {
                stack.pop();
            } else {
                stack.push(asteroid);
            }

        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    @Test
    public void main() {
//        int[] nums = new int[]{5, 10, -5};
//        int[] nums = new int[]{8, -8};
//        int[] nums = new int[]{10, 2, -5};
//        int[] nums = new int[]{-2, -1, 1, 2};
        int[] nums = new int[]{-2, -2, 1, -2};
//        int[] nums = new int[]{-2, -1, 1, -2};
        Arrays.stream(asteroidCollision(nums)).forEach(item -> System.out.print(item + " "));
        System.out.println();
    }
}
