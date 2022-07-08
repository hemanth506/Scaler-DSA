def equalizeArray(arr):
    dictionary = {}
    for i in range(len(arr)):
        if arr[i] in dictionary:
            dictionary[arr[i]] += 1
        else:
            dictionary[arr[i]] = 1

    newDict = dict(sorted(dictionary.items(), key = lambda x: x[1], reverse = True))

    # len(newDict) - 1
    iterate = 0
    deleted = 0
    for value in newDict.values():
        if iterate != 0:
            deleted += value
        iterate += 1

    return deleted



arr = [3, 3, 2, 1, 3]
print(equalizeArray(arr))