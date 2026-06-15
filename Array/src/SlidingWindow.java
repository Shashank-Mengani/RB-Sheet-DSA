public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = {100, 200, 300, 400};
        int k = 2;
        System.out.println(maxSubArraySum(arr, k));

        int[] num = {1,12,-5,-6,50,3};
        int K = 4;
        System.out.println(findMaxAverage(num, K));

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
}
