import socket, threading


sock = socket.socket()


def messages(sock):
    while True:
        data = sock.recv(1024)
        print(data.decode()+"\n"+">>>", end='')

def sedding(sock):
    while True:
        msg = input()
        sock.send(msg.encode())
        print('Message sent')
def connect(sock):
    port = int(input('Write the port >>> '))
    if port == '':
        port = 12345
    try:
        sock.connect(('127.0.0.1', port))
    except ConnectionRefusedError:
        print('Failed...')
        return False
    print('Connection established')

connect(sock)
threading.Thread(target=messages, args=(sock, ), daemon=True).start()
sedding(sock)
