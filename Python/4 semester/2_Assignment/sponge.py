import turtle


level = 4  # level of iteration


def draw(n, m):
    if n <= 0:
        turtle.color('black')
        turtle.begin_fill()
        for i in range(4):
            turtle.forward(m)
            turtle.left(90)
        turtle.end_fill()

    else:
        for i in range(4):
            draw(n - 1, m / 3)
            turtle.forward(m / 3)

            draw(n - 1, m / 3)
            turtle.forward(m / 3)

            turtle.forward(m / 3)
            turtle.left(90)


turtle.screensize(700*3, 500*3)
turtle.tracer(10000)
draw(level, 200)
turtle.done()
