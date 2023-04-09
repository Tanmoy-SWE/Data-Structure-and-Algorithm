#It is a list of 2D list, 1st index is it's value and 2nd index is it's priority
nodes = []
#This will point to the last index
size = len(nodes)

def enqueue(val, priority):
    global size
    size = size + 1
    nodes.append([val, priority])
    BubbleSortOnPriority(nodes)

def peek():
    global size
    maxPriority = -999999
    index = -1
    for i in range(0, size):
        if (maxPriority < nodes[i][1]):
            maxPriority = nodes[i][1]
            index = i
    return index

def dequeue():
    ind = peek()
    global size
    for i in range(ind,size-1):
        nodes[i] = nodes[i+1]
    size = size - 1

def swap(a,b):
    temp = a
    a = b
    b= temp

def BubbleSortOnPriority(queue):
    global size
    for i in range(size):
        minimum = queue[i]
        for j in range(i+1, size-i):
            if minimum[1] < queue[j][1]:
                minimum = queue[j]
                swap(queue[i],queue[size-i-1])
def printQueue(queue):
    global size
    for i in range(size):
        print(queue[i], end=" ")
    print()

if __name__=="__main__":
    print("The priority Queue is not being printed priority wise but operates according to priority.")
    enqueue(8,3)
    enqueue(23, 45)
    enqueue(12, 50)
    enqueue(10,1)
    enqueue(17,17)
    enqueue(9,0)
    print("All the elements after insertion : ")
    printQueue(nodes)
    print("Dequeued")
    dequeue()
    print("State of Priority Queue : ")
    printQueue(nodes)
    print("The peek is pointing to : ",nodes[peek()])
    print("Dequeued")
    dequeue()
    print("Dequeued")
    dequeue()
    print("State of Priority Queue : ")
    printQueue(nodes)
