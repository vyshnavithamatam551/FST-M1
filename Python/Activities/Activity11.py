fruit_shop = {
    "apple": 20,
    "banana": 35,
    "orange": 10,
    "peaches": 15,
    "papaya": 5
}

key_to_check = input("What are you looking for? ").lower()

if(key_to_check in fruit_shop):
    print("Yes, this is available")
else:
    print("No, this is not available")