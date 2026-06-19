import pandas as pd
import xml.etree.ElementTree as ET

df = pd.DataFrame(
    [[1.3, 1.4, 5.2],
     [2.6, 1.4, 4.6],
     [2.1, 5.6, 4.6]],
    columns=['A', 'B', 'C'],
    index=['X', 'Y', 'Z']
)

root = ET.Element("data")

for idx, row in df.iterrows():
    row_elem = ET.SubElement(root, idx)
    for col in df.columns:
        col_elem = ET.SubElement(row_elem, col)
        col_elem.text = str(row[col])

ET.indent(root, space="  ")

tree = ET.ElementTree(root)
tree.write("coordinatesCT.xml", encoding="utf-8", xml_declaration=True)