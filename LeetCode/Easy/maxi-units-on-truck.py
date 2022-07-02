class Solution:
    def maximumUnits(self, boxTypes, truckSize):
        totalUnits = 0
        boxTypes.sort(reverse=True, key = lambda list: list[1])
        # print(boxTypes)
        for i in range(len(boxTypes)):
            noOfBoxes = boxTypes[i][0]
            unitsOfEachBoxes = boxTypes[i][1]
            
            truckSize = truckSize - noOfBoxes
            # print("truckSize =>", truckSize)
            if truckSize >= 0:
                # print(truckSize, totalUnits)
                totalUnits += noOfBoxes * unitsOfEachBoxes
                print(totalUnits)
            else:
                # print(truckSize, totalUnits)
                # print((noOfBoxes + truckSize))
                # print((noOfBoxes + truckSize) * unitsOfEachBoxes)
                totalUnits += (noOfBoxes + truckSize) * unitsOfEachBoxes
                break
                # totalUnits += truckSize * unitsOfEachBoxes
                
        return totalUnits

# boxTypes = [[1,3],[2,2],[3,1]]
boxTypes = [[5,10],[2,5],[4,7],[3,9]]

# truckSize = 4
truckSize = 10
soln = Solution()
print(soln.maximumUnits(boxTypes, truckSize))