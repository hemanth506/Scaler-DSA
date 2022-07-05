#  not clear with the question

# noOfTestCases = int(input())
noOfTestCases = 4

limits = [5, 5, 6, 3]
initialLists = [[1,2,3,8,7], [1,2,3,7,8], [4, 3, 2, 1, 3, 4], [1, 3, 2]]
# initialLists = [4, 3, 2, 1, 3, 4]

for i in range(0, noOfTestCases):
    # limit = int(input())
    limit = limits[i]
    print("From index =>", str(i))
    # initialList = list(map(int, input().split()))
    initialList = initialLists[i]
    
    k = 0
    l = len(initialList)
    status = "No"
    leftElt = []
    rightElt = []
    for m in range(0, len(initialList)):
        if m % 2 != 0:
            p = l - m
            rightElt.append(initialList[p])
            if m >= 3:
                print(leftElt)
                print(rightElt)
                print(str(leftElt[0]) + ">" + str(leftElt[1]) + " and "+ str(rightElt[0]) + ">" + str(rightElt[1]))
                if leftElt[-2] == leftElt[-1] and rightElt[-2] == rightElt[-1]:
                    continue
                elif leftElt[-2] > leftElt[-1] or rightElt[-2] > rightElt[-1]:
                    status = "Yes"
                    break
            l += 1
        else:
            # print(leftElt)
            # print(rightElt)
            leftElt.append(initialList[k])
            k += 1

    print(status)
    