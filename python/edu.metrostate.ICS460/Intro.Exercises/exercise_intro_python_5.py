'''
Created on Aug 29, 2019

Name and email address
Write a program that keeps names and email addresses in a dictionary of
key-value pairs. The program should display a menu that lets the user
look up a person's email address, add a new name and email address,
change an existing email address and delete an existing name and email
address. The program should pickle the dictionary and save it to a file
when the user exits the program. Each time the program starts it should
retrieve the dictionary from the file and unpickle it.

@author: Shannon Fisher
'''
import os
import pickle

SAVE_FILE = "DATASTORE"

class Map:
    
    list = dict()
    
    def create(self, key, value):
        self.list[key] = value
    
    def retrieve(self, key):
        return self.list.get(key)
    
    def update(self, key, value):
        self.list[key] = value
    
    def delete(self, key):
        del self.list[key]

def main():
    
    maplist = Map()
    selection = ""
    exit = False
    
    print("Welcome.")
    
    
    if os.path.exists(SAVE_FILE):
        file = open(SAVE_FILE, "rb")
        maplist.list = pickle.load(file)
        file.close()
    
    while not exit:
        
        print()
        print("Please select from the following options:")
        print()
        print(" [1] Create")
        print(" [2] Retrieve")
        print(" [3] Update")
        print(" [4] Delete")
        print(" -------------")
        print(" [0] Exit")
        print()
        
        selection = input(" > ")
        
        if selection == '0':
            file = open(SAVE_FILE, "wb")
            pickle.dump(maplist.list, file)
            file.close()
            exit = True
            break
        
        name = input(" > Enter a name: ")
        
        if selection == '1':
            email_create = input(" > Enter an email address: ")
            maplist.create(name, email_create)
        
        if selection == '2':
            print(maplist.retrieve(name))
        
        if selection == '3':
            email_update = input(" > Enter an email address: ")
            print(maplist.update(name, email_update))
        
        if selection == '4':
            print(maplist.delete(name))
    
    print()
    print("Goodbye.")
    
if __name__ == "__main__":
    main()