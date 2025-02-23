# Median-of-Two-Sorted-Arrays
Given two sorted arrays nums1 and nums2 of sizes m and n respectively, return the median of the two sorted arrays. The overall run time complexity should be  𝑂 ( log ⁡ ( 𝑚 + 𝑛 ) ) O(log(m+n)).
Explanation:
Binary Search on the Smaller Array:
We perform binary search on the smaller array (nums1) to ensure that the partitioning is efficient. We determine a partition partitionX in nums1 and calculate partitionY in nums2 such that the total number of elements on the left equals the total on the right (or is off by one for odd total lengths).

Partitioning and Checking:
We define maxLeftX and minRightX for nums1, and maxLeftY and minRightY for nums2.

If the largest element on the left side of both partitions is less than or equal to the smallest element on the right side, we have found the correct partition.
Depending on whether the total number of elements is even or odd, the median is computed accordingly.
Time Complexity:
The algorithm runs in 
𝑂(log(min(𝑚,𝑛)))
O(log(min(m,n))), where 
𝑚 and n are the lengths of the two arrays.
