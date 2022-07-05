class Solution:
    def solve(self, A, B):
        N = len(B)

        varArr = []
        for i in range(N):
            first = B[i][0]
            last = B[i][1]

            print("B=======", i)
            initial = False
            
            variable = 0
            for i in range(first - 1, last):
                if initial:
                    print(number, A[i])
                    if number <= A[i]:
                        variable = 1
                        number = A[i]
                    else:
                        variable = 0
                        break
                else:
                    initial = True
                    number = A[i]
                    print(number, A[i])
            
            print("variable => ", variable)
            varArr.append(variable)

        return varArr



A = [ 7, 7, 1, 6, 9 ]
B = [[1, 3],[4, 5], [1, 2], [3, 4], [1, 5]]

A = [ 3, 5, 19, 15, 17, 14, 2, 20, 2, 15 ]
B = [[3, 10], [7, 9], [5, 9], [6, 10], [3, 7], [7, 8], [3, 4], [3, 8], [2, 4], [5, 6]]

# A = [1, 7, 3, 4, 9]
# B = [[1, 2], [2, 4]]
soln = Solution()
print(soln.solve(A, B))