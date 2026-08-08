class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Total sum of all elements
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        long leftSum = 0;

        for (int i = 0; i < n; i++) {
            long current = nums[i];

            // Contribution from elements on the left
            long leftContribution = current * i - leftSum;

            // Contribution from elements on the right
            long rightSum = totalSum - leftSum - current;
            long rightContribution = rightSum - current * (n - i - 1);

            result[i] = (int) (leftContribution + rightContribution);

            leftSum += current;
        }

        return result;
    }
}