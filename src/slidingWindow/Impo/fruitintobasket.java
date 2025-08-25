package slidingWindow.Impo;

import java.util.HashMap;

public class fruitintobasket {
    public static void main(String[] args){
        int[] fruits1 = {1, 2, 1};
        System.out.println(maxfruiteintobasket(fruits1));
    }

    public static int maxfruiteintobasket(int[] fruits){
        int i = 0, j = 0;
        int maxFruits = 0;
        int n=fruits.length;
        HashMap<Integer, Integer> mp = new HashMap<>();

        while (j < n) {
            // Add current fruit to the mp map
            mp.put(fruits[j], mp.getOrDefault(fruits[j], 0) + 1);

            // Shrink window if we have more than 2 types of fruits
            while (mp.size() > 2) {
                mp.put(fruits[i], mp.get(fruits[i]) - 1);
                if (mp.get(fruits[i]) == 0) {
                    mp.remove(fruits[i]);
                }
                i++; // shrink from the left
            }
            // Update max
            maxFruits = Math.max(maxFruits, j - i + 1);
            j++; // move right
        }

        return maxFruits;
    }
}
