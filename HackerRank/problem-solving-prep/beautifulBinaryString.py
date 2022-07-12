def beautifulBinaryString(b):
    bList = list(b)

    changed = 0 
    for i in range(len(bList)):
        print(bList)
        if bList[i] == '0':
            if i + 2 < len(bList):
                if bList[i + 1] == '1' and bList[i + 2] == '0':
                    bList[i + 2] = '1'
                    changed += 1
                    # print(i)
    return changed

b = '0101010'
# b = '01100'
b = '0100101010'
print(beautifulBinaryString(b))