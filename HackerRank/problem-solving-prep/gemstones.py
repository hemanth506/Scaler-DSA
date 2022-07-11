
def gemstones(arr):
    arr.sort(key = len)
    print(arr)

    compareList = list(set(arr[0]))
    print(compareList)
    gemList = []
    for i in range(len(compareList)):
        gemNotFound = False
        for j in range(1, len(arr)):
            nextList = list(arr[j])
            if compareList[i] not in nextList:
                gemNotFound = True

        if not gemNotFound:
            gemList.append(compareList[i])
    return len(gemList)

arr = ['abcdde', 'baccd', 'eeabg']
arr = ['abc', 'abc', 'ac']
print(gemstones(arr))