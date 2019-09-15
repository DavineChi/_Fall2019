'''
Created on Aug 29, 2019

Date printer
Write a program that reads a string from the user containing a date in
the form mm/dd/yyyy. It should print the date in the form month dd,
yyyy.

@author: Shannon Fisher
'''
from os.path import sep
calendar_months = ['January',
                   'February',
                   'March',
                   'April',
                   'May',
                   'June',
                   'July',
                   'August',
                   'September',
                   'October',
                   'November',
                   'December']

date = str(input('Enter a date (mm/dd/yyyy): '))

month_part = int(date[0:2])
day_part = date[3:5]
year_part = date[6:10]

print('The date is ', calendar_months[month_part - 1], ' ', day_part, ', ', year_part, sep="")