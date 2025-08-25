package slidingWindow.Impo;

import java.util.HashMap;

public class PickToys {
    public static void main(String[] args) {
        String str1 = "abaccab";   // Expected: 4 ("acca")
        String str2 = "abcbbbbcccbdddadacb"; // Expected: 10 ("bcbbbbcccb")
        String str3 = "aabacbebebe"; // Expected: 7 ("cbebebe")

        System.out.println("Max toys in str1: " + findMaxToysCount(str1));
        System.out.println("Max toys in str2: " + findMaxToysCount(str2));
        System.out.println("Max toys in str3: " + findMaxToysCount(str3));
    }

    public static int findMaxToysCount(String str) {
        int i = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxCount = 0;

        while (j < str.length()) {
//            char ch = str.charAt(j);
            map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);

            if (map.size() < 2) {
                j++;
            } else if (map.size() == 2) {
                maxCount = Math.max(maxCount, j - i + 1);
                j++;
            } else {
                while (map.size() > 2) {
//                    char leftChar = str.charAt(i);
                    map.put(str.charAt(i), map.get(str.charAt(i)) - 1);
                    if (map.get(str.charAt(i)) == 0) {
                        map.remove(str.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }

        return maxCount;
    }
}