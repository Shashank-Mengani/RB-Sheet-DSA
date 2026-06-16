import java.util.ArrayList;
import java.util.HashMap;

public class SlidingWindow {
    public static void main(String[] args) {
//        int[] arr = {100, 200, 300, 400};
//        int k = 2;
//        System.out.println(maxSubArraySum(arr, k));
//
//        int[] num = {1,12,-5,-6,50,3};
//        int K = 4;
//        System.out.println(findMaxAverage(num, K));
//
//        String s = "aeiou";
//        int val = 1;
//        System.out.println(maxVowels(s, val));
//
//        int[] leet = {2,3,1,2,4,3};
//        int target = 7;
//        System.out.println(minSub(leet, target));

        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        System.out.println(countDistinct(arr, k));
    }

    static int maxSubArraySum(int[] arr, int k){

        int windowSum = 0;

        //first window
        for (int i=0; i<k; i++){
            windowSum += arr[i];
        }
        int maxSum = windowSum;
        //slide window
        for (int i=k; i < arr.length; i++){
            windowSum += arr[i];
            windowSum -= arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    static double findMaxAverage(int[] arr, int k){
        int windowSum = 0;

        //first window
        for (int i=0; i<k; i++){
            windowSum += arr[i];
        }
        int maxAvg = windowSum;
        //slide window
        for (int i=k; i < arr.length; i++){
            windowSum += arr[i];
            windowSum -= arr[i - k];
            maxAvg = Math.max(maxAvg, windowSum);
        }
        return (double) maxAvg / k;
    }

//    Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
//    Output: [3, 4, 4, 3]
//    Explanation:
//    First window is [1, 2, 1, 3], count of distinct numbers is 3.
//    Second window is [2, 1, 3, 4] count of distinct numbers is 4.
//    Third window is [1, 3, 4, 2] count of distinct numbers is 4.
//    Fourth window is [3, 4, 2, 3] count of distinct numbers is 3.
//    GeekForGeeks
    static ArrayList<Integer> countDistinct(int[] arr, int k){

        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        result.add(freq.size());

        // expand window
        for (int i = k; i < arr.length; i++) {

            // remove element
            int out = arr[i - k];
            freq.put(out, freq.get(out) - 1);
            if (freq.get(out) == 0){
                freq.remove(out);
            }

            //add element
            int in = arr[i];
            freq.put(in, freq.getOrDefault(in, 0) + 1);

            result.add(freq.size());
        }
        return result;

    }

    static int maxVowels(String s, int k){
        int maxCount = 0;

        for (int i = 0; i <= s.length() - k; i++) {
             int count = 0;
            for (int j = i; j < i+k; j++) {
                char ch = s.charAt(j);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                   count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    static int minSub(int[] num, int target){
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < num.length; i++) {
            int sum = 0;
            for (int j = i; j < num.length; j++) {
                sum += num[j];
                if(sum >= target){
                    minLen = Math.min(minLen, j-i+1);
                    break;
                }
                }
            }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
