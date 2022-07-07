def majorityElement(nums):
    N = len(nums)
    
    dictionary = {}
    for i in range(N):
        if nums[i] in dictionary:
            dictionary[nums[i]] = dictionary[nums[i]] + 1
        else:
            dictionary[nums[i]] = 1
    print(dictionary)

    index = 0
    # initial = False
    for key, value in dictionary.items():
        if value > N//2:
            index = key
    
    return index

nums = [2,2,1,1,1,2,2]
print(majorityElement(nums))