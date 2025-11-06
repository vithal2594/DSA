package slidingWindow.MainRewise.fixedwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class stringFixedWindow {
   public static void main(String[] args) {

        String s = "earth";
		int k = 3;
		int[] res = countVowels(s, k);
        System.out.println(Arrays.toString(res));
		String s2 = "aaabbbcacc";
        int k2 = 3;
        System.out.println(distinctSubstring(s2, k2));
        String s3 = "aabbcba";
        int k3 = 3;
        System.out.println(printPalindromeFromStringSizeK(s3, k3));
		String s4 = "aabacbebebe";
        int k4 = 3, x4 = 2;
        System.out.println(countSubstrinofsizeKDistinctX(s4, k4, x4));
		String s5 = "bca";
        int k5 = 2;
        System.out.println("final ans:"+lexicographicallySmallestSubstring(s5, k5));
		String s6 = "aababbc";
        int k6 = 3;
        System.out.println(Arrays.toString(replaceWindowByMostFrequent(s6, k6)));
		String s7 = "abcabc";
        int k7 = 3;
        System.out.println(countUniqueSubstrings(s7, k7));
        String s8 = "abc";
        int k8 = 2;
        int[] res8 = sumOfAsciiSubstrings(s8, k8);
        System.out.println(Arrays.toString(res8));
        String s9 = "aabac";
        int k9 = 3;
        System.out.println(countSubstringsWithRepeats(s9, k9));
        String s10 = "123451";
        int k10 = 3;
        System.out.println(maxSumOfDigitsSubstring(s10, k10));
        String s11 = "abciiidef";
        int k12 = 3;
        System.out.println(maxVowelsInSubstring(s11, k12));
   }

   public static int[] countVowels(String s, int k) {
	    int i = 0;
	    int j = 0;
	    int n = s.length();
	    int[] result = new int[n - k + 1];
	    int idx = 0;
	    int count = 0;
	    while (j < n) {
	        if (isVowel(s.charAt(j))) count++;
	        if (j - i + 1 < k) {
	            j++;
	        } else if (j - i + 1 == k) {
	           result[idx++] = count;
	           if (isVowel(s.charAt(i))) count--;
	           i++;
	           j++;
	        }
	    }
	    return result;
	}
	private static boolean isVowel(char ch) {
        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ||
               ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
	public static String distinctSubstring(String s, int k) {
        int i = 0, j = 0, n = s.length();
        int maxcount = Integer.MIN_VALUE;
        String ans = "";
        Map<Character, Integer> freq = new HashMap<>(); // frequency map
        while (j < n) {
            freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                int count = freq.size(); // number of distinct chars in window
                if (count > maxcount) {
                    maxcount = count;
                    ans = s.substring(i, j + 1);
                }
                // slide window
                freq.put(s.charAt(i), freq.get(s.charAt(i)) - 1);
                if (freq.get(s.charAt(i)) == 0) freq.remove(s.charAt(i));
                i++;
                j++;
            }
        }
        return ans;
    }
	public static String printPalindromeFromStringSizeK(String s, int k) {
	    int i=0;
	    int j=0;
	    int n=s.length();
	    while(j<n){
	        if(j-i+1 < k){
	            j++;
	        }else if(j-i+1 == k){
               String  ans= s.substring(i,j+1);
               if(ispalindrome(ans)){
                   return ans;
               }
               i++;
               j++;
	        }
	    }
	    return "";
    }
	private static boolean ispalindrome(String s){
	    int i=0;
	    int j=s.length()-1;
	    while(i<j){
	        if(s.charAt(i) != s.charAt(j)) return false;
	        i++;
	        j--;
	    }
	    return true;
	}
    public static int countSubstrinofsizeKDistinctX(String s, int k, int x) {
        int i = 0, j = 0, n = s.length();
        int count = 0;
        Map<Character, Integer> mp = new HashMap<>();
        while (j < n) {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                // check distinct characters
                if (mp.size() == x) count++;

                // slide window
                char left = s.charAt(i);
                mp.put(left, mp.get(left) - 1);
                if (mp.get(left) == 0) mp.remove(left);

                i++;
                j++;
            }
        }
        return count;
    }
    public static String lexicographicallySmallestSubstring(String s, int k) {
        int i = 0, j = 0, n = s.length();
        String smallest = s.substring(0, k); // initialize with first substring

        while (j < n) {
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                String window = s.substring(i, j + 1);
                System.out.println("all window:  "+ window);
                // compare lexicographically
                if (window.compareTo(smallest) < 0) {
                    smallest = window;
                }
                // slide window
                i++;
                j++;
            }
        }
        return smallest;
    }
	public static char[] replaceWindowByMostFrequent(String s, int k) {
        int n = s.length();
        int i = 0, j = 0;
        char[] result = new char[n - k + 1];
        int idx = 0;
        Map<Character, Integer> mp = new HashMap<>();

        while (j < n) {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1); // add current char
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                // find most frequent char in current window
                char mostFreq = s.charAt(i); // initialize with first char
                int maxCount = 0;
                for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
                    if (entry.getValue() > maxCount) {
                        maxCount = entry.getValue();
                        mostFreq = entry.getKey();
                    }
                }
                result[idx++] = mostFreq;
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                if (mp.get(s.charAt(i)) == 0) mp.remove(s.charAt(i));
                i++;
                j++;
            }
        }
        return result;
	}
    public static int countUniqueSubstrings(String s, int k) {
        int i = 0, j = 0, n = s.length();
        int count = 0;
        Map<Character, Integer> mp = new HashMap<>();

        while (j < n) {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                // check if all characters are unique
                if (mp.size() == k) count++;
                // slide window
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                if (mp.get(s.charAt(i)) == 0) mp.remove(s.charAt(i));
                i++;
                j++;
            }
        }
        return count;
    }
    public static int[] sumOfAsciiSubstrings(String s, int k) {
        int n = s.length();
        int[] result = new int[n - k + 1];
        int idx = 0;
        int i = 0, j = 0;
        int sum = 0;
        while (j < n) {
            sum += (int) s.charAt(j); // add ASCII of current char
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                result[idx++] = sum;
                // slide window
                sum -= (int) s.charAt(i);
                i++;
                j++;
            }
        }
        return result;
    }
    public static int countSubstringsWithRepeats(String s, int k) {
        int i = 0, j = 0, n = s.length();
        int count = 0;
        Map<Character, Integer> mp = new HashMap<>();

        while (j < n) {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                // check if any character repeats
                boolean hasRepeat = false;
                for (int val : mp.values()) {
                    if (val > 1) {
                        hasRepeat = true;
                        break;
                    }
                }
                if (hasRepeat) count++;
                // slide window
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                if (mp.get(s.charAt(i)) == 0) mp.remove(s.charAt(i));
                i++;
                j++;
            }
        }
        return count;
    }
    public static int maxSumOfDigitsSubstring(String s, int k) {
        int n = s.length();
        int i = 0, j = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        while (j < n) {
            sum += s.charAt(j) - '0'; // add digit at j
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                // update maxSum
                maxSum = Math.max(maxSum, sum);
                // slide window
                sum -= s.charAt(i) - '0';
                i++;
                j++;
            }
        }
        return maxSum;
    }
    public static int maxVowelsInSubstring(String s, int k) {
        int i = 0, j = 0, n = s.length();
        int count = 0;
        int maxVowels = 0;
        while (j < n) {
            char ch = s.charAt(j);
            if (isVowel(ch)) count++;
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                maxVowels = Math.max(maxVowels, count);
                // slide window
                if (isVowel(s.charAt(i))) count--;
                i++;
                j++;
            }
        }
        return maxVowels;
    }


}
