import socket, random, re, threading


def encryption(msg):
    byteMsg = ''
    for i in msg:
        byteMsg += chr(ord(i) + K)
    return byteMsg

def decryption(data):
    textData = ''
    for i in data:
        textData += chr(ord(i) - K)
    return textData



sock1 = socket.socket()
sock2 = socket.socket()


def bind_enc(sock1):
    port1 = random.randint(1024, 65355)
    while True:
        try:
            sock1.bind(('127.0.0.1', port1))
            print(f"Connect to {port1}\nWaiting clients...\n")
            break
        except OSError:
            port1 = random.randint(1024, 65535)


def generating_keys(conn1, addr1):
    global K

    print('Generating encryption keys...')
    keys = conn1.recv(1024).decode()
    print(keys)
    intKeys = re.findall(r'\d+', keys)
    g, p, A = int(intKeys[0]), int(intKeys[1]), int(intKeys[2])
    sercificate(conn1, addr1, A)
    with open('server_keys.txt', 'a+') as file:
        file.seek(0)
        first_symb = file.read(1)
        if not first_symb:
            b = random.randint(10**2, 10**3) # b - закрытый ключ сервера
            B = g ** b % p  # B - открытый ключ сервера
            file.write(f'{b}, {B}')
        else:
            file.seek(0)
            int_keys = file.read().split(',')
            b, B = int(int_keys[0]), int(int_keys[1])


    conn1.send(f"Public key: {B}".encode())
    K = A ** b % p
    print('Completed!')

def sercificate(conn1, addr1, key):
    with open('sercificate.txt', 'a+') as file:
        file.seek(0)
        text = file.read()
        if str(key) not in text:
            conn1.close()


def bind_chat(sock2):
    global port2
    port2 = 41235
    while True:
        try:
            sock2.bind(('127.0.0.1', port2))
            break
        except OSError:
            port2 = random.randint(1024, 65535)
bind_chat(sock2)


def chatting(conn2, addr2):
    while True:
        data = conn2.recv(1024).decode()
        if not data:
            break
        textData = decryption(data)
        print(f'Client{addr2[1]}: {textData}')
        byteMsg = encryption(textData)
        conn2.send(byteMsg.encode())
    conn2.close()
    print(f'Client{addr2[1]} disconnected')


def connect(sock2):
    clients = []

    while True:
        sock2.listen(0)
        conn2, addr2 = sock2.accept()
        clients.append(conn2)
        conn2.send(encryption('Welcome to the chat!').encode())
        chatting(conn2, addr2)



def main():
    bind_enc(sock1)
    sock1.listen(0)
    conn1, addr1 = sock1.accept()
    generating_keys(conn1, addr1)
    conn1.send(f'{encryption(str(port2))}'.encode())
    connect(sock2)

if __name__ == '__main__':
   main()
