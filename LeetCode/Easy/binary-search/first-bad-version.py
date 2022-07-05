'''
This is 

good, good, good, good, good, bad, bad, bad, bad

'''
def isBadVersion(version):
    response = [False, False, False, False, True, True, True, True, True, True]

    return response[version]

class Solution:
    def firstBadVersion(self, n):
        low = 0
        high = n
        
        while low < high:
            mid = low + ((high - low) // 2)
            print("mid => ", low, mid, high)
            if isBadVersion(mid):
                print("is bad version")
                high = mid - 1
            else:
                print("is good version")
                low = mid + 1
        
        return low

soln = Solution()
print(soln.firstBadVersion(10))
        