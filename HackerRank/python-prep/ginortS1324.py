import re

# string = input()
string = "1qaz2wsx3edc4rfv5tgb6yhn7ujm8ik9ol0pQWERTYUIOPASDFGHJKLZXCVBNM"

stringList = list(string)

upperList = []
lowerList = []
numbericList = []
evenList = []
oddList = []
oddCount = 0
for i in range(0, len(stringList)):
    if re.search("^[A-Z]+$", stringList[i]):
        upperList.append(stringList[i])
    elif re.search("^[a-z]+$", stringList[i]):
        lowerList.append(stringList[i])
    elif re.search("^[0-9]+$", stringList[i]):
        if int(stringList[i]) % 2 == 0:
            # numbericList.append(stringList[i])
            evenList.append(stringList[i])
        else:
            # numbericList.insert(oddCount, stringList[i])
            # oddCount += 1
            oddList.append(stringList[i])

upperList.sort()
# print(upper)
lowerList.sort()
# print(lower)
evenList.sort()
oddList.sort()
print("".join(lowerList)+"".join(upperList)+"".join(oddList)+"".join(evenList))