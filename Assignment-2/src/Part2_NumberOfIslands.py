from typing import List, Tuple, Set


def number_of_islands(island_map: List[List[bool]]) -> int:
    """
    [Graphs - Ex5] Exercise: Number of islands

    We are given a 2d grid map of '1's (land) and '0's (water). We define an island  as a body of land surrounded by
    water and is formed by connecting adjacent lands horizontally or vertically. We may assume all four edges of the
    grid are all surrounded by water. We need to write a method to find the number of islands in such a map.

    Write a method number_of_islands(bool[][] island_map) that returns the number of islands in a 2dmap. For this
    exercise you can think of a true in the island_map representing a '1' (land) and a false in the island_map
    representing a '0' (water).
    """
    counter: int = 0
    visited: Set[Tuple[int, int]] = set()

    for x in range(len(island_map)):
        for y in range(len(island_map[x])):
            if island_map[x][y] and (x, y) not in visited:
                counter += 1
                stack: List[Tuple[int, int]] = [(x, y)]

                while stack:
                    node = stack.pop()  # dfs
                    if node in visited:
                        continue
                    visited.add(node)
                    stack.extend(get_outward_edges(island_map, node))

    return counter


def get_outward_edges(island_map: List[List[bool]], vertex: Tuple[int, int]) -> List[Tuple[int, int]]:
    x, y = vertex
    output: List[Tuple[int, int]] = []

    for x1, y1 in [(x-1, y), (x+1, y), (x, y-1), (x, y+1)]:
        if x1 < 0 or y1 < 0:
            continue

        if x1 >= len(island_map) or y1 >= len(island_map[x1]):
            continue

        if island_map[x1][y1]:
            output.append((x1, y1))

    return output



def main():
    island_map1 = [[True, True, True, True, False],
                  [True, True, False, True, False],
                  [True, True, False, False, False],
                  [False, False, False, False, False]]
    assert number_of_islands(island_map1) == 1

    island_map2 = [[True, True, False, False, False],
                  [True, True, False, False, False],
                  [False, False, True, False, False],
                  [False, False, False, True, True]]
    assert number_of_islands(island_map2) == 3

if __name__ == "__main__":
    main()