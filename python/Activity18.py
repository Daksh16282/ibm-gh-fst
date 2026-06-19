import pandas as pd

data = pd.read_csv('admins.csv');
print(data["Usernames"]);
print("---------------------------------------");
print(data["Usernames"][1]+"  "+data["Passwords"][1]);
print("---------------------------------------");

# //Use inplace=True to make changes in original data
# Note:- Lower alphabets come after  Uppercase in sorting
print(data.sort_values("Usernames"))
print("---------------------------------------")
print(data.sort_values("Passwords",ascending=False))


