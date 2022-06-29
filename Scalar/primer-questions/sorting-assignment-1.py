class Solution:
    def solve(self, A, B):
        item = []
        for i in range(0, len(B)):
            priceAmount = B[i]
            value = 0
            j = 0
            count = 0
            while value <= priceAmount and j < len(A):
                value = value + A[j]
                j += 1
                if value <= priceAmount:
                    count += 1
            item.insert(i, count)
        return item
        
        
sol = Solution()
print(sol.solve([3, 4, 4, 6], [20, 4, 10, 2]))
