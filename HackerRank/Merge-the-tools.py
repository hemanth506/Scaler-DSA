def merge_the_tools(string, k):
    stringList = list(string)
    
    subStrings = []
    createSubstring = []
    for i in range(0, len(stringList)):
        j = i + 1
        if j % k == 0:
            if stringList[i] not in createSubstring:
                createSubstring.append(stringList[i])
            subStrings.append(createSubstring)
            createSubstring = []
        else:
            print(createSubstring)
            if stringList[i] not in createSubstring:
                createSubstring.append(stringList[i])
    print(subStrings)
    
if __name__ == '__main__':
    string, k = "AABCAAADA", 3
    merge_the_tools(string, k)