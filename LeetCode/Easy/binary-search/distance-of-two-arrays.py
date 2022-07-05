class Solution:

    def binarySearchWithClosestInt(self, array, target):
        N = len(array)
        l = 0
        h = N - 1

        while l < h:
            m = l + (h - l) // 2
            if array[m] < target:
                l = m + 1
            elif array[m] > target:
                h = m - 1
            else:
                return set([array[l], array[m], array[h]])
        return set([array[l], array[m], array[h]])


    def findTheDistanceValue(self, arr1, arr2, d):
        arr2.sort()
        print(arr1)
        print(arr2)
        print("================")
        distance = 0
        for i in range(len(arr1)):
            target = arr1[i]
            # print(arr2)
            # print(target)
            returnValue = self.binarySearchWithClosestInt(arr2, target)
            returnValue = list(returnValue)
            
            print("for => ", arr1[i])
            print(returnValue)
            
            for value in range(len(returnValue)):
                if abs(arr1[i] - returnValue[value]) <= d:
                    print(arr1[i], returnValue[value], abs(arr1[i] - returnValue[value])," <= ", d)
                    distance += 1

            print("=========")

        return distance


arr1 = [4,5,8]
arr2 = [10,9,1,8]
d = 2

# arr1 = [1,4,2,3]
# arr2 = [-4,-3,6,10,20,30]
# d = 3

arr1 = [2,1,100,3]
arr2 = [-5,-2,10,-3,7]
d = 6
soln = Solution()
print(soln.findTheDistanceValue(arr1, arr2, d))
        