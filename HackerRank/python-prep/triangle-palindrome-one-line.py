for i in range(1,int(input())+1): 
    print("".join([str(i) for i in range(1, i+1)]) + "".join([str(i) for i in range(i-1, 0, -1)]))
    # print (((10**i - 1)//9)**2)4
    