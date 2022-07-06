class Solution:
    def sumOddLengthSubarrays(self, arr):
        
        N = len(arr)
        prefix = [0] * N
        prefix[0] = arr[0]
        for i in range(1, N):
            prefix[i] = prefix[i - 1] + arr[i]

        # print("prefix => ", prefix)
        total = prefix[N - 1]

        if N > 1:
            i = 0
            iterate = 2
            iteration = i + iterate
            while iteration < N:
                # print(i, iteration)
                if i != 0:
                    print("iterate and N => ", iterate, iteration, N)
                    if iteration == N:
                        iterate += 2
                        i = 0
                        iteration = iterate + i
                        print("iteration")
                    else:
                        print("total => ",prefix[iteration] - prefix[i - 1], iterate, iteration, N)
                        total += prefix[iteration] - prefix[i - 1]
                else:
                    print(iteration, iterate, N)
                    total += prefix[iteration]
                    print("when i is 0 => ",prefix[iteration],  iterate)
                
                i += 1
                iteration = i + iterate
                print("last stmt => ", iteration, i, iterate, total)
                if iteration == N and N % 2 != 1:
                    print("executed")
                    i = 0
                    iterate += 2
                    iteration = i + iterate

            # last iterated value
            # if N % 2 != 0 and N != 3:
            #     total += prefix[N - 1]
        
        return total

        


arr = [1,4,2,5,3]
# arr = [1, 2]
# arr = [10, 11, 12]
# arr = [1]
# arr = [7,6,8,6]
# arr = [6,9,14,5,3,8,7,12,13,1]
arr = [1,2,8,5,10,8,10]
soln = Solution()
print(soln.sumOddLengthSubarrays(arr))



        