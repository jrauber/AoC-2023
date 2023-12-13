package de.aoc

class Day02() {
    class Game(val Id: Int, val R : Int, val G : Int, val B :Int)

    fun checkPart1(R: Int, G: Int, B: Int, game: List<Game>) : Int {

        var impossibleGames = game.filter { it.R > R || it.G > G || it.B > B }
                                    .map { it.Id }
                                    .distinctBy { it }

        return game.filterNot { impossibleGames.contains(it.Id) }
                            .map { it.Id }
                            .distinctBy { it }
                            .sumOf { it }

    }

    fun readLine(line: String): List<Day02.Game> {

        var gamePart = line.split(':')[0]
        var drawPart = line.split(':')[1]

        var id = gamePart.replace("Game ", "").toInt();

        var result = ArrayList<Game>();

        for (p in drawPart.split(';')) {

            var R = 0;
            var G = 0;
            var B = 0;

            for (pp in p.split(','))  {

                if (pp.contains("blue")) {
                    B = pp.replace(" blue","").trim().toInt()
                }

                if (pp.contains("red")) {
                    R = pp.replace(" red","").trim().toInt()
                }

                if (pp.contains("green")) {
                    G = pp.replace(" green","").trim().toInt()
                }
            }

            result.add(Game(id, R, G, B))
        }

        return result;
    }

    fun checkPart2(data: List<Game>): Int =
        data.groupBy { it.Id }.map { entry -> Game(entry.key, entry.value.maxOf { game: Game -> game.R },
                                                              entry.value.maxOf { game: Game -> game.G },
                                                              entry.value.maxOf { game: Game -> game.B }) }
                                                              .sumOf { it.R * it.G * it.B }
}