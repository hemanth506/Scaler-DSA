

def cutTheSticks(arr):    

    dictionary = {}
    for i in range(len(arr)):
        dictionary[i] = arr[i]

    # print(dictionary)
    N = len(dictionary)
    # print(N)

    minimumValue = 0
    minValue = 0
    sticksCut = []
    while len(dictionary) > 0:
        minValue = min(dictionary, key= lambda x: dictionary[x])
        minimumValue = dictionary[minValue]
        # print(dictionary[minValue])


        # print("length of dict => ", len(dictionary))
        sticksCut.append(len(dictionary))
        # print("before changing => ",dictionary)
        for iKey in list(dictionary.keys()):
            if dictionary[iKey] == minimumValue:
                # print(dictionary[iKey])
                del dictionary[iKey]
            else:
                
                dictionary[iKey] -= minimumValue
        # print("after changing => ",dictionary)
                
    return sticksCut


arr = [5, 4, 4, 2, 2, 8]
print(cutTheSticks(arr))