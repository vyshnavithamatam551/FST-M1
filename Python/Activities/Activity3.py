
user1 = input("Player 1's name? ")
user2 = input("Player 2's name? ")


user1_answer = input(user1 + ", choose one from rock, paper or scissors? ").lower()
user2_answer = input(user2 + ", choose one from rock, paper or scissors? ").lower()


if user1_answer == user2_answer:
    print("It's a tie!")
elif user1_answer == 'rock':
    if user2_answer == 'scissors':
        print("Rock wins!")
    else:
        print("Paper wins!")
elif user1_answer == 'scissors':
    if user2_answer == 'paper':
        print("Scissors win!")
    else:
        print("Rock wins!")
elif user1_answer == 'paper':
    if user2_answer == 'rock':
        print("Paper wins!")
    else:
        print("Scissors win!")
else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")