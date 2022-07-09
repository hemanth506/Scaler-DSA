class Solution:
    def maxSubarray(self, A, B, C):
        
        prefix = [0] * A
        prefix[0] = C[0]
        for i in range(1, A):
            prefix[i] = prefix[i - 1] + C[i]
        
        print(prefix)
        

        newArr = []
        for i in range(A):
            print("when i ==================>", i)
            for j in range(i, A):
                if i == 0:
                    value = prefix[j]
                    print("if => ", i, j, value)
                    if value <= B:
                        newArr.append(value)
                else:
                    value = prefix[j] - prefix[i - 1]
                    print("else => ", i, j, value)
                    if value <= B:
                        newArr.append(value)

        print(newArr)

        if len(newArr) == 0:
            return 0
        else:
            return max(newArr)



A = 5
B = 12
C = [2, 1, 3, 4, 5]

# A = 3
# B = 1
# C = [2, 2, 2]

A = 1
B = 75
C = [ 4 ]

# A = 9
# B = 14
# C = [ 1, 2, 4, 4, 5, 5, 5, 7, 5 ]

# A = 9
# B = 78
# C = [ 7, 1, 8, 5, 8, 5, 3, 3, 5 ]

soln = Solution()
print(soln.maxSubarray(A, B, C))