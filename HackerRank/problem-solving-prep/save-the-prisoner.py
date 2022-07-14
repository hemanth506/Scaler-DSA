

def reverseArr(f,l,arr):
    while f < l:
        temp = arr[f]
        arr[f] = arr[l]
        arr[l] = temp

        f += 1
        l -= 1
    return arr

def saveThePrisoner(n, m, s):

    arr = []
    for i in range(1, n+1):
        arr.append(i)

    print(arr)

    f = 0
    l = n - 1
    arr = reverseArr(f, l, arr)

    print(arr)

    f = 0
    l = (m - s) % n
    arr = reverseArr(f, l, arr)
    print(arr)


def saveThePrisoner2(n, m, s):

    count = 0
    start = s
    arr = []
    while count < m:
        
        if start == n:
            # print("equals => ",start, count, m, n)
            arr.append(1)
            start = 1
            
        else:
            # print("else => ", start, count, m, n)
            start += 1
            arr.append(start)
            
        count += 1

    print(arr[-2])


n = 4
m = 6
s = 2

n,m,s = [3,7,3]
print(saveThePrisoner2(n,m,s))
