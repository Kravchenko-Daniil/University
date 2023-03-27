import tkinter
import math

class MainWindow(tkinter.Tk):
    def __init__(self):
        tkinter.Tk.__init__(self)

        self.title('Sierpinski Triangle')

        self.width = 512
        self.height = int(round((self.width * math.sqrt(3) / 2)))
        self.margin = 50

        self.canvas = tkinter.Canvas(self, width=self.width + (self.margin * 2), height=self.height + (self.margin * 2), bg='white')
        self.canvas.pack()

        self.btn = tkinter.Button(self, text='Draw', command=self.draw)
        self.btn.pack(side=tkinter.RIGHT)

        self.label = tkinter.Label(self, text='Level')
        self.label.pack()

        self.inputLevel = tkinter.Entry(self, justify=tkinter.CENTER, width=5)
        self.inputLevel.insert(tkinter.INSERT, '1')
        self.inputLevel.pack()

        self.mainloop()


    def draw(self):
        self.canvas.delete('all')

        level = int(self.inputLevel.get())

        x1, y1 = self.margin + 0, self.margin + self.height # 50, 493
        x2, y2 = self.margin + self.width / 2, self.margin + 0 # 306.0, 50
        x3, y3 = self.margin + self.width, self.margin + self.height # 562, 493

        print(x1, y1)
        print(x2, y2)
        print(x3, y3)

        self.recursion(level, x1, y1, x2, y2, x3, y3)


    def recursion(self, level, x1, y1, x2, y2, x3, y3):
        # print('level: ', level)

        if level <= 1:
            self.canvas.create_line(x1, y1, x2, y2)
            self.canvas.create_line(x2, y2, x3, y3)
            self.canvas.create_line(x3, y3, x1, y1)

        else:
            level = level - 1

            x1_mid = (x1 + x2) / 2
            y1_mid = (y1 + y2) / 2

            x2_mid = (x2 + x3) / 2
            y2_mid = (y2 + y3) / 2

            x3_mid = (x3 + x1) / 2
            y3_mid = (y3 + y1) / 2

            self.recursion(level, x1, y1, x1_mid, y1_mid, x3_mid, y3_mid)
            self.recursion(level, x1_mid, y1_mid, x2, y2, x2_mid, y2_mid)
            self.recursion(level, x3_mid, y3_mid, x2_mid, y2_mid, x3, y3)


MainWindow()
