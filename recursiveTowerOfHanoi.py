recursiveCounter = 0
def TowerOfHanoiRecur(n, source, destination, helper):
    global recursiveCounter
    recursiveCounter += 1
    if n == 1:
        print("Move last from", source, "to", destination)
        return
    TowerOfHanoiRecur(n - 1, source, helper, destination)
    print("Move disk", n, "from", source, "to", destination)
    TowerOfHanoiRecur(n - 1, helper, destination, source)


# Driver code
n = 7
TowerOfHanoiRecur(n, 'Source', 'Destination', 'Helper')
print("Total counter of iterations for n = 7 :",recursiveCounter)

recursiveCounter = 0
n = 4
TowerOfHanoiRecur(n, 'Source', 'Destination', 'Helper')
print("Total counter of iterations for n = 4 :",recursiveCounter)
