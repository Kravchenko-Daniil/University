from tkinter import Tk, Canvas, CENTER
from random import randrange, choice

SIZE = 25
RESOLUTION = 10


class Field(object):
    cardinal = {
        'left': (-1, 0),
        'right': (1, 0),
        'top': (0, -1),
        'bottom': (0, 1)
    }

    class Food(object):
        def __init__(self, field):
            self.field = field
            self.id_ = field.canvas.create_rectangle(
                *self.coords(),
                width=1,
                outline='black',
                fill='red'
            )

        def coords(self):
            while True:
                self.x = randrange(0, self.field.width)
                self.y = randrange(0, self.field.height)
                node = self.field.snake.head
                end_flag = True
                while node:
                    if (self.x == node.x) and (self.y == node.y):
                        end_flag = False
                    node = node.next
                if end_flag:
                    break
            return [
                self.x * self.field.dot_size,
                self.y * self.field.dot_size,
                (self.x + 1) * (self.field.dot_size),
                (self.y + 1) * (self.field.dot_size),
            ]

        def reborn(self):
            if self.field.score == (self.field.width * self.field.height - 1):
                self.field.game_over = True
                return
            self.field.canvas.coords(
                self.id_,
                *self.coords()
            )

    class Snake(object):
        class Item(object):
            def __init__(self, x, y, snake, previous=None, next_=None, is_head=False):
                self.x = x
                self.y = y
                self.snake = snake
                self.previous = previous
                self.next = next_
                self.id_ = snake.field.canvas.create_rectangle(
                    *self.coords(),
                    fill='white' if not is_head else '#4A7A28',
                    outline='black',
                    width=1
                )

            def coords(self):
                len_ = self.snake.field.dot_size
                return [
                    self.x * len_,
                    self.y * len_,
                    (self.x + 1) * len_,
                    (self.y + 1) * len_
                ]

            def move(self, x, y):
                self.x = x
                self.y = y

                self.snake.field.canvas.coords(
                    self.id_,
                    *self.coords()
                )
                self.snake.field.canvas.itemconfig(
                    self.id_,
                    fill='#4A7A28'
                )

        def __init__(self, field):
            x = randrange(0, field.width)
            y = randrange(0, field.height)
            self.field = field
            self.head = self.Item(x, y, self, is_head=True)

        def is_game_over(self, x, y):
            node = self.head
            while node.next:
                if x == node.x and y == node.y:
                    self.field.game_over = True
                    return True
                node = node.next
            return False

        def move(self, velocity):
            x = (self.head.x + velocity[0]) % self.field.width
            y = (self.head.y + velocity[1]) % self.field.height

            if (x == self.field.food.x) and (y == self.field.food.y):
                self.head.previous = self.Item(x, y, self, next_=self.head, is_head=True)
                self.field.canvas.itemconfig(
                    self.head.id_,
                    fill='white'
                )
                self.head = self.head.previous
                self.field.score += 1
                self.field.food.reborn()
                self.field.speed += self.field.increment

            else:
                tail = self.head
                while tail.next:
                    tail = tail.next
                if self.is_game_over(x, y):
                    return
                tail.move(x, y)
                if tail != self.head:
                    tail.previous.next = None
                    tail.previous = None
                    tail.next = self.head
                    self.head.previous = tail
                    self.field.canvas.itemconfig(
                        self.head.id_,
                        fill='white'
                    )
                    self.head = tail

    def __init__(self, width, height, dot_size):
        self.width = width
        self.height = height
        self.dot_size = dot_size
        self.score = 0
        self.speed = 500
        self.increment = (1000 - 100) / (width * height - 1)
        self.root = Tk()
        self.canvas = Canvas(
            self.root,
            width=width * dot_size,
            height=height * dot_size,
            bg='#545454',
            highlightthickness=0
        )
        self.canvas.pack()
        self.snake = self.Snake(self)
        self.food = self.Food(self)
        self.velocity = choice(list(self.cardinal.values()))
        self.previous_velocity = self.velocity
        self.game_over = False
        self.root.bind('<Left>', func=lambda event: self.key_press('left'))
        self.root.bind('<Right>', func=lambda event: self.key_press('right'))
        self.root.bind('<Up>', func=lambda event: self.key_press('top'))
        self.root.bind('<Down>', func=lambda event: self.key_press('bottom'))

    def key_press(self, key):
        velocity = self.cardinal[key]
        if (velocity[0] + self.previous_velocity[0] != 0) or (velocity[1] + self.previous_velocity[1] != 0):
            self.velocity = velocity

    def move(self):
        self.snake.move(self.velocity)
        self.previous_velocity = self.velocity
        if not self.game_over:
            self.root.after(int(self.speed), self.move)
        else:
            self.canvas.create_rectangle(
                0, 0,
                self.width * self.dot_size,
                self.height * self.dot_size,
                fill='black'
            )
            self.canvas.create_text(
                self.width * self.dot_size / 2,
                self.height * self.dot_size / 2,
                text=f"GAME OVER\n\nYour score: {self.score}\n",
                justify=CENTER, font="Verdana 14",
                fill='red',
                anchor='center',
            )

    def start(self):
        self.move()
        self.root.mainloop()


field = Field(RESOLUTION, RESOLUTION, SIZE)
field.start()