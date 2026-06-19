size = int(input("Enter list size : "))
myList = [];
for x in range(0,size):
    value = int(input(f"Enter value {x+1} : "));
    myList.append(value);

listSum = 0;
for val in myList:
    listSum+=val;

print(f"Sum of list values is : {listSum}")