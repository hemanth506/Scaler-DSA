class Solution:
    def diagonal(self, A):
        wholeArr = []
        for i in range(len(A)):
            # print(i, "====================")
            j = 0
            c = i
            arr = []
            while j <= i:
                arr.append(A[j][c])
                # print(i, j, c, "===> ",A[j][c])
                j += 1
                c -= 1
            # print(arr)
            wholeArr.append(arr)


        for i in range(1, len(A)):
            j = i
            c = len(A[0]) - 1
            arr = []
            while c >= 0  and j < len(A):
                arr.append(A[j][c])
                # print(i, j, c, "===> ",A[j][c])
                j += 1
                c -= 1
            # print(arr)
            wholeArr.append(arr)
        # print(wholeArr)

        for i in range(len(wholeArr)):
            remaining = len(A) - len(wholeArr[i])
            if remaining != 0:
                for j in range(remaining):
                    wholeArr[i].append(0)
        return wholeArr



A = [[1, 2, 3, 4], [5, 6, 7, 8],[9, 10,11,12], [13,14,15,16]]
soln = Solution()
print(soln.diagonal(A))


'''
[[1, 0, 0, 0],
 [2, 5, 0, 0],
 [3, 6, 9, 0],
 [4, 7, 10, 13],
 [8, 11, 14, 0],
 [12, 15, 0, 0],
 [16, 0, 0, 0]]


'''