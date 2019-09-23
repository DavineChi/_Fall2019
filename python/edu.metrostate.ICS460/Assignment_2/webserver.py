#import socket module
from socket import *
import sys # In order to terminate the program

serverPort = 7777
serverSocket = socket(AF_INET, SOCK_STREAM)

#Prepare a server socket
serverSocket.bind(('localhost', serverPort))
serverSocket.listen(1)

while True:
    
    #Establish the connection 
    print('Ready to serve...') 
    connectionSocket, addr = serverSocket.accept()
    
    try:
        message = connectionSocket.recv(2048)
        filename = message.split()[1]
        f = open(filename[1:])
        outputdata = f.read()
        
        #Send one HTTP header line into socket
        successResponse = 'HTTP/1.1 200 OK\nContent-Type: text/html\n\n'
        connectionSocket.send(successResponse.encode())
        
        #Send the content of the requested file to the client 
        for i in range(0, len(outputdata)):
            connectionSocket.send(outputdata[i].encode())
        
        connectionSocket.send("\r\n".encode())
        connectionSocket.close()
        
    except IOError:
        
        #Send response message for file not found
        failureResponse = 'HTTP/1.1 404 Not Found\nContent-Type: text/html\n\n'
        connectionSocket.send(failureResponse.encode())
        
        #Close client socket
        connectionSocket.close()
        
serverSocket.close()
sys.exit() #Terminate the program after sending the corresponding data