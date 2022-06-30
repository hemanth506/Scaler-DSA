
def binarySearch(arr, toFind):
    l = 0
    h = len(arr) - 1
    while h >= l:
        m = (l + h) // 2
        # print(arr[m], m)
        if arr[m] < toFind:
            l = m + 1
        elif arr[m] > toFind:
            h = m - 1
        else:
            return 1
    return 0



def main():
    T = int(input())

    for _ in range(T):
        A = list(map(int, input().split()))
        B = int(input())
        A.pop(0)
        A.sort()

        print(binarySearch(A, B))
        print(A)

    return 0

if __name__ == '__main__':
    main()