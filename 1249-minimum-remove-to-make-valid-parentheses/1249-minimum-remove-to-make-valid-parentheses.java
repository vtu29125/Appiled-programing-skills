class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;

        // First pass
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                balance++;
                result.append(ch);
            } 
            else if (ch == ')') {
                if (balance > 0) {
                    balance--;
                    result.append(ch);
                }
            } 
            else {
                result.append(ch);
            }
        }

        // Remove extra '(' from the end
        for (int i = result.length() - 1; i >= 0 && balance > 0; i--) {
            if (result.charAt(i) == '(') {
                result.deleteCharAt(i);
                balance--;
            }
        }

        return result.toString();
    }
}