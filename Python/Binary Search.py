Array = [1, 4, 6, 9, 12, 78, 107, 200]
searchitem = int(input("Enter Search Item"))
x = 0
low = 1
high = len(Array)
while (high >= low) and (x == 0):
    middle = int((high + low)/2)
    if Array[middle] == searchitem:
        x = middle
    elif searchitem > Array[middle]:
        low = middle+1
    else:
        high = middle -1

print (x+1)
    
