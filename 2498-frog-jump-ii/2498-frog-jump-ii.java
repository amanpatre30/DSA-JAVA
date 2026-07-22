class Solution {
    public int maxJump(int[] stones) {
        int maxFrogJump = stones[1] - stones[0];
        for(int i = 2 ; i < stones.length ; i++){
            maxFrogJump = Math.max(maxFrogJump , stones[i] - stones[ i-2]);
        }
        return maxFrogJump;
    }
}