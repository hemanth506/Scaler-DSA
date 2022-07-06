def reversearray(f, l, arr):
    while f < l:
        temp = arr[f]
        arr[f] = arr[l]
        arr[l] = temp
        f += 1
        l -= 1
    return arr

def circularArrayRotation(a, k, queries):
    
    N = len(a)
    f = 0
    l = N - 1
    a = reversearray(f, l, a)
    print(a)

    rotation = k % N 
    f = 0
    l = rotation - 1
    a = reversearray(f, l, a)
    print(a)

    f = rotation
    l = N - 1
    a = reversearray(f, l, a)
    print(a)

    arrQuery = []
    for i in range(len(queries)):
        arrQuery.append(a[queries[i]])

    return arrQuery


k = 2
a = [1, 2, 3]
queries = [1, 1, 2]
print(circularArrayRotation(a, k, queries))


