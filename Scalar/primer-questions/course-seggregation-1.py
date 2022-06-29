class Solution:
    def solve(self, A):
        even = []
        odd = []
        if len(A) > 0:
            for i in range(0, len(A)):
                if A[i] % 2 == 0:
                    even.insert(i, A[i])
                else:
                    odd.insert(i, A[i])
                    
            maxEven = max(even)
            minOdd = min(odd)
            print(maxEven - minOdd)
                
        
sol = Solution()
print(sol.solve([5, 17,100,1]))