
def permutationEquation(p):
    N = len(p)

    elt = []
    for i in range(1, N + 1):
        indexElt = (p.index(i)) + 1
        elt.append(indexElt)

    # print(elt)

    eltNew = []
    for i in range(0, N):
        print(p.index(elt[i]))
        indexElt = (p.index(elt[i])) + 1
        eltNew.append(indexElt)

    # print(eltNew)


    return eltNew

p = [4,3,5,1,2]
print(permutationEquation(p))