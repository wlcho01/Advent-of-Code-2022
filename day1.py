elves = open("Day1_1.txt").read().split("\n\n")
calories = [sum(map(int, elf.split())) for elf in elves]
print(max(calories), sum(sorted(calories)[-3:]))