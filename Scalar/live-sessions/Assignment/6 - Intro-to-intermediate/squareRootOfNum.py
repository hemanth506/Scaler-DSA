def solve(A):

        # if A != 1:
        #     for i in range(0, A//2):
        #         if i*i <= A:
        #             if i**2 == A:
        #                 return i
        # else:
        #     return 1

        # return -1

        i = 1
        ans = 1
        while i*i <= A:
            ans = i
            i += 1

        if ans >= 1:
            return ans
        else:
            return -1



print(solve(16))