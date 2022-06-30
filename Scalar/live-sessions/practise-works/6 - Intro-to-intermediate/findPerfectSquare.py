
n = int(input())
i = 1
ans = 1
while i**2 <= n:
    ans = i
    i += 1 

# approx. it will have "sqrt(N)" iterations, it can be still be optimized by "log N base 2" iterations
print(f'{i} iterations for {n} and floor(square root) is {ans}') 