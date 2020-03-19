package org.chenguoyu.leetcode.dynamic_programing.optimal_substructure;

import org.junit.Test;

/**
 * 鸡蛋掉落
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * <p>
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * <p>
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * <p>
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * <p>
 * 你的目标是确切地知道 F 的值是多少。
 * <p>
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-egg-drop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution887_1 {
    /**
     * 假设第一次扔到X层，最坏的结果时M(N,K)=MAX{M(X-1,K-1),M(N-X,K)}+1
     * M(X,K-1) 为鸡蛋碎的情况，M(N-X,k)鸡蛋没碎的情况
     * 所以最好的结果的状态转移方程为MIN{MAX{M(1,K-1),M(N-1,K)}+1，MAX{M(2,K-1),M(N-2,K)}+1...MAX{M(X,K-1),M(N-X,K)}+1}
     *
     * @param K 鸡蛋数
     * @param N 层数
     * @return
     */
    Integer[][] memory;

    public int superEggDrop(int K, int N) {
        memory = new Integer[N + 1][K + 1];
        return dp(K, N);
    }

    /**
     * 通过循环查找x的值的话会超时
     *
     * @param K
     * @param N
     * @return
     */
    private int dp(int K, int N) {
        if (K == 1) {
            return N;
        }
        if (N == 1) {
            return 1;
        }
        if (memory[N][K] != null) {
            return memory[N][K];
        }
        int ans = N;
        for (int x = 1; x <= N; x++) {
            ans = Math.min(ans, Math.max(dp(K - 1, x - 1), dp(K, N - x)) + 1);
        }
        return memory[N][K] = ans;
    }

    @Test
    public void main() {
        System.out.println(superEggDrop(2, 6));
    }
}
