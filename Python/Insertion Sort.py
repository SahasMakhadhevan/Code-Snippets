Array = [2, 7, 5, 24, 126, 15]
i = 0
current = 0
j = 0
for i in range (0, len(Array)):
    current = Array[i]
    j = i-1
    while j >= 0 and Array[j] > current:
        Array[j+1] = Array[j]
        j=j-1

    Array[j+1] = current
    print (Array)

print (Array)

        
