from tkinter import *
import math


class MainWindow(Tk):
    def __init__(self):
        Tk.__init__(self)

        self.title('Koch snowflake')

        self.width = 512
        self.height = int(round((self.width * math.sqrt(3) / 2)))
        self.margin = 50

        self.canvas = Canvas(self, width=self.width + (self.margin * 2), height=self.height + (self.margin * 2), bg='white')
        self.canvas.pack()

        self.btn_draw = Button(self, text='Draw', command=self.draw_lines)
        self.btn_draw.pack(side=RIGHT)

        self.label_lvl = Label(self, text='Level')
        self.label_lvl.pack()

        self.input_lvl = Entry(self, justify=CENTER, width=5)
        self.input_lvl.insert(INSERT, '1')
        self.input_lvl.pack()

        self.mainloop()


    def draw_lines(self):
        self.canvas.delete('all')

        level = int(self.input_lvl.get())

        r = self.width / 2 - self.margin

        x1_start = self.width / 1.7
        y1_start = self.height / 1.65 - r * math.sin(math.pi/2)

        x2_start = self.width / 1.7 + r * math.cos(math.pi/6)
        y2_start = self.height / 1.65 - r * math.sin(-math.pi/6)

        x3_start = self.width / 1.7 - r * math.cos(-math.pi / 6)
        y3_start = self.height / 1.65 - r * math.sin(-math.pi / 6)

        self.recursion(level, x1_start, y1_start, x2_start, y2_start)
        self.recursion(level, x2_start, y2_start, x3_start, y3_start)
        self.recursion(level, x3_start, y3_start, x1_start, y1_start)

    def recursion(self, level, x1, y1, x2, y2):
        # print('level: ', level)

        if level > 1:
            angle = math.atan2(y2 - y1, x2 - x1)
            r = math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1))

            x1_new = x1 + r * math.cos(angle) / 3
            y1_new = y1 + r * math.sin(angle) / 3

            x2_new = x1_new + r * math.cos(angle- math.pi / 3) / 3
            y2_new = y1_new + r * math.sin(angle - math.pi / 3) / 3

            x3_new = x1 + 2 * r * math.cos(angle) / 3
            y3_new = y1 + 2 * r * math.sin(angle) / 3

            self.recursion(level - 1, x1, y1, x1_new, y1_new)
            self.recursion(level - 1, x1_new, y1_new, x2_new, y2_new)
            self.recursion(level - 1, x2_new, y2_new, x3_new, y3_new)
            self.recursion(level - 1, x3_new, y3_new, x2, y2)
        else:
            self.canvas.create_line(x1, y1, x2, y2)

MainWindow()