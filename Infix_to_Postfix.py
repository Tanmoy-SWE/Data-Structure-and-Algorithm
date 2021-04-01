class IntoPost:
    def __init__(self, length):
        self.top = -1
        self.length = length
        self.array = []
        # Precedence setting
        self.output = []
        self.precedence = {'^': 1,
                           '*': 2, '%': 2, '/': 2,
                           '+': 3, '-': 3,
                           '<': 4, '<=': 4, '>': 4, '>=': 4,
                           '==':5, '!=': 5,
                           '&&':6}
    def isEmpty(self):
        if self.top == -1 :
            return True
        else:
            return False
    def peek(self):
        p = len(self.array)
        return self.array[p-1]
    def pop(self):
        if not self.isEmpty():
            self.top -= 1
            return self.array.pop()
        else:
            return "$"

    def push(self, op):
        self.top += 1
        self.array.append(op)
    # is operand
    def isOperand(self, ch):
        return ch.isalpha()
    def notGreater(self, i):
        try:
            a = self.precedence[i]
            b = self.precedence[self.peek()]
            return True if a <= b else False
        except KeyError:
            return False
    def infixToPostfix(self, exp):
        for i in exp:
            if self.isOperand(i):
                self.output.append(i)
            elif i == '(':
                self.push(i)
            elif i == ')':
                while ((not self.isEmpty()) and
                       self.peek() != '('):
                    a = self.pop()
                    self.output.append(a)
                if (not self.isEmpty() and self.peek() != '('):
                    return -1
                else:
                    self.pop()
            else:
                while (not self.isEmpty() and self.notGreater(i)):
                    self.output.append(self.pop())
                self.push(i)
        while not self.isEmpty():
            self.output.append(self.pop())
        print ("".join(self.output))

expression = input("Enter any infix expression : ")
print("The post-fix expression is :", end = " ")
size = len(expression)
obj = IntoPost(size)
obj.infixToPostfix(expression)

