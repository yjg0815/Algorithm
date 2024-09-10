import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];
        
        // Count occurrences of each digit in X
        for (char ch : X.toCharArray()) {
            countX[ch - '0']++;
        }
        
        // Count occurrences of each digit in Y
        for (char ch : Y.toCharArray()) {
            countY[ch - '0']++;
        }
        
        StringBuilder res = new StringBuilder();
        
        // Build the result string by comparing counts
        for (int i = 9; i >= 0; i--) {
            int minCount = Math.min(countX[i], countY[i]);
            if (minCount > 0) {
                while (minCount-- > 0) {
                    res.append(i);
                }
            }
        }
        
        // Handle the case where the result is empty
        if (res.length() == 0) {
            return "-1";
        }
        
        // Handle the case where the result is all zeros
        if (res.charAt(0) == '0') {
            return "0";
        }
        
        return res.toString();
        
    }
}