public class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int bSum = Arrays.stream(B).sum();
        int half = (Arrays.stream(A).sum() + bSum) / 2;
        
        for (int i = 0; i < A.length; i++) {
            int toFind = bSum + A[i] - half;
            for (int j = 0; j < B.length; j++) {
                if (B[j] == toFind) {
                    return new int[] {A[i], B[j]};
                }
            }
        }
        
        return new int[] {0, 0};
    }
}