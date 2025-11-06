package slidingWindow.MainRewise.fixedwindow;

import java.util.*;

public class FixedWindow {
    public static void main(String[] args) {
        String s = "abcabcdebb";
        System.out.println(longestSubstringwithoutRepeatingcharacter(s));

        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int kk=3;
        System.out.println(longestconsecutiveones(nums,kk));

        int[] fruits={4,2,5};
        int[] basket={3,5,4};
        System.out.println(fruitsintobasket(fruits,basket));

        int [] arr={2,1,5,1,3,2};
        int k=3;
        System.out.println(maximusumofk(arr,k));
        int [] arr1={12,-1,-7,8,-15,30,16,28};
        int k1=3;
        int[] ans=firstnegativeofk(arr1,k1);
        System.out.println(Arrays.toString(ans));

        int[] arr2={2,1,5,1,3,2};
        int k2=3;
        int[] ans2=countofdinstinctelement(arr2,k2);
        System.out.println(Arrays.toString(ans2));

        int [] arr3={1,3,-1,-3,5,3,6,7};
        int k3=3;
        int[] ans3=maximumofsizek(arr3,k3);
        System.out.println(Arrays.toString(ans3));
        int[] ans4=minimumofsizek(arr3,k3);
        System.out.println(Arrays.toString(ans4));
        int [] arr5={1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k5=5;
        double[] ans5=averageOfSizeK(arr5,k5);
        System.out.println(Arrays.toString(ans5));
        int[] arr6 = {1, 2, 3, 4, 5};
        int k6 = 3;
        int x6 = 6;
        System.out.println(subarraywithsumgraterx(arr6, k6, x6));
        int[] arr7 = {1, 12, -5, -6, 50, 3};
        int k7 = 4;
        System.out.println(subarrayWithMaxAverage(arr7, k7));
        int[] arr8 = {1,2,1,2,3};
        int k8 = 3;
        int x8 = 2;
        System.out.println(countsubarraywithexactlyxdistict(arr8, k8, x8));
        int[] arr9 = {1, 2, 3, 4, 5};
        int k9 = 3;
        int[] ans9= sumOfElementOfEachWindowK(arr9, k9);
        System.out.println(Arrays.toString(ans9));
        int[] arr10={3,-1,2,5,1};
        int k10=2;
        System.out.println(minimumsumsubarrayofk(arr10,k10));
        int[] arr11 = {1, 2, 3, 4, 5};
        int k11 = 3;
        System.out.println(countEvenSumWindows(arr11, k11));
        int[] arr12 = {2, 1, 5, 7, 2, 0, 5};
        int k12 = 3;
        int[] ans12 = medianOfEachWindow(arr12, k12);
        System.out.println(Arrays.toString(ans12));
        int[] arr13 = {2, 3, 5, 1, 6};
        int k13 = 3;
        System.out.println(maxProductOfKConsecutive(arr13, k13));
        int[] arr14 = {1, 2, 3, 4};
        int k14 = 2;
        System.out.println(Arrays.toString(sumOfSquaresInWindow(arr14, k14)));
        int[] arr15 = {1, 3, 6, 2, 8};
        int k15 = 3;
        System.out.println(Arrays.toString(minDiffEachWindow(arr15, k15)));
        int[] arr16 = {1, 2, 3, 2, 4, 5};
        int k16 = 3;
        System.out.println(countIncreasingSubarrays(arr16, k16));
        String s1 = "forxxorfxdofr";
        String p1 = "for";
        System.out.println(countAnagramSubstrings(s1, p1));
        System.out.println(maxDigitSum("25341", 3)); // 12
        System.out.println(maxDigitSum("12345", 2)); // 9
        System.out.println(maxDigitSum("909", 2));   // 9
    }
    public static int longestSubstringwithoutRepeatingcharacter(String s){
        int i=0;
        int j=0;
        int n=s.length();
        Set<Character> st = new HashSet<>();
        int res=0;
        while(j<n){
            char c=s.charAt(j);
            if(!st.contains(c)){
                st.add(c);
                res=Math.max(j-i+1,res);
                j++;
            }else{
                st.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }
    public static int longestconsecutiveones(int[] nums, int k){
        int n=nums.length;
        int i=0;
        int j=0;
        int length;
        int maxlength=0;
        int zeros=0;

        while(j<n){
            if(nums[j] == 0) zeros++;
            while(zeros > k){
                if(nums[i] == 0) zeros--;
                i++;
            }
            length=j-i+1;
            maxlength=Math.max(length,maxlength);
            j++;
        }
        return maxlength;
    }
    public static int fruitsintobasket(int[] fruits, int[] basket){
        int res=0;
        for (int fruit : fruits) {
            for (int j = 0; j < basket.length; j++) {
                if (basket[j] >= fruit) {
                    basket[j] = 0;
                    res++;
                    break;
                }
            }
        }
        return fruits.length-res;
    }
    public static int maximusumofk(int[] arr, int k){
        int n=arr.length;
        int i=0;
        int j=0;
        int sum=0;
        int maxsum=Integer.MIN_VALUE;

        while(j< n){
            sum+=arr[j];
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                maxsum=Math.max(sum,maxsum);
                sum-=arr[i];
                i++;
                j++;
            }
        }
        return maxsum;
    }
    public static int[] firstnegativeofk(int[] arr, int k){
        int n=arr.length;
        int i=0;
        int j=0;
        Queue<Integer> q = new LinkedList<>();
        int[] result= new int[n];
        int idx=0;
        while(j<n){
            if(arr[j] < 0){
                q.add(j);
            }
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                if(!q.isEmpty()){
                    result[idx++]=arr[q.peek()];
                }else{
                    result[idx++]=0;
                }
                if(!q.isEmpty() && q.peek() == i){
                    q.poll();
                }
                i++;
                j++;
            }
        }
        return result;
    }
    public static int[] countofdinstinctelement(int[] arr, int k){
	   int n=arr.length;
	   int i=0;
	   int j=0;
	   Map<Integer,Integer> mp = new HashMap<>();
	   int idx=0;
	   int[] result = new int[n-k+1];

	   while(j < n){
	       mp.put(arr[j],mp.getOrDefault(arr[j],0)+1);
	       if(j-i+1 < k){
	           j++;
	       }else if(j-i+1 == k){
	           result[idx++]= mp.size();
	           int left=arr[i];
	           mp.put(left,mp.get(left)-1);
	           if(mp.get(left) == 0) mp.remove(left);
	           i++;
	           j++;
	       }
	   }
	   return result;
	}
    public static int[] maximumofsizek(int[] arr, int k){
        int n=arr.length;
        int i=0;
        int j=0;
        int currMax=Integer.MIN_VALUE;
        int idx=0;
        int[] result = new int[n-k+1];

        while(j < n){
            currMax=Math.max(currMax,arr[j]);
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                result[idx++]=currMax;
                if(arr[i] == currMax){
                    currMax=Integer.MIN_VALUE;
                    for(int t=i+1; t<=j; t++){
                        currMax=Math.max(currMax,arr[t]);
                    }
                }
                i++;
                j++;
            }
        }
        return result;
    }
    public static int[] minimumofsizek(int[] arr, int k){
        int n=arr.length;
        int i=0;
        int j=0;
        int currMin=Integer.MAX_VALUE;
        int idx=0;
        int[] result = new int[n-k+1];

        while(j < n){
            currMin=Math.min(currMin,arr[j]);
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                result[idx++]=currMin;
                if(arr[i] == currMin){
                    currMin=Integer.MAX_VALUE;
                    for(int t=i+1; t<=j; t++){
                        currMin=Math.min(currMin,arr[t]);
                    }
                }
                i++;
                j++;
            }
        }
        return result;
    }
    public static double[] averageOfSizeK(int[] arr, int k){
        int n=arr.length;
        int i=0;
        int j=0;
        int idx=0;
        double[] result = new double[n-k+1];
        double windowsum=0;

        while(j < n){
            windowsum+=arr[j];
            if(j-i+1 <k){
                j++;
            }else if(j-i+1 == k){
                result[idx++]= windowsum/k;
                windowsum-=arr[i];
                i++;
                j++;
            }
        }
        return result;
    }
    public static int subarraywithsumgraterx(int[] arr, int k,int x){
        int n=arr.length;
        int i=0;
        int j=0;
        int sum=0;
        int count=0;

        while(j<n){
            sum+=arr[j];
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                if(sum > x){
                    count++;
                }
                sum-=arr[i];
                i++;
                j++;

            }
        }
        return count;
    }
    public static double subarrayWithMaxAverage(int[] arr, int k){
        int i=0;
        int j=0;
        int n=arr.length;
        double sum=0;
        double maxi=Double.NEGATIVE_INFINITY;

        while(j<n){
            sum+=arr[j];
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                double avg=sum/k;
                maxi=Math.max(maxi,avg);
                sum-=arr[i];
                i++;
                j++;
            }
        }
        return maxi;
    }
    public static int countsubarraywithexactlyxdistict(int[] arr, int k, int x){
        int i=0;
        int j=0;
        int n=arr.length;
        int count=0;
        HashMap<Integer,Integer> mp = new HashMap<>();

        while(j <n){
            mp.put(arr[j],mp.getOrDefault(arr[j],0)+1);
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                if(mp.size() == x)
                    count++;
                mp.put(arr[i],mp.get(arr[i])-1);
                if(mp.get(arr[i]) == 0) mp.remove(arr[i]);
                i++;
                j++;
            }
        }
        return count;
    }
    public static int[] sumOfElementOfEachWindowK(int[] arr, int k){
        int i=0;
        int j=0;
        int n=arr.length;
        int sum=0;
        int[] result= new int[n-k+1];
        int idx=0;
        while(j<n){
            sum+=arr[j];
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                result[idx++]=sum;
                sum-=arr[i];
                i++;
                j++;
            }
        }
        return result;
    }
    public static int minimumsumsubarrayofk(int[] arr, int k){
        int n=arr.length;
        int i=0;
        int j=0;
        int sum=0;
        int minsum=Integer.MAX_VALUE;
        while(j<n){
            sum+=arr[j];
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                minsum=Math.min(minsum,sum);
                sum-=arr[i];
                i++;
                j++;
            }
        }
        return minsum;
    }
    public static int countEvenSumWindows(int[] arr, int k) {
        int n = arr.length;
        int i = 0, j = 0;
        int sum = 0;
        int count = 0;
        while (j < n) {
            sum += arr[j];  // add current element to sum
            if (j - i + 1 < k) {
                j++;
            }
            else if (j - i + 1 == k) {
                // check if current window sum is even
                if (sum % 2 == 0) {
                    count++;
                }
                // remove outgoing element before sliding
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return count;
    }
    public static int[] medianOfEachWindow(int[] arr, int k) {
        int n = arr.length;
        int i = 0, j = 0, idx = 0;
        int[] result = new int[n - k + 1];
        List<Integer> window = new ArrayList<>();
        while (j < n) {
            window.add(arr[j]); // add element to window
            if (j - i + 1 < k) {
                j++;
            }
            else if (j - i + 1 == k) {
                // sort and find median
                List<Integer> temp = new ArrayList<>(window);
                Collections.sort(temp);
                int mid = k / 2;
                int median = temp.get(mid);
                result[idx++] = median;
                // remove the element going out of the window
                window.remove(Integer.valueOf(arr[i]));
                i++;
                j++;
            }
        }
        return result;
    }
    public static int maxProductOfKConsecutive(int[] arr, int k) {
        int n = arr.length;
        int i = 0, j = 0;
        int maxProduct = Integer.MIN_VALUE;
        while (j < n) {
            if (j - i + 1 < k) {
                j++;
            }
            else if (j - i + 1 == k) {
                // calculate product of current window
                int product = 1;
                for (int t = i; t <= j; t++) {
                    product *= arr[t];
                }
                maxProduct = Math.max(maxProduct, product);
                i++;
                j++;
            }
        }
        return maxProduct;
    }
    public static int[] sumOfSquaresInWindow(int[] arr, int k) {
        int n=arr.length;
        int i=0;
        int j=0;
        int idx=0;
        int sum=0;
        int[] result = new int[n-k+1];
        while(j < n){
            sum+=arr[j]*arr[j];
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                result[idx++]=sum;
                sum-=arr[i]*arr[i];
                i++;
                j++;
            }
        }
        return result;
    }
    public static int[] minDiffEachWindow(int[] arr, int k) {
        int n=arr.length;
        int i=0;
        int j=0;
        int idx=0;
        int[] result = new int[n-k+1];
        while(j < n){
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                int minv=Integer.MAX_VALUE;
                int maxv=Integer.MIN_VALUE;
                for(int t=i; t<=j; t++){
                    minv=Math.min(minv,arr[t]);
                    maxv=Math.max(maxv,arr[t]);
                }
                result[idx++]=maxv-minv;
                i++;
                j++;
            }
        }
        return result;
    }
    public static int countIncreasingSubarrays(int[] arr, int k) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < n) {
            // expand window
            if (j - i + 1 < k) {
                j++;
            }
            else if (j - i + 1 == k) {
                boolean increasing = true;
                // check if current window is strictly increasing
                for (int t = i + 1; t <= j; t++) {
                    if (arr[t] <= arr[t - 1]) {
                        increasing = false;
                        break;
                    }
                }
                if (increasing) count++;
                // slide window
                i++;
                j++;
            }
        }
        return count;
    }
    public static int countAnagramSubstrings(String s, String p) {
        int n=s.length();
        int k=p.length();
        int i=0,j=0;
        int count=0;
        HashMap<Character,Integer> patmap = new HashMap<>();
        HashMap<Character,Integer>windowpat = new HashMap<>();
        for(char ch:p.toCharArray()){
            patmap.put(ch, patmap.getOrDefault(ch,0)+1);
        }
        while(j<n){
            windowpat.put(s.charAt(j),windowpat.getOrDefault(s.charAt(j),0)+1);
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                if(windowpat.equals(patmap)){
                    count++;
                }
                windowpat.put(s.charAt(i),windowpat.get(s.charAt(i))-1);
                if(windowpat.get(s.charAt(i)) == 0) windowpat.remove(s.charAt(i));
                i++;
                j++;
            }
        }
        return count;
    }
    public static int maxDigitSum(String s, int k) {
        int n = s.length();
        if (k > n) return 0;
        int start = 0, end = 0;
        int windowSum = 0, maxSum = 0;
        while (end < n) {
            // Add the new digit to the window
            windowSum += s.charAt(end) - '0';
            // If window exceeds size k, shrink it
            if (end - start + 1 > k) {
                windowSum -= s.charAt(start) - '0';
                start++;
            }
            // If window size == k, update maxSum
            if (end - start + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
            }
            // Move window forward
            end++;
        }
        return maxSum;
    }
}

