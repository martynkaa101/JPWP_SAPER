import socket
import json

HOST = "172.104.229.108"
PORT = 9001

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect((HOST, PORT))

    info = json.dumps({"username": "myname"})
    s.sendall(str.encode(info))
    data = s.recv(2048)
    msg = data.decode()
    json_data = json.loads(msg)
    msg = json.dumps({"request": "ALL_ROOMS"})
    s.sendall(str.encode(msg))
    response = s.recv(2048).decode()
    msg = json.dumps({"request": "CREATE_ROOM", "data": "room1"})
    s.sendall(str.encode(msg))
    response = s.recv(2048).decode()
    print(response)

    s.close()

    