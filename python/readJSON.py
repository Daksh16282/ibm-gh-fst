import json

with open('currency.json','r') as myFile:
    data = myFile.read()

jsonData = json.loads(data)

# Provides a dictionary
print(jsonData)

# Print particular
print(f'usd : {str(jsonData['usd'])}')

import pandas as pd
df = pd.json_normalize(json.loads(data))
print(df)

# Method 2
# Keys will treated as indices and values are row values with column names as 0,1,2..
df = pd.read_json('currency.json',orient='index')
print(df)

