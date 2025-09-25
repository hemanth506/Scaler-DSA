var validPartition = function (nums) {
    const n = nums.length
    const dp = new Map()

    function solve(i) {

        if(i === n) {
            return true
        }
        
        if(!dp.has(i)) {
            let flagged = false
            if(i+1 < n && nums[i] === nums[i+1]) {
                flagged ||= solve(i + 2)
                if (i+2 < n && nums[i] === nums[i+1] && nums[i] === nums[i+2]) {
                    flagged ||= solve(i + 3)
                }
            } else if(i+2 < n && nums[i]+1 === nums[i+1] && nums[i]+2 === nums[i+2]) {
                flagged ||= solve(i + 3)
            }
    
            dp.set(i, flagged)
        }
        return dp.get(i)
        
    }

    const res = solve(0)
    console.log(res)
    return res
};

let nums;

nums = [4, 4, 4, 5, 6];
// nums = [1,1,1,2]
// nums = [348054,7876,34051]
// nums = [993335,993336,993337,993338,993339,993340,993341]
// nums = [
//   783377, 783378, 783379, 783380, 783381, 783382, 783383, 783384, 783385,
//   783386, 783387, 783388, 14925, 14925, 14925, 190887, 190887, 190887, 444668,
//   444668, 444668, 444668, 444669, 444670, 444671, 444672, 444673, 444674,
// ];

validPartition(nums)
