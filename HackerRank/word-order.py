# Time limit exceeded for TS-1, TS-2, TS-3



# n = int(input())
n = 4
strings = ['bcdef', 'abcdefg', 'bcde', 'bcdef']

uniqueStrings = []
orderStrings = {}
strOrderStrings = {}
oldList = []
intDict = {}
count = 0
newList = []
for i in range(0, n):
    # newString = str(input())
    newString = strings[i]
    if newString not in uniqueStrings:
        uniqueStrings.append(newString)
        
        orderStrings[newString] = 1
        strOrderStrings[newString] = "1"

        intDict[newString] = count
        oldList.append(count)
        newList.append("1")
        count += 1
        # print("if => " , newList, " ==== ", strOrderStrings)
    else:
        orderStrings[newString] += 1
        strOrderStrings[newString] = str(orderStrings[newString])

        index = intDict[newString]
        # print(index)
        newIndex = oldList[index]
        # print(newIndex)
        newList.pop(newIndex)
        newList.insert(newIndex, str(orderStrings[newString]))
        # print("else => " , newList, " ==== ", strOrderStrings)
    
    
print(len(uniqueStrings))

print(" ".join(newList))
        

    
