class Solution:
    def isPerfectSquare(self, num):

        i = 0
        while i*i <= num:
            if i*i == num:
                print(i*i, num)
                status = True
            else:
                status = False
            i += 1
        return status
        
soln = Solution()
print(soln.isPerfectSquare(16))