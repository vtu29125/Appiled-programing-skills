import java.util.Stack;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            // Remove prices that cannot be the required discount
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }

            // Top is the first price <= prices[i]
            if (!stack.isEmpty()) {
                answer[i] = prices[i] - stack.peek();
            } else {
                answer[i] = prices[i];
            }

            // Add current price for elements to the left
            stack.push(prices[i]);
        }

        return answer;
    }
}
