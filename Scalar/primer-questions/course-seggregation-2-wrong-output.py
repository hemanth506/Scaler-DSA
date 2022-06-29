import unittest

class Solution:
    def binary(self, low, high, firstArr, secArr, i):
        while (low <= high):
            mid = low + ((high - low)//2)
            if firstArr[mid] < secArr[i]:
                low = mid + 1
            elif firstArr[mid] > secArr[i]:
                high = mid - 1
            else:
                return mid
        return -1
                
                
                
    def solve(self, A, B):
        if len(A) > 0 and len(B) > 0:
            A.sort()
            B.sort()
            matchElt = []
            checkArr = []
            count = 0
            
            tempArr = [A, B]
            
            for i in range(0, len(tempArr)):
                if len(tempArr[i]) == len(set(tempArr[i])):
                    checkArr.insert(i, 0)
                else:
                    checkArr.insert(i, 1)
                    
                    
            checkArrA = checkArr[0]
            checkArrB = checkArr[1]
            if checkArrA and checkArrB:
                firstArr = A
                secArr = B
            else:
                firstArr = B
                secArr = A
                
            print(firstArr, secArr)
            
            for i in range(0, len(secArr)):
                low = 0
                high = len(firstArr) - 1
                returnValue = self.binary(low, high, firstArr, secArr, i)
                
                if returnValue != -1:
                    matchElt.insert(count, secArr[i])
                    count += 1
                    
            return matchElt
        return 0
            

sol = Solution()
print(sol.solve([17,12,5,3,14,13,3,2], [19,16,8,7,12,19,10,13,8,20,16,15,4,12,3,14,14]))
                
