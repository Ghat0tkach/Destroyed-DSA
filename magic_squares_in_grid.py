{"def countMagicSquaresInside(grid):
    count = 0
    for i in range(len(grid) - 2):
        for j in range(len(grid[0]) - 2):
            magic_square = [0] * 9
            for x in range(3):
                for y in range(3):
                    magic_square[grid[i + x][j + y] - 1] += 1
            if 5 not in magic_square:
                count += 1
    return count
}
