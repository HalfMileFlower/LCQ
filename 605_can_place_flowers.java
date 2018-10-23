class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int number = 0;
        if (flowerbed.length == 1) {
            number = flowerbed[0] == 0 ? 1 : 0;
            return n <= number;
        }
        
        for (int i = 0; i < flowerbed.length - 1; i++) {
            if (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                number++;
                flowerbed[i] = 1;
                continue;
            }
            if (i > 0 && flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                number++;
                flowerbed[i] = 1;
                continue;
            }
            if (i == flowerbed.length - 2 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                number++;
                flowerbed[i + 1] = 1;
            }
        }
        
        return n <= number;
    }
}

// Notes: conner case - flowerbed.length == 1
// i = 0, i > 0, i = flowerbed.length - 2(if the last position - flower.length - 1 can plant)
// TC: O(n) SC: O(1)
