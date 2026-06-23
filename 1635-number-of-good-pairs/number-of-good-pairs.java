class Solution {
    public int numIdenticalPairs(int[] nums) {
        int goodPairs = 0;
        int[] counts = new int[101];
        for (int num : nums) {
            goodPairs += counts[num];
            counts[num]++;
        }
        return goodPairs;
    }
}