# Given +ve N How many times we need to divide by 2 until it reached = 1

def main(num):
    i = 0
    while num > 1:
        i += 1
        num //= 2
    return i


num = int(input())
print(main(num))