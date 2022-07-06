if __name__ == '__main__':
    n = int(input())
    arr = map(int, input().split())
    
    newarr = list(arr)
    alreadyExist = []
    for i in range(0, n):
        if newarr[i] not in alreadyExist:
            alreadyExist.append(newarr[i])
    
    alreadyExist.sort()

    print(alreadyExist[-2])

    