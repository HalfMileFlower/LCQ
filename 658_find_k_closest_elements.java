// Binary + Two pointer
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = findLowerClosest(arr, x);
        List<Integer> res = new ArrayList<>();
        res.add(arr[start]);
        int left = start - 1;
        int right = start + 1;
        while (res.size() < k) {
            if (isLeftCloser(arr, x, left, right)) {
                res.add(0, arr[left]);
                left--;
            } else {
                res.add(arr[right]);
                right++;
            }
        }
        return res;
    }
    
    private boolean isLeftCloser(int[] arr, int x, int left, int right) {
        if (left < 0) {
            return false;
        }
        
        if (right > arr.length - 1) {
            return true;
        }
        
        if (x - arr[left] > arr[right] - x) {
            return false;
        }
        return true;
    }
    
    private int findLowerClosest(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        if (x > arr[right]) {
            return right;
        }
        while(left + 1 < right) {
            int mid = (right - left) / 2 + left ;
            if (arr[mid] < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}