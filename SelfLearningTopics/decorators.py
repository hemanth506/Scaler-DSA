
# It is a function which returns another function as argument

def decoratorFunction(originalFunction):
    def innerFunc():
        num = 24
        return originalFunction(num)
    return innerFunc

@decoratorFunction
def display(number):
    print("It is from display => ",number)


# decorator = decoratorFunction(display)
# decorator()

display()


