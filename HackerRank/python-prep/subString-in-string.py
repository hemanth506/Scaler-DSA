
def count_substring(string, sub_string):
    stringList = list(string)
    sub_stringList = list(sub_string)
    
    totalCount = 0
    for i in range(0, len(stringList)):
        j = i
        tempCount = 0
        index = 0
        if stringList[j] == sub_stringList[index]:
            j += 1
            index += 1
            # print(index, len(sub_stringList))
            while index < len(sub_stringList):
                # print(stringList, j, sub_stringList, index)
                if j < len(stringList):
                    if stringList[j] != sub_stringList[index]:
                        # print("same")
                        break
                    else:
                        # print("differ")
                        tempCount += 1
                        j += 1
                        index += 1
                else:
                    break
            
            # print(stringList[i], tempCount, len(sub_stringList))
            if tempCount == len(sub_stringList)-1:
                totalCount += 1

    return totalCount


if __name__ == '__main__':
    string = input().strip()
    sub_string = input().strip()
    
    count = count_substring(string, sub_string)
    print(count)