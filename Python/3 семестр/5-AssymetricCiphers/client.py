import socket, random, re, threading

sock1 = socket.socket()
sock2 = socket.socket()

def connect_enc(sock1):
    port = int(input('Write the port >>> '))
    try:
        sock1.connect(('127.0.0.1', port))
    except ConnectionRefusedError as err:
        print(err)
        pass
connect_enc(sock1)

def generating_keys(sock1):
    global K
    print('Generating encryption keys...')
    with open('client_keys.txt', 'a+') as file:
        file.seek(0)
        first_symb = file.read(1)
        if not first_symb:
            a, g, p = random.randint(10**2, 10**3), random.randint(1, 10), random.randint(10**2, 10**3) # a - закртый ключ клиента
            A = g ** a % p # A - открытый ключ клиента
            file.write(f'{a}, {g}, {p}, {A}')
        else:
            file.seek(0)
            int_keys = file.read().split(',')
            a, g, p, A = int(int_keys[0]), int(int_keys[1]), int(int_keys[2]), int(int_keys[3])

    sock1.send(f"Public keys: {g}, {p}, {A}".encode())
    data = sock1.recv(1024).decode()
    num = re.findall(r"\d+", data)
    B = int(num[0])
    print(f'Public key: {B}')
    K = B ** a % p
    print('Encryption keys generate')

generating_keys(sock1)

def encryption(msg):
    byteMsg = ''
    for i in msg:
        byteMsg += chr(ord(i)+K)
    return byteMsg

def decryption(data):
    textData = ''
    for i in data:
        textData += chr(ord(i)-K)
    return textData

data = sock1.recv(1024).decode()
port2 = decryption(data)

def connect_chat(sock2):
    try:
        sock2.connect(('127.0.0.1', int(port2)))
    except ConnectionRefusedError as err:
        print(err)
        return False
connect_chat(sock2)

def listening(sock2):
    while True:
        data = sock2.recv(1024).decode()
        textData = decryption(data)

        print('\r\r'+f'Server: {textData}'+'\n'+'You: ', end='')


def sending(sock2):
    while True:
        msg = input()
        byteMsg = encryption(msg)
        sock2.send(byteMsg.encode())

threading.Thread(target=listening, args=(sock2, ), daemon=True).start()
sending(sock2)


