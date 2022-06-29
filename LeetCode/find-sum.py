def twoSum(nums, target):
    possibleSolns = []
    for i in range(0, len(nums)):
        newTarget = target - nums[i]
        isBreak = False
        for j in range(i + 1, len(nums)):
            if newTarget == nums[j]:
                possibleSolns.append(i)
                possibleSolns.append(j)
                isBreak = True
                break 
        if isBreak:
            break
        
    return possibleSolns

print(twoSum([3,2,4], 6))