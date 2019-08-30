'''
Created on Aug 29, 2019

Write a program to convert Celsius to Fahrenheit temperature. The
formula is: f = 9/5c+32. The program should ask the user to enter a
temperature in Celsius, and then display the temperature converted to
Fahrenheit.

@author: Shannon Fisher
'''

celciusTemp = 0.0
fahrenheitTemp = 0.0

celciusTemp = float(eval(input('Please provide a temperature value in degrees Celcius: ')))

fahrenheitTemp = (9.0 / 5.0) * celciusTemp + 32.0

print('The temperature in Fahrenheit is', fahrenheitTemp, 'degrees.')