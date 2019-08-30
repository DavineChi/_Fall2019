'''
Created on Aug 29, 2019

Name and email address
Write a program that keeps names and email addresses in a dictionary a
key-value pairs. The program should display a menu that lets the user
look up a person's email address, add a new name and email address,
change an existing email address and delete an existing name and email
address. The program should pickle the dictionary and save it to a file
when the user exits the program. Each time the program starts it should
retrieve the dictionary from the file and unpickle it.

@author: Shannon Fisher
'''
import pickle

class Map:
    
    list = dict()
    
    def __init__(self):
        list = {"Shannon Fisher":"shannon.fisher@daikinapplied.com",
                "Thomas Amundson":"thomas.amundson@daikinapplied.com"}
    
    def create(self, key, value):
        list[key] = value
    
    def retrieve(self, name):
        return list[name]
    
    def update(self, key, value):
        list[key] = value
    
    def delete(self, key):
        list.pop(key)

def main():
    
    selection = ""
    
    '''print("\n" * 60)'''
    print("Welcome.")
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

if __name__ == "__main__":
    main()