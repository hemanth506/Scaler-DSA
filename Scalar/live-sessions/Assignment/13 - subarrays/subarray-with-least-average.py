class Solution:
    def solveNSquare(self, A, B):
        N = len(A)

        # first index total and average
        total = 0
        index = 0
        for k in range(B):
            total += A[k]
        avg = total / B
        leastAvg = avg
        
        for i in range(1, N):
            if i < N - B + 1:
                total = 0
                for j in range(i, i + B):
                    total += A[j]
                avg = total / B
                if avg < leastAvg:
                    leastAvg = avg
                    index = i
                
        return index

    def solveN(self, A, B):
        N = len(A)

        prefix = [0] * N
        prefix[0] = A[0]
        for i in range(N):
            prefix[i] = prefix[i - 1] + A[i]
        # print(prefix)

        # first index total and average
        index = 0
        total = prefix[B - 1]
        leastAvg = total / B

        for i in range(1, N):
            if i < N - B + 1:
                total = prefix[i + B - 1] - prefix[i - 1]
                avg = total / B
                if avg < leastAvg:
                    leastAvg = avg
                    index = i


        return index


A = [[3, 7, 90, 20, 10, 50, 40] , [ 20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11 ], [ 15, 7, 11, 7, 9, 8, 18, 1, 16, 18, 6, 1, 1, 4, 18 ], [ 20, 1, 5, 2, 7, 5, 17 ], [ 3, 16, 11, 13, 19, 17, 11, 4, 9, 9, 6, 7, 3, 6, 12, 3, 4, 15, 5, 19 ]]
B = [3, 9, 6, 6, 1]

soln = Solution()
for l in range(len(A)):
    print(soln.solveNSquare(A[l], B[l]))
    print(soln.solveN(A[l], B[l]))
