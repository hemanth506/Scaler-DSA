def main():
    n = int(input())

    for i in range(0, n):
        number = int(input())

        totalSum = 0
        for i in range(1, number):
            if number % i == 0:
                totalSum += i

        if totalSum == number:
            response = "YES"
        else:
            response = "NO"
        print(response)
            


if __name__ == '__main__':
    main()