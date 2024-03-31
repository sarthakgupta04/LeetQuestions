import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int n1 = nums1.length;
        final int n2 = nums2.length;
        int[] result = new int[n1 + n2];

        System.arraycopy(nums1, 0, result, 0, n1);
        System.arraycopy(nums2, 0, result, n1, n2);
        Arrays.sort(result);

        return calculateMedian(result);
    }

    private double calculateMedian(int[] arr) {
        int n = arr.length;

        if (n % 2 == 0) {
            int z = n / 2;
            int e = arr[z];
            int q = arr[z - 1];
            return (double) (e + q) / 2;
        } else {
            int z = n / 2;
            return arr[z];
        }
    }
}
