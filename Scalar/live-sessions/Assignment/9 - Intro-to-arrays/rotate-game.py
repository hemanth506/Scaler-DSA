def reverseArr(eltList, f, e):
    while f < e:
        temp = eltList[f]
        eltList[f] = eltList[e]
        eltList[e] = temp
        f += 1
        e -= 1
    return eltList


def main():
    eltList = list(map(int, input().split()))
    N = eltList[0]
    eltList.pop(0)

    rTimes = int(input())

    # -------- right to left ----------------
    # f = 0
    # e = N - 1
    # eltList = reverseArr(eltList, f, e)
    # print(eltList)

    # k = rTimes % N
    # f = 0
    # e = k - 1
    # eltList = reverseArr(eltList, f, e)
    # print(eltList)

    # f = k
    # e = N - 1
    # eltList = reverseArr(eltList, f, e)
    # print(eltList)

    # -------- left to right ----------------
    f = 0
    e = N - 1
    eltList = reverseArr(eltList, f, e)
    print(eltList)

    k = rTimes % N
    f = N - k
    e = N - 1
    eltList = reverseArr(eltList, f, e)
    print(eltList)

    f = 0
    e = N - k - 1
    eltList = reverseArr(eltList, f, e)
    print(eltList)
    return 0

if __name__ == '__main__':
    main()