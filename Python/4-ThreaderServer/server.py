import random, socket, datetime, os
from threading import Thread


sock = socket.socket()
portt = 12345
activeClients = []
now = datetime.datetime.today()

def bind(portt):
    while True:
        try:
            sock.bind(('127.0.0.1', portt))
            print("Connect to {}".format(portt))
            break
        except OSError as err:
            print("Port {} not avaliable".format(portt))
            portt = random.randint(1024, 65355)


bind(portt)
sock.listen(0)
print("Working...")

def listening(conn, addr):
    global activeClients
    while True:
        try:
            data = conn.recv(1024)
            print(f"Data from client {addr}: ")
        except (ConnectionResetError, ConnectionAbortedError) as err:
            print(err, addr)
            return
        msg = data.decode()
        print(msg)
        with open("messaagesHistory.txt", "a+") as history:
            history.write('\n'+str(now)+"-"+str(addr)+": "+msg)
        if not data:
            break
        for client in activeClients:
            client.send(f'Message from client {addr}: {msg}'.encode())
    conn.close()
    print("Client {} passed out".format(addr))

def authentication(conn, addr):
    with open("clients.txt", 'a+') as clients:
        clients.seek(0, 0)
        for line in clients:
            if str(addr) in line:
                conn.send(('Hello ' + line.replace(str(addr), '')).encode())
                break
        else:
            conn.send('Whats your name? '.encode())
            username = conn.recv(1024).decode()
            clients.write('\n' + username + str(addr))
            conn.send("We remember you. Welcome".encode())
    Thread(target=listening, args=(conn, addr), daemon=True).start()



def connection(sock):
    global activeClients
    while True:
        conn, addr = sock.accept()
        activeClients.append(conn)
        print(f'Client {addr} connected')
        authentication(conn, addr)
connection(sock)


commands = '''shutdown - to shutdown server
clear file - to clear clients list
stop listen - to stop listen port
start listen - to start listen port
stop log - to stop print log
start log - to start print log
clear log - to clear log file'''
print(commands)

while True:
    cmd = input()
    if cmd == 'shutdown':
        break
    elif cmd == 'clear file':
        with open('clients.txt', 'w', newline = '') as clients:
            pass
    elif cmd == 'stop listen':
        LISTEN = False
    elif cmd == 'start listen':
        LISTEN = True
    elif cmd == 'stop log':
        LOG = False
    elif cmd == 'start log':
        LOG = True
    elif cmd == 'clear log':
        if os.name == 'nt':
            os.system('cls')
        else:
            os.system('clear')
        with open('clients.txt', 'w'):
            pass

sock.close()