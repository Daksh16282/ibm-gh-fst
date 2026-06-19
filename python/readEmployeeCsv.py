import pandas
dataframe = pandas.read_csv('employees.csv')
print(dataframe)
# Accessing Value
print(dataframe["Hire Date"][2])