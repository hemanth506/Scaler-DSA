def minimumDistances(a):
    dictionary = {}
    for i in range(len(a)):
        if a[i] in dictionary:
            dictionary[a[i]].append(i)
        else:
            dictionary[a[i]] = [i]

    initial = False
    diff = -1
    for value in dictionary.values():
        if len(value) == 2:
            if initial:
                if diff > abs(value[0] - value[1]):
                    diff = abs(value[0] - value[1])
            else:
                diff = abs(value[0] - value[1])
                initial = True

    return diff


a = [7, 1, 3, 4, 1, 7]
print(minimumDistances(a))