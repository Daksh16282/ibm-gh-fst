# import pandas
import pandas

# Structure our data as a dictionary
data = {
  "Vehicle Type": ["Car", "Car", "Bike"],
  "Manufacturer": ["Maruti", "Toyota", "Royal Enfield"],
  "Model": ["Swift", "Corolla", "Thunderbird"]
}

# Create a new DataFrame using the data
dataframe = pandas.DataFrame(data)

writer = pandas.ExcelWriter('vehiclesExcel.xlsx')

dataframe.to_excel(writer,sheet_name="Vehicle Data",index=False)

writer.close();

# Reading the created data
excelData = pandas.read_excel('vehiclesExcel.xlsx')
print(excelData)