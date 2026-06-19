import pandas as pd

data = [[1.2,3.4,6.9],[8.2,2.5,9.3],[9.0,3.4,5.6]];

df = pd.DataFrame(data=data,columns=["X","Y","Z"]);
df.to_xml('coordinates.xml',index=False)

df2 = pd.read_xml('coordinates.xml');
print(df2)