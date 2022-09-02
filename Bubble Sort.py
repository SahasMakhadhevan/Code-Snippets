Array = [8, 7, 5, 3, 9, 6, 8, 4]
temp = 0
i = 0
j = 0
for i in range (0,7):
	for j in range (0,7):
		if int(Array[j]) > int(Array[j+1]):
			temp = Array[j]
			Array[j] = Array[j+1]
			Array[j+1] = temp


print (Array)

			
	
