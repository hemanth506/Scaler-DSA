# String = list(str(input()))
String = list("1222311")
String.insert(0, " ")
String.append(" ")
print(String)
    

count = 1
strLen = len(String)
strDic = {}
itr = 0
newDict = {}
for i in range(0, strLen):
    j = i + 1
    if i != 0 and i != strLen - 1:
        if String[i] == String[j]:
            count += 1
        else:
            newDict[String[i]] = count
            strDic[itr] = newDict
            count = 1
            newDict = {}
            itr += 1
print(strDic)

completeString = ""
for i in strDic:
    itrString = ""
    for key, value in strDic[i].items():
        itrString += "(" + str(value) + ", " + str(key) + ") "
    completeString += itrString

print(completeString)
