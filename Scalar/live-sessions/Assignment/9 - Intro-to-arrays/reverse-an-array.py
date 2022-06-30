class Solution:
    def solve(self, arrTuple):
        arrLen = len(arrTuple)
        newList = list(arrTuple)
        first = 0
        last = arrLen - 1
        while last > first:
            temp = arrTuple[first]
            newList[first] = arrTuple[last]
            newList[last] = temp
            first += 1
            last -= 1
        
        return newList




# arrTuple = tuple(map(int, input().split()))
arrTuple = (1,2,3,4,5)
soln = Solution()
print(soln.solve(arrTuple))

