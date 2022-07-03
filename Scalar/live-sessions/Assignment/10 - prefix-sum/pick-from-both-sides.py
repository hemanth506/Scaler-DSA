class Solution:
    def solve(self, A, B):
        """ 
        B = 3 ( should take three balls ) 
        L   |   R
        0   |   B           => 0 from Left and 3 from right # case 1
        1   |   B - 1       => 1 from Left and 2 from right # case 2
        2   |   B - 2       => 2 from left and 1 from right # case 3
        3   |   B - 3       => 3 from left and 0 from right # case 4

        """

        N = len(A)
        prefix = []
        prefix.append(A[0])
        for i in range(1, N):
            prefix.append(prefix[i - 1] + A[i])

        if N == B:
            return prefix[N - 1]

        # case - 1
        maxValue = prefix[N - 1] - prefix[N - 1 - B]

        # case - 2 / 3 / 4
        for L in range(0, B):
            sumValue = prefix[L] + (prefix[N - 1] - prefix[N - B + L])
            if sumValue > maxValue:
                maxValue = sumValue

        return maxValue
        
A = [5, -2, 3 , 1, 2]
B = 3

# A = [1, 2]
# B = 1

A = [ -969, -948, 350, 150, -59, 724, 966, 430, 107, -809, -993, 337, 457, -713, 753, -617, -55, -91, -791, 758, -779, -412, -578, -54, 506, 30, -587, 168, -100, -409, -238, 655, 410, -641, 624, -463, 548, -517, 595, -959, 602, -650, -709, -164, 374, 20, -404, -979, 348, 199, 668, -516, -719, -266, -947, 999, -582, 938, -100, 788, -873, -533, 728, -107, -352, -517, 807, -579, -690, -383, -187, 514, -691, 616, -65, 451, -400, 249, -481, 556, -202, -697, -776, 8, 844, -391, -11, -298, 195, -515, 93, -657, -477, 587 ]
B = 81
soln = Solution()
print(soln.solve(A, B))
