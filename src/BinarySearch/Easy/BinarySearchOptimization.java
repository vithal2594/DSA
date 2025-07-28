package BinarySearch.Easy;

public class BinarySearchOptimization {
    // 1. Minimum Number in Array After K Increments (Max element can be reduced)
    public static int minimizeMaxAfterKIncrements(int[] nums, int k) {
        int left = 0, right = (int) 1e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
            long needed = 0;
            for (int num : nums) {
                if (num > mid) needed += num - mid;
            }
            if (needed <= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    // 2. Minimum Speed to Arrive on Time (Leetcode 1870)
    public static int minSpeedOnTime(int[] dist, double hour) {
        int left = 1, right = (int) 1e7;
        int answer = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            double time = 0;
            for (int i = 0; i < dist.length - 1; i++) {
                time += Math.ceil((double) dist[i] / mid);
            }
            time += (double) dist[dist.length - 1] / mid;
            if (time <= hour) {
                answer = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return answer;
    }

    // 3. Koko Eating Bananas (Leetcode 875)
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = (int) 1e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hours = 0;
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }
            if (hours <= h) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    // 4. Capacity to Ship Packages Within D Days (Leetcode 1011)
    public static int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = (left + right) / 2;
            int d = 1, load = 0;
            for (int w : weights) {
                if (load + w > mid) {
                    d++;
                    load = 0;
                }
                load += w;
            }
            if (d <= days) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    // 5. Minimum Days to Make Bouquets (Leetcode 1482)
    public static int minDays(int[] bloomDay, int m, int k) {
        int left = 1, right = (int) 1e9;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                answer = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return answer;
    }

    private static boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0, flowers = 0;
        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else flowers = 0;
        }
        return bouquets >= m;
    }

    // 6. Find Smallest Divisor Given a Threshold
    public static int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = (int) 1e6;
        while (left < right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int num : nums) {
                sum += (num + mid - 1) / mid;
            }
            if (sum <= threshold) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    // 7. Allocate Minimum Number of Pages
    public static int allocatePages(int[] books, int students) {
        int left = 0, right = 0;
        for (int book : books) {
            left = Math.max(left, book);
            right += book;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (isFeasible(books, students, mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private static boolean isFeasible(int[] books, int students, int maxPages) {
        int count = 1, total = 0;
        for (int book : books) {
            if (total + book > maxPages) {
                count++;
                total = 0;
            }
            total += book;
        }
        return count <= students;
    }

    // 8. Painter's Partition Problem (similar to Allocate Pages)
    public static int paintersPartition(int[] boards, int painters) {
        return allocatePages(boards, painters);
    }

    // 9. Aggressive Cows (SPOJ)
    public static int aggressiveCows(int[] stalls, int cows) {
        java.util.Arrays.sort(stalls);
        int left = 1, right = stalls[stalls.length - 1] - stalls[0], result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canPlaceCows(stalls, cows, mid)) {
                result = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return result;
    }

    private static boolean canPlaceCows(int[] stalls, int cows, int dist) {
        int count = 1, last = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= dist) {
                count++;
                last = stalls[i];
            }
        }
        return count >= cows;
    }

    // 10. EKO - Wood Cutting Problem (SPOJ)
    public static int woodCut(int[] trees, int required) {
        int left = 0, right = (int) 1e9, result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            long wood = 0;
            for (int tree : trees) {
                if (tree > mid) wood += tree - mid;
            }
            if (wood >= required) {
                result = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return result;
    }

    // === Main Function ===
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        System.out.println("Koko Min Speed: " + minEatingSpeed(piles, 8));

        int[] dist = {1, 3, 2};
        System.out.println("Min Speed to Arrive: " + minSpeedOnTime(dist, 2.7));

        int[] weights = {1, 2, 3, 1, 1};
        System.out.println("Ship Within Days: " + shipWithinDays(weights, 4));

        int[] bloom = {1, 10, 3, 10, 2};
        System.out.println("Min Days for Bouquets: " + minDays(bloom, 3, 1));

        int[] nums = {1, 2, 5, 9};
        System.out.println("Smallest Divisor: " + smallestDivisor(nums, 6));

        int[] books = {12, 34, 67, 90};
        System.out.println("Allocate Pages: " + allocatePages(books, 2));

        int[] boards = {10, 20, 30, 40};
        System.out.println("Painter Partition: " + paintersPartition(boards, 2));

        int[] stalls = {1, 2, 4, 8, 9};
        System.out.println("Aggressive Cows: " + aggressiveCows(stalls, 3));

        int[] trees = {20, 15, 10, 17};
        System.out.println("EKO Wood Cutting: " + woodCut(trees, 7));
    }
}
