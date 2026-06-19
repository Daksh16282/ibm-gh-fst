inputList = input("Enter comma seperated list values : ").split(",");
length = len(inputList);
if(length<2):
    print("Enter two values at least");
else:
    print(inputList[0] == inputList[length-1]);
