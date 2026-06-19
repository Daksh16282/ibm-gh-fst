# used to make request
import requests as req
# Scrap data from the webpage
from bs4 import BeautifulSoup

# Send get request to fetch data
response = req.get('https://training-support.net/webelements/tables');
webContent = response.content;

# create BeautifulSoup object
soup = BeautifulSoup(webContent,'html.parser');

# Target specified content, table is name of root element in html
table = soup.find('table');

for tr in table.find_all('tr'):    #Run over all rows
    cells = tr.find_all('th')      #Find all cells
    row = [i.text for i in cells]
    if(len(row)>0):
        print(row)   

# Format  in an appropriate table format,all passed arguments are element names in html
for tr in table.find_all('tr'):    #Run over all rows
    cells = tr.find_all('td')      #Find all cells
    row = [i.text for i in cells]  #iterate through cells,extract only table data, and store data in list
    if(len(row)>0):
        print(row)     #print each row

print("-----------------------------------------------------------------------------------")
        # Method 2

# Format  in an appropriate table format,all passed arguments are element names in html
for tr in table.find_all('tr'):    #Run over all rows
    cells = tr.find_all('td')      #Find all cells
    cellsH = tr.find_all('th')      #Find all header cells
    row = [i.text for i in cells]  #iterate through cells,extract only table data, and store data in list
    rowh = [i.text for i in cellsH]  #iterate through cells,extract only table data, and store data in list

    if(len(rowh)>0):
        print(rowh)     #print each row
    if(len(row)>0):
        print(row)     #print each row
