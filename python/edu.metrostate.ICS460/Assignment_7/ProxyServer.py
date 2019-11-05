from socket import *
import sys

if len(sys.argv) <= 1:
    print('Usage : "python ProxyServer.py server_ip"\n[server_ip] : The IP Address Of Proxy Server')
    sys.exit(2)

# Create a server socket, bind it to a port and start listening
tcpServerSocket = socket(AF_INET, SOCK_STREAM)

# Fill in start.
serverPort = 7001
tcpServerSocket.bind((sys.argv[1], serverPort))
tcpServerSocket.listen(1)
# Fill in end.

while 1:
    # Start receiving data from the client
    print('Ready to serve...')
    tcpClientSocket, addr = tcpServerSocket.accept()
    print('Received a connection from:', addr)
    # Fill in start.
    message = tcpClientSocket.recv(2048)
    # Fill in end.
    print(message)
    
    # Extract the filename from the given message
    print(message.split()[1])
    filename = message.split()[1].partition("/")[2]
    print(filename)
    fileExist = "false"
    fileToUse = "/" + filename
    print(fileToUse)
    
    try:
        # Check whether the file exist in the cache
        file = open(fileToUse[1:], "r")
        outputdata = file.readlines()
        fileExist = "true"
        
        # ProxyServer finds a cache hit and generates a response message
        tcpClientSocket.send("HTTP/1.1 200 OK\r\n")
        tcpClientSocket.send("Content-Type:text/html\r\n")
        
        # Fill in start.
        # Fill in end.
        
        print('Read from cache')
        
    # Error handling for file not found in cache
    except IOError:
        if fileExist == "false":
            # Create a socket on the proxyserver
            # Fill in start.
            proxySocket = socket(AF_INET, SOCK_STREAM)
            # Fill in end.
            hostn = filename.replace("www.", "", 1)
            print(hostn)
            
            try:
                # Connect to the socket on port 80
                # Fill in start.
                proxySocket.connect((hostn, 80))
                # Fill in end.
                
                # Create a temporary file on this socket and ask port 80 for the file requested by the client
                fileObject = proxySocket.makefile('r', 0)
                fileObject.write("GET " + "http://" + filename + "HTTP/1.1\r\n")
                
                # Read the response into buffer
                # Fill in start.
                buffer = fileObject.readlines()
                # Fill in end.
                
                # Create a new file in the cache for the requested file.
                # Also send the response in the buffer to client socket
                # and the corresponding file in the cache
                tempFile = open("./" + filename, "wb")
                
                # Fill in start.
                for line in buffer:
                    tempFile.write(line)
                    tcpClientSocket.send(line)
                # Fill in end.
                
            except:
                print("Illegal request.")
            
        else:
            # HTTP response message for file not found
            # Fill in start.
            tcpClientSocket.send("HTTP/1.1 404 Not Found\r\n")
            tcpClientSocket.send("Content-Type: text/html\r\n")
            # Fill in end.
            
    tcpClientSocket.close()
    
# Fill in start.
# Close the server socket
tcpServerSocket.close()
# Fill in end.