public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to optimize binary search.
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int x = nums1.length;
        int y = nums2.length;
        int low = 0, high = x;
        
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;
            
            // If partitionX is 0 it means nothing is there on left side. Use -infinity for maxLeftX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            // If partitionX is length of nums1 then there is nothing on right side. Use +infinity for minRightX
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            
            // Similarly for nums2
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];
            
            // Check if we have found the correct partition.
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // If the combined array length is even
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    // If the combined array length is odd
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                // Too far on right side for partitionX. Move left.
                high = partitionX - 1;
            } else {
                // Too far on left side for partitionX. Move right.
                low = partitionX + 1;
            }
        }
        
        throw new IllegalArgumentException("Input arrays are not sorted or of valid sizes.");
    }
    
    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median: " + solution.findMedianSortedArrays(nums1, nums2)); // Expected Output: 2.0
        
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("Median: " + solution.findMedianSortedArrays(nums3, nums4)); // Expected Output: 2.5
    }
}

