def main():
    n = 49
    for i in range(2, n//2):
        if n % i == 0:
            return "NO"
    return "YES"

print(main())