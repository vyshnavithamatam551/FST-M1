
numList = list(input("Enter a sequence of comma separated values : ").split(","))
print("Given list is ", numList)

firstElement = numList[0]

lastElement = numList[-1]

# Check if first and last element are equal
if (firstElement == lastElement):
    print(True)
else:
    print(False)