
def beautifulDays(i, j, k):
    count = 0
    for l in range(i, j+1):
        actualNumber = l

        number = l
        reverse = 0
        while number > 0:
            reminder = number % 10
            reverse = (reverse * 10) + reminder
            number = number // 10
            # print(number)

        # print(actualNumber - reverse, k)
        wholeNumber = abs(actualNumber - reverse) / k

        if wholeNumber - int(wholeNumber) == 0:
            print(i)
            count += 1

    return count


print(beautifulDays(20,23,6))


