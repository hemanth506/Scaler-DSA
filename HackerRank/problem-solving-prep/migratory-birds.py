
def migratoryBirds(arr):
    # print(arr)
    arr.sort(reverse = True)
    d = {}
    maxCount = 0
    minimumKey = 0
    for i in range(len(arr)):
        if arr[i] in d:
            d[arr[i]] += 1
            if d[arr[i]] >=  maxCount:
                # print(d[arr[i]], maxCount)
                minimumKey = arr[i]
                maxCount = d[arr[i]]
        else:
            d[arr[i]] = 1
    # print(d)

    return minimumKey


arr = [1,4,4,4,5,3]
# arr = list(map(int, eltList.split()))
# arr = list(map(int, "1 2 3 4 5 4 3 2 1 3 4".split()))

print(migratoryBirds(arr))