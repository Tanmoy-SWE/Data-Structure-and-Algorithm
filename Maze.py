# Dictionary for all the rooms that links the roms to each other
rooms = {
    'Glacial Pool': {'East': 'Room of Cinders'},
    'Room of Cinders': {'West': 'Glacial Pool', 'North': 'Armory', 'South': 'Library', 'East': 'Tar Pits'},
    'Armory': {'South': 'Room of Cinders', 'East': 'Dungeon'},
    'Dungeon': {'West': 'Armory'},
    'Library': {'North': 'Room of Cinders', 'East': 'Mouth of the Pit'},
    'Mouth of the Pit': {'West': 'Library'},
    'Tar Pits': {'West': 'Room of Cinders', 'North': 'The Aery'},
    'The Aery': {'South': 'Tar Pits'},
}

items = {
    'Library': 'Mystic Tome',
    'Room of Cinders': 'Fireball Spell',
    'Tar Pits': 'Earthquake Spell',
    'The Aery': 'Gale Fury Spell',
    'Glacial Pool': 'Frostbite Spell',
    'Armory': 'Rod of Quadruple Casting',
    'Dungeon': 'Elemental Golem',

}

# Create a Menu that explains valid commands
print('Get the Golem Text Adventure Game')
print('You must collect 6 items to defeat the Golem and save your partner')
print('Move Commands: East, West, North, South, Exit')
print("Add to Inventory: get 'item name'")

# Start in Mouth of the Pit
current_room = 'Mouth of the Pit'
start = current_room
move = ' '
# while loop for moving rooms
def player():
    print('----------------------')
    print('You are in the {}'.format(current_room))

flag = False
cnt = 0
list = []


def unique(list1):
    # intilize a null list
    unique_list = []

    # traverse for all elements
    for x in list1:
        # check if exists in unique_list or not
        if x not in unique_list:
            unique_list.append(x)
    # print list
    return len(unique_list)


item = ''
def getItem():
    inp = input("Get Item : ")
    return inp
powers = []
while current_room != 'Exit':
    move = input('Enter your move: ')
    move = move.lower()
    for i, j in rooms.items():
        if current_room == i:
            for key in j:
                keyNew = key
                keyNew = keyNew.lower()
                if move == keyNew:
                    current_room = j[key]
                    if start == current_room :
                        pass
                    else :
                        list.append(current_room)
                    player()
                    for t in items :
                           if t == current_room:
                             powers.append(items[t])
                             print("You see a/an "+items[t])
                             print("----------------------")
                             break

                    if current_room == "Dungeon" :
                        print("NOM NOM...GAME OVER!")
                        exit(1)

                    if items[t]==getItem():
                        cnt += 1
                        print("You've got currently", unique(list), "power(s).")
                    else :
                        print("Nope! You can\'t do that!")
                    print("Invertory :", end='')
                    print(powers)


                    power = unique(list)
                    if power == 6:
                        print("\nCongratulations! You have collected all items and defeated the dragon!\n")
                        print("Thanks for playing the game. Hope you enjoyed it. \n")
                        exit(1)

                    move = ''
                else:
                    continue




