def binarySearch(emotions):
    toFind = 2
    l = 0
    h = len(emotions) - 1
    while l <= h:
        mid = l + ((h - l) // 2)
        # mid = (h + l) // 2 
        if emotions[mid] < toFind:
            l = mid + 1
        elif emotions[mid] > toFind:
            h = mid - 1
        else:
            return 1
    return 0

newList = [2,5,6,74,25,32,23,45]
newList.sort()

print("Present" if binarySearch(newList) == 1 else "Not present")