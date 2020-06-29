"use strict";

function minimumInRotatedSortedArray(nums){
    if(!nums || nums.length == 0) return Number.MAX_VALUE
    let left = 0
    let right = nums.length - 1

    while(left < right){
        let mid = left + Math.floor((right - left)/2)

        if(mid > 0 && nums[mid] < nums[mid-1]){
            return nums[mid]
        }else if(nums[left] <= nums[mid] && nums[mid] > nums[right]){
            left = mid + 1
        }else{
            right = mid - 1
        }   
    }
    return nums[left]
}

let data = [4,5,6,1,2,3]
const result = minimumInRotatedSortedArray(data)
console.log(result)