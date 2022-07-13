def serviceLane(n, t, cases, width):

    listSize = []
    for i in range(t):
        minimum = width[cases[i][0]]
        for j in range(cases[i][0], cases[i][1] + 1):
            if width[j] < minimum:
                minimum = width[j]
        # print(minimum)
        listSize.append(minimum)

    return listSize

n = 8
t = 5
width = [2, 3, 1, 2, 3, 2, 3, 3]
cases = [[0, 3], [4, 6], [6, 7], [3, 5], [0, 7]]



n = 5
t = 5
width = [1, 2, 2, 2, 1]
cases = [[2, 3], [1, 4], [2, 4], [2, 4], [2, 3]]
print(serviceLane(n, t, cases, width))