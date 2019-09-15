'''
Created on Aug 29, 2019

In a program write a function that accepts two arguments: a list, and a
number ??. Assume that the list contains numbers. The function should
display all of the numbers in the list that are greater than the number
??.

@author: Shannon Fisher
'''

def find_larger_in_list(list, limit):
    for i in range(len(list)):
        if list[i] > limit:
            print(list[i])

item_list = list()

for i in range(5):
    num = float(input('Enter a number: '))
    item_list.append(num)

number = float(eval(input('Find items in the list larger than (enter a number): ')))

find_larger_in_list(item_list, number)