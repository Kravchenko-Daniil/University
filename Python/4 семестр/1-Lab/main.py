from tkinter import *
from math import sin, cos, radians

size = 600
r = 100
dot_size = 5
speed = 100
reverse = False

window = Tk(className="Tkinter")
canvas = Canvas(window, width=size, height=size)
canvas.pack()

x1, y1 = size/2, size/2
circle = canvas.create_oval(x1-r, y1-r, x1+r, y1+r,  fill="#c31432", width=2)


if reverse == True:
    func = [sin, cos]
else:
    func = [cos, sin]

t = 0

def x2_y2():
    global r, dot_size,  x1, y1, t, func

    x2 = x1 + (r + dot_size) * func[0](t)
    y2 = y1 + (r + dot_size) * func[1](t)
    return x2, y2

x2, y2 = x2_y2()

dot = canvas.create_oval(x2-dot_size, y2-dot_size, x2+dot_size, y2+dot_size, fill="blue", width=0)

def move():
    global speed, dot, x2, y2, t

    t += radians(speed * 6 / 100)
    x_move, y_move = x2_y2()
    canvas.move(dot, x_move-x2, y_move-y2)
    x2, y2 = x_move, y_move
    window.after(10, move)

move()

window.mainloop()

