def closestNumbers(arr):
    arr.sort()
    N = len(arr)
    dictionary = dict()
    for i in range(N - 1):
        absValue = abs(arr[i] - arr[i + 1])
        if absValue in dictionary:
            dictionary[absValue].append(arr[i])
            dictionary[absValue].append(arr[i + 1])
        else:
            dictionary[absValue] = [arr[i], arr[i + 1]]

    keys = sorted(dictionary.keys())
    print(dictionary[keys[0]])

    return dictionary[keys[0]]



arr = [-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854, -520, -470]

arr = [-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854]
print(closestNumbers(arr))