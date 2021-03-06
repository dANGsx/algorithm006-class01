package recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>(factorial(length));
        boolean[] used = new boolean[length];

        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, length, 0, used, path, result);
        return result;
    }

    private int factorial(int n) {
        int res = 1;
        for (int i = 2; i < n; i++) {
            res *= i;
        }
        return res;
    }

    private void dfs(int[] nums, int length, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> result) {
        if (depth == length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, length, depth + 1, used, path, result);
                used[i] = false;
                path.removeLast();
            }
        }
    }


    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = new int[]{1, 1, 2};
        System.out.println(permutations.permute(nums));
    }

}
