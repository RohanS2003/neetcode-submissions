class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean hasX = false;
        boolean hasY = false;
        boolean hasZ = false;

        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] ||
                triplet[1] > target[1] ||
                triplet[2] > target[2]) {
                continue;
            }

            if (triplet[0] == target[0]) {
                hasX = true;
            }

            if (triplet[1] == target[1]) {
                hasY = true;
            }

            if (triplet[2] == target[2]) {
                hasZ = true;
            }
        }

        return hasX && hasY && hasZ;
    }
}