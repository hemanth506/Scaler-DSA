def main():
    # N = int(input())
    N = 400

    for i in range(1, N):
        strI = str(i)
        iList = list(strI)
        total = 0
        for j in range(0, len(iList)):
            j = int(iList[j])
            total += j**3

        if total == int(i):
            print(i)
    

main()