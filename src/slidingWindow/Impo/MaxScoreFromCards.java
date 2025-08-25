package slidingWindow.Impo;
//There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
//In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
//Your score is the sum of the points of the cards you have taken.
//Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
//Example 1:
//Input: cardPoints = [1,2,3,4,5,6,1], k = 3
//Output: 12
//Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
//Example 2:
//Input: cardPoints = [2,2,2], k = 2
//Output: 4
//Explanation: Regardless of which two cards you take, your score will always be 4.
//Example 3:
//Input: cardPoints = [9,7,7,9,7,7,9], k = 7
//Output: 55
//Explanation: You have to take all the cards. Your score is the sum of points of all cards.

import java.util.HashMap;

public class MaxScoreFromCards {
    public static void main(String[] args) {
        int[] cardPoints1 = {1, 2, 3, 4, 5, 6, 1};
        int k1 = 3;
        System.out.println(maxScore(cardPoints1, k1)); // Output: 12

        int[] cardPoints2 = {2, 2, 2};
        int k2 = 2;
        System.out.println(maxScore(cardPoints2, k2)); // Output: 4

        int[] cardPoints3 = {9, 7, 7, 9, 7, 7, 9};
        int k3 = 7;
        System.out.println(maxScore(cardPoints3, k3)); // Output: 55
    }

    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;
        for (int num : cardPoints) {
            totalSum += num;
        }
        if (k == n) return totalSum; // take all cards
        int windowSize = n - k;
        int i = 0, j = 0;
        int currSum = 0;
        int minSum = Integer.MAX_VALUE;

        while (j < n) {
            currSum += cardPoints[j];

            if (j - i + 1 > windowSize) {
                currSum -= cardPoints[i];
                i++;
            }if(j-i+1 == windowSize) {
                minSum = Math.min(minSum, currSum);
            }
            j++;
        }
        return totalSum - minSum;
    }
}

