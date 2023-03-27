import turtle


LEVEL = 14  # Задается количество итераций


class MainWindow:
    # Установка параметров окна turtle
    def __init__(self):
        turtle.Screen().setup(1200, 700)
        turtle.screensize(3*1200, 3*700)
        turtle.tracer(50)
        turtle.Screen().bgcolor('black')
        turtle.speed('fastest')
        turtle.pencolor('white')

        self.recursion(400, LEVEL)

        turtle.mainloop()


    def side(self, l):
        # Вычисляется линия которую нужно нарисовать
        return (l ** 2 / 2) ** 0.5


    def recursion(self, l, n, turn='right'):
        # Рекурсивная функция в которой происходит создание фрактала
        if n == 0:
            turtle.forward(l)
            return
        if turn == 'right':
            turtle.right(45)
        else:
            turtle.left(45)

        self.recursion(self.side(l), n - 1, turn='right')

        if turn == 'right':
            turtle.left(90)
        else:
            turtle.right(90)

        self.recursion(self.side(l), n - 1, turn='left')

        if turn == 'right':
            turtle.right(45)
        else:
            turtle.left(45)


MainWindow()
