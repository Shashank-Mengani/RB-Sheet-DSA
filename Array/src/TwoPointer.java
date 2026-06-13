import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointer {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12,0,4};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        int[] num = {0,1,2,4,3,6};
        int target = 2;
        System.out.println(Arrays.toString(twoSum(num, target)));

        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));

        int[] elements = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(elements));

        int[] nbrs = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nbrs));
    }

    // 283. Move Zeroes
    static void moveZeroes(int[] nums) {

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0){
                swap(nums, right, left);
                left++;
            }
        }
    }

    private static void swap(int[] nums, int right, int left) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }

    // 167. Two Sum II - Input Array Is Sorted
    static int[] twoSum(int[] nums, int target){

        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int sum = nums[left] + nums[right];

            if (sum == target){
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
    }

    // 75. Sort Colors
    static void sortColors(int[] nums) {

        // Sorting 0's
        int left = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                swap(nums, i, left);
                left++;
            }
        }

        // Sorting 2's to last
        int right = nums.length - 1;
        for(int i=nums.length - 1; i>=0; i--){
            if(nums[i] == 2){
                swap(nums, i, right);
                right--;
            }
        }
    }

    // 15. 3Sum
    static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n-2; i++) {
            // skipping repeated values
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right = n - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // skip duplicate elements
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    // 80. Remove Duplicates from Sorted Array II
    static int removeDuplicates(int[] num){

        int i = 2;
        for (int j = 2; j < num.length; j++) {
            if (num[j] != num[i - 2]){
                num[i] = num[j];
                i++;
            }
        }
        return i;
    }
}
