def solve(s):
    s = list(s)
    print(s)
    string = ''
    count = 0
    for i in s:
        if s[count - 1] == " " or count == 0:
            string += str(i.capitalize())
        else: 
            string += i
        count += 1
    return string

print(solve("hello  world"))