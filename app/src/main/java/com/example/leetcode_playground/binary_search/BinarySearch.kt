package com.example.leetcode_playground.binary_search

fun binary_search(nums: List<Int>, target: Int): Int?{
    var low = 0
    var high = nums.size

    while (low < high){
        val mid = (low + high) /2

        if (nums[mid] == target){
            return mid
        }else{
            if (target > mid){
                low = mid+1
            }else{
                high = mid-1
            }
        }
    }

    return null
}
