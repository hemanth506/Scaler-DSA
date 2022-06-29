# find factors of n

n = int(input())

i = 1
count = 0
factors = []
while i**2 <= n:
    if n % i == 0:
        factors.append(i)
        if i != n//i:
            factors.append(n//i)
        count += 1
    i += 1

factors.sort()

print("Total iterations => " + str(count))
print("Total no. of factors => " + str(len(factors)))
print(f"Factors of {n} are " + str(factors))
