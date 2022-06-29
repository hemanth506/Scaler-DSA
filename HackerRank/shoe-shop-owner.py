# noOfShoes = int(input())
noOfShoes = 10

# shoeSizes = list(map(int, input().split()))
shoeSizes = [2, 3, 4, 5, 6, 8, 7, 6, 5, 18]


shoeSizeDict = {}
shoeExistList = []
for i in range(0, len(shoeSizes)):
    if shoeSizes[i] not in shoeExistList:
        shoeCount = 1
        shoeSizeDict[shoeSizes[i]] = shoeCount
        shoeExistList.append(shoeSizes[i])
    else:
        shoeSizeDict[shoeSizes[i]] += 1
        
print(shoeSizeDict)
print(shoeExistList)

# customers = int(input())
customers = 6
sizeAmountList = [[6, 55], [6, 45], [6, 55], [4, 40], [18, 60], [10, 50]]

totalAmount = 0
for i in range(0, customers):
    # sizeAmount = list(map(int, input().split()))
    sizeAmount = sizeAmountList[i]
    size = sizeAmount[0]
    Amount = sizeAmount[1]

    if size in shoeExistList:
        if shoeSizeDict[size] != 0:
            shoeSizeDict[size] -= 1
            totalAmount += Amount

print(totalAmount)
