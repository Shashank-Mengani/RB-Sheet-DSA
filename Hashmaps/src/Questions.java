import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Questions {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,1};
        System.out.println(containsDuplicate(arr));

        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        System.out.println(Arrays.toString(intersection(num1, num2)));

        String str1 = "rat";
        String str2 = "car";
        System.out.println(isAnagram(str1, str2));

        String ransomNote  = "aa";
        String magazine = "aabb";
        System.out.println(canConstruct(ransomNote, magazine));

        String s = "loveleetcode";
        System.out.println(firstUniqueChar(s));

        int[] nbrs = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nbrs));

        int[] nums = {2,7,11,15};
        int target = 18;
        System.out.println(Arrays.toString(twoSum(nums, target)));

        int[] number = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(number, k));

        String c1 = "f11";
        String c2 = "b23";
        System.out.println(isIsomorphic(c1, c2));
    }

    static boolean containsDuplicate(int[] nums){

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    static int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }
        for (int j : nums2) {
            if (set.contains(j)) {
                set1.add(j);
            }
        }
        int[] result = new int[]{set1.size()};

        int k = 0;
        for (int arr : set1) {
            result[k] = arr;
            k++;
        }
        return result;
    }

    static boolean isAnagram(String s, String t){
        HashMap<Character, Integer> freq = new HashMap<>();

        for(char ch: s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (char c: t.toCharArray()){
            if(!freq.containsKey(c)){
                return false;
            }
            freq.put(c, freq.get(c) - 1);
            if(freq.get(c) == 0){
                freq.remove(c);
            }
        }
        return freq.isEmpty();
    }

    static boolean canConstruct(String ransomNote, String magazine){

        HashMap<Character, Integer> freq = new HashMap<>();
        for(char ch: magazine.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        for (char c: ransomNote.toCharArray()){
            if (!freq.containsKey(c) || freq.get(c) == 0){
                return false;
            }
            freq.put(c, freq.get(c) - 1);
        }
        return true;
    }

    static int firstUniqueChar(String s){

        HashMap<Character, Integer> freq = new HashMap<>();
        for (char ch: s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    static int majorityElement(int[] nums){

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) > nums.length / 2){
                return num;
            }
        }
        return -1;
    }

    static int[] twoSum(int[] nums, int target){

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int ans = target - nums[i];
            if (freq.containsKey(ans)){
                return new int[] {freq.get(ans), i};
            }
            freq.put(nums[i], i);
        }
        return new int[] {};
    }

    static boolean containsNearbyDuplicate(int[] nums, int k){

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])){
                int prevIndex = freq.get(nums[i]);

                if (i - prevIndex <= k){
                    return true;
                }
            }
            freq.put(nums[i], i);
        }
        return false;
    }

    static boolean isIsomorphic(String s, String t){

        HashMap<Character, Character> freq1 = new HashMap<>();
        HashMap<Character, Character> freq2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (freq1.containsKey(c1)){
                if (freq1.get(c1) != c2) return false;
            } else {
                freq1.put(c1 , c2);
            }

            if(freq2.containsKey(c2)){
                if (freq2.get(c2) != c1) return false;
            } else {
                freq2.put(c2, c1);
            }
        }
        return true;
    }
}
