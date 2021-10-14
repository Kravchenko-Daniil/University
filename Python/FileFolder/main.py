import os, shutil

os.chdir("/home/dan/PycharmProjects/work/FileFolder/WorkFile")
cmd = 0

while True:
    def CreateDir():
        askDir = input("В какой директрии создать папку: ")
        name = input("Укажите название папки: ")
        if askDir == "текущей":
            try:
                os.mkdir(name)
            except OSError:
                print("\nСоздать папку не удалось")
            else:
                print("\nПапка успешно создалась")


        else:
            try:
                os.makedirs(f"{askDir}/{name}")
            except OSError:
                print("\nСоздать папку не удалось")
            else:
                print("\nПапка успешно создалась")



    def DeleteDir():
        askDir=input("В какой директории удалить: ")
        name = input("Укажите название папки: ")
        if askDir == "текущей":
            try:
                os.rmdir(name)
            except OSError:
                print("\nПапку не получилось удалить")
            else:
                print("\nПапка успешно удалилась")
        else:
            try:
                os.rmdir(f"{askDir}/{name}")
            except OSError:
                print("\nПапку не получилось удалить")
            else:
                print("\nПапка успешно удалилась")

    def ChangeDir():
        name=input("В какую директорию перейти?: ")
        try:
            os.chdir(name)
        except OSError:
            print("\nНе удалось перейти")
        else:
            print(f"Вы сейчас в ../{name}")

    def CreateFile():
        askDir = input("В какой директории создать?: ")
        name = input("Введите имя файла: ")
        name += ".txt"
        if askDir == "текущей":
            try:
                 file = open(name,"w")
            except OSError:
                print("\nНе удалось создать")
            else:
                print('\nФайл успешно создан')
        else:
            try:
                file = open(f"{askDir}/{name}", "w")
            except OSError:
                print("\nНе удалось создать файл")
            else:
                print("\nФайл успешно создан")

    def DeleteFile():
        askDir = input("В какой директории удалить?: ")
        name = input("Введите имя файла: ")
        name += ".txt"
        if askDir == "текущей":
            try:
                os.remove(name)
            except OSError:
                print("\nНе удалось удалить")
            else:
                print('\nФайл успешно удалён')
        else:
            try:
                os.remove(f"{askDir}/{name}")
            except OSError:
                print("\nНе удалось удалить файл")
            else:
                print("\nФайл успешно удалён")

    def WriteFile():
        askDir = input("В какой директории файл?: ")
        name = input("Введите имя файла:")
        text = input("Введите что нужно записать в файл:")
        name+=".txt"
        if askDir == "текущей":
            try:
                file = open(f"{name}", "a+")
                file.write(text)
                file.close()
            except OSError:
                print("\nНе удалось записать")
            else:
                print('\nФайл успешно записан')
        else:
            try:
                file = open(f"{askDir}/{name}", "a+")
                file.write(text)
                file.close()
            except OSError:
                print("\nНе удалось записать файл")
            else:
                print("\nФайл успешно записан")

    def OpenFile():
        askDir = input("В какой директории файл?: ")
        name = input("Введите имя файла:")
        name += ".txt"
        if askDir == "текущей":
            try:
                print("")
                file = open(f"{name}")
                print(*file)
            except OSError:
                print("\nНе удалось открыть")

        else:
            try:
                file = open(f"{askDir}/{name}")
                print(*file)
            except OSError:
                print("\nНе удалось открыть файл")


    def CopyFile():
        askDir = input("В какой директории файл?: ")
        name = input("Введите имя файла:")
        moveDir = input("В какую директорию скопировать?: ")
        name  += ".txt"
        if askDir == "текущей":
            try:
                shutil.copyfile(name, f"{moveDir}/{name}")
            except OSError:
                print("\nНе удалось скопировать")
            else:
                print("\n Файл успешно скипирован")
        else:
            try:
                shutil.copyfile(f"{askDir}/{name}", f"{moveDir}/{name}")
            except OSError:
                print("\nНе удалось скопировать файл")
            else:
                print("\n Файл успешно скипирован")

    def MoveFile():
        askDir = input("В какой директории файл?: ")
        name = input("Введите имя файла:")
        moveDir = input("В какую директорию переместить?: ")
        name += ".txt"
        if askDir == "текущей":
            try:
                shutil.move(name,f"{moveDir}/{name}")
            except OSError:
                print("\nНе удалось переместить")
            else:
                print("\n Файл успешно перемещен")
        else:
            try:
                shutil.move(f"{askDir}/{name}", f"{moveDir}/{name}")
            except OSError:
                print("\nНе удалось переместить файл")
            else:
                print("\n Файл успешно перемещен")


    class Menu:
        print("Меню команд: \n создать папку, удалить папку\n создать файл, удалить файл\n записать файл , открыть файл\n скопировать файл, переместить файл\n переместиться, выход")
        cmd = input("Введите команду: ")
        if cmd == "создать папку":
            CreateDir()
        elif cmd == "удалить папку":
            DeleteDir()
        elif cmd == "переместиться":
            ChangeDir()
        elif cmd == "создать файл":
            CreateFile()
        elif cmd == "удалить файл":
            DeleteFile()
        elif cmd == "записать файл":
            WriteFile()
        elif cmd == "открыть файл":
            OpenFile()
        elif cmd == "скопировать файл":
            CopyFile()
        elif cmd == "переместить файл":
            MoveFile()
        elif cmd == "выход":
            exit()
        else:
            print("Такой команды нет")


