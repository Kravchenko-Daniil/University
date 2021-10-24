пункт 2. После полключения клиента вызывется функция аунтификации клиента и после чего создается новый поток для чата с клиентом

![image](https://user-images.githubusercontent.com/90443315/138598996-39251a86-9275-434c-ad32-c8cdf83657a5.png)

Вывод что клиент подключен
![image](https://user-images.githubusercontent.com/90443315/138599073-f0209693-6626-412f-aba0-378edacd3f13.png)

Вывод сообщения от клиента
![image](https://user-images.githubusercontent.com/90443315/138599102-ed812925-c3b5-4b86-a9b8-8d6cf608d9c4.png)


Пункт 3. Сервер запрашивает имя при входе нового клиента, при повторном входе клиента сервер поприветствует его

![image](https://user-images.githubusercontent.com/90443315/138599184-dce64e65-43f8-4f13-a25f-f14263c6581b.png)

![image](https://user-images.githubusercontent.com/90443315/138599194-9707b7eb-51c1-4415-9cdf-bb623349d513.png)

История сообщений хранится в файле messagesHistory.txt

![image](https://user-images.githubusercontent.com/90443315/138599220-7d41bf65-4748-4d3e-931a-650cc7413c52.png)

Пересылка сообщений каждому пользователю

На этом фото показано как я подключил второго пользователя и отправил сообщение

![image](https://user-images.githubusercontent.com/90443315/138599291-3bc7ff2c-9440-4af7-bc52-56581277ba7c.png)

У первого пользователя пришло от него сообщение

![image](https://user-images.githubusercontent.com/90443315/138599321-08f69764-cf34-4520-bcfb-310355f97c6a.png)

тключение сервера (завершение программы) командой shutdown

![image](https://user-images.githubusercontent.com/58771506/135754582-fdd19725-daae-4e59-81ca-f3de72868cf8.png)

Пауза (остановка прослушивание порта) командами ключения и отключения stop listen start listen

![image](https://user-images.githubusercontent.com/58771506/135754385-43794d43-9dba-495f-a8cd-8e81d74a08ce.png)

У клиента ничего не происходит, он ожидает соединения, так как мы запретили подключения
Если мы введем start listen то клиент сразу подключится

![image](https://user-images.githubusercontent.com/58771506/135754425-f3507791-564c-4c72-a983-f78b5b821cd0.png)

![image](https://user-images.githubusercontent.com/58771506/135754432-a2c0db99-6869-438b-9566-4d8b279d4bb8.png)

Показ логов выключается и включается командами stop log start log

![image](https://user-images.githubusercontent.com/58771506/135754459-3f83d3b4-ce9d-435c-b13e-4dc530d0517a.png)

Очистка логов очищается сам файл логов и консоль командой clear log



Очистка файла идентификации выполняется командой clear file


