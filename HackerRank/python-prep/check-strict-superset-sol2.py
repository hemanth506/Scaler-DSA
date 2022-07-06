# correct solution
# solution using binary search

def binarySearch(listOfA, toFind):
    l = 0
    h = len(listOfA) - 1
    while l <= h:
        mid = l + ((h - l) // 2)
        # print(l, h , mid)
        if listOfA[mid] > toFind:
            h = mid - 1
        elif listOfA[mid] < toFind:
            l = mid + 1
        else:
            return 1
    return 0

def findSuperSet(setA, noOfOtherSets):
    lenOfA = len(setA)

    isSuperSet = []
    for _ in range(0, noOfOtherSets):
        otherSet = set(map(int, input().split()))
        otherSet = list(otherSet)
        otherSet.sort()

        lenOtherSet = len(otherSet)
        
        # print(otherSet)
        if lenOfA > lenOtherSet:
            for i in otherSet:
                # print(i)
                if binarySearch(setA, i) == 1:
                    isSuperSet.append(True)
                else:
                    return False
        else:
            return False
    return True

if __name__ == '__main__':
    A = set(map(int, input().split()))
    A = list(A)
    A.sort()

    # print(A)
    n = int(input())
    
    isSuperSet = findSuperSet(A, n)
    print(isSuperSet)