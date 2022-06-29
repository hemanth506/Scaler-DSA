class Solution:
    # @param A : list of integers
    # @return an integer
    def solve(self, A):
        maxArr = []
        for i in range(len(A)):
            for j in range(len(A)):
                if (A[i] or A[j]) == 0:
                    print("test1=>",A[i], A[j], 0)
                    maxArr.append(0)
                else:
                    elt = A[i] % A[j]
                    maxArr.append(elt)
                    print("test2=>",A[i], A[j], elt)
        
        return max(maxArr)


inputLen = input()
inputArr = []
for i in range(0, inputLen):
    j = i + 1
    inputElt = int(input("Enter the array integer: "))
    inputArr.append(inputElt)
    
sol = Solution()
sol.solve(inputArr)