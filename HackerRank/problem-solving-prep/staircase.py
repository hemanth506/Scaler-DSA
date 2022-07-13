
def staircase(n):
    for i in range(n):
        string = ""
        p = i + 1
        for j in range(n):
            if j < n - p:
                # print(j, n-p)
                string += ' '
            else:
                string += '#'
        print(string)
    

n = 6
staircase(n)