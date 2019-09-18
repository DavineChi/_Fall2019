#import socket module
from socket import *
import sys # In order to terminate the program

serverPort = 12000
serverSocket = socket(AF_INET, SOCK_STREAM) 

#Prepare a server socket
serverSocket.bind(('', serverPort))
serverSocket.listen(1)

while True:
    
    #Establish the connection 
    print('Ready to serve...') 
    connectionSocket, addr = serverSocket.accept()
    
    try:
        message = 'http://localhost' + serverPort
        filename = message.split()[1]
        f = open(filename[1:])
        outputdata = 'Hello World!'
        #Send one HTTP header line into socket
        
        #Fill in start
        headers = {}
        headers['Content-Type'] = 'text/html'
        #Fill in end
        
        #Send the content of the requested file to the client 
        for i in range(0, len(outputdata)):
            connectionSocket.send(outputdata[i].encode())
        
        connectionSocket.send("\r\n".encode())
        connectionSocket.close() 
        
    except IOError:
        
        #Send response message for file not found
        #Fill in start
        #Fill in end
        
        #Close client socket
        #Fill in start
        serverSocket.close()
        #Fill in end
        
serverSocket.close()
sys.exit() #Terminate the program after sending the corresponding data