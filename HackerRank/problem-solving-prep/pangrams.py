
def pangrams(s):
    s = s.lower()
    newList = {}
    for i in range(1, 27):
        newList[i] = i
    # print(newList)

    # print(ord('w') - 96)
    sList = list(s)
    for i in range(len(sList)):
        if sList[i] != ' ':
            number = ord(sList[i]) - 96
            if number in newList:
                # print(number)
                newList.pop(number)

    # print(len(newList), newList)
    if len(newList) == 0:
        return 'pangram'
    return 'not pangram'



s = 'We promptly judged antique ivory buckles for the next prize'
print(pangrams(s))