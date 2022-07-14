
def howManyGames(p, d, m, s):
    iteration = 0
    total = p
    print("initial => ",p)
    while p > 0:
        p -= d
        total += p
        if m > p:
            p = m
            total += p
            if total > s:
                break
            print("if m => ",p, total)
            iteration += 1
        else:
            print("if d => ",p, total)
            iteration += 1
    return iteration

def howMany(p,d,m,s):
    iteration = 0
    total = 0
    print(s, total)
    while s > total:
        total += p
        p -= d
        print(total, p)
        if p < m:
            break
        iteration += 1 
    return 

p = 20
d = 3
m = 6
s = 60

# print(howManyGames(p, d, m, s))
print(howMany(p, d, m, s))