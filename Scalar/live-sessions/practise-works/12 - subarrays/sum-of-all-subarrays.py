def subarraySumPrefix(arr):
    prefix = [0] * len(arr)
    prefix[0] = arr[0]
    for i in range(len(arr)):
        prefix[i] = prefix[i-1] + arr[i] 

    print(prefix)


    for i in range(len(arr)):
        for j in range(i, len(arr)):
            if i == 0:
                sum = prefix[j]
            else:
                sum = prefix[j] - prefix[i - 1]
            print(i, j , sum)
        print("----------")



arr = [3, 8, 4,2,7,4]
subarraySumPrefix(arr)