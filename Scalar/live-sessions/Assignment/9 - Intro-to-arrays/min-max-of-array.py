def main():
    NArr = list(map(int, input().split()))
    N = NArr[0]

    NArr.pop(0)

    # Big Oh notation => O(N)
    # for i in range(N):
    #     for j in range(i+1, N):
    #         if NArr[i] > NArr[j]:
    #             temp = NArr[i]
    #             NArr[i] = NArr[j]
    #             NArr[j] = temp

    # Big Oh notation => O(NlogN) 
    # So using this
    NArr.sort()
                

    print(NArr[0] , NArr[N-1])
    return 0

if __name__ == '__main__':
    main()