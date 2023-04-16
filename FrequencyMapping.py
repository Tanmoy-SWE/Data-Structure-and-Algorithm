def convertToDict(list):
    newDict = {list[i]: 1 for i in range(0,len(list))}
    return newDict

def frequencyConversion(list):
    tempDict = convertToDict(list)
    print(tempDict)
    for i in range(0,len(list)):
        cnt = 1
        for j in range(i+1, len(list)):
            if list[i]==list[j]:
                cnt += 1
                list[j] = -1
        print(list[i],cnt)
        tempDict[list[i]] = cnt
    return tempDict

def duplicateCalculation(dict):
    for i in dict:
        if dict[i] > 1:
            print(i," has a frequency of", dict[i])


arr = [1,2,3,4,2,3,4,7,1,8,8,9,10,8,8,8,11,14,12]
frequencyDict = frequencyConversion(arr)
print(frequencyDict)
duplicateCalculation(frequencyDict)
