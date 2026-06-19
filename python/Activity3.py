options = ("Rock","Paper","Scissor");
player1 = input("Player 1, Enter one out of : Rock,Paper,Scissor -> ");
if(player1 not in options):
    print("Invalid Input, Restart to play again")
    raise SystemExit
player2 = input("Player 2, Enter one out of : Rock,Paper,Scissor -> ");
if(player2 not in options):
    print("Invalid Input, Restart to play again")
    raise SystemExit

if(player1 == player2):
    print("Match Draw")

if(player1=="Rock" and player2 == "Scissor"):
    print("Player 1 Win")
if(player1=="Paper" and player2 == "Rock"):
    print("Player 1 Win")
if(player1=="Scissor" and player2 == "Paper"):
    print("Player 1 Win")

if(player2=="Rock" and player1 == "Scissor"):
    print("Player 2 Win")
if(player2=="Paper" and player1 == "Rock"):
    print("Player 2 Win")
if(player2=="Scissor" and player1 == "Paper"):
    print("Player 2 Win")
