def workbook(n, k, arr):

    pages = 1
    specialProblems = 0
    for i in range(n):
        problems = arr[i]
        for problem in range(1, problems + 1):
            pageTurned = False
            print(problem, pages)
            if problem == pages:
                specialProblems += 1

            if problem % k == 0:
                pages += 1
                pageTurned = True

        if not pageTurned:
            pages += 1
    return specialProblems


n = 5
k = 3
arr = [4, 2, 6, 1, 10]

# n = 2
# k = 3
# arr = [4, 2]
print(workbook(n, k, arr))