'''
Created on Aug 29, 2019

Design a program that asks the user to enter a series of 20 numbers. The
program should store the numbers in a list and then display the
following data:
The lowest number in the list
The highest number in the list
The total of the numbers in the list
The average of the numbers in the list

@author: Shannon Fisher
'''
numbers = list()
sum = 0.0

for i in range(6):
    num = float(input('Enter a number: '))
    numbers.append(num)

numbers.sort(key=None, reverse=False)

print('The smallest number is', numbers[0])
print('The largest number is', numbers[-1])

for number in range(len(numbers)):
    sum = sum + numbers[number]

print('The sum of the list is', sum)
print('The average of the list is', (sum / len(numbers)))