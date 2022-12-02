import java.util.TreeSet

fun main() {


    fun parseInput(input: List<String>): TreeSet<Int> {
        val elfs = sortedSetOf<Int>(compareByDescending { it })
        var sum = 0
        for (s in input) {
            if (s.isEmpty()) {
                elfs.add(sum)
                sum = 0
            } else {
                sum += s.toInt()
            }
        }
        elfs.add(sum)
        return elfs
    }

    fun part1(input: List<String>): Int {
        return parseInput(input).first()
    }

    fun part2(input: List<String>): Int {
        return parseInput(input).take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    println(part1(testInput))
    check(part1(testInput) == 24000)
    val input = readInput("Day01")
    println(part1(input))

    println(part2(testInput))
    check(part2(testInput) == 45000)
    println(part2(input))

    println(parseInput(testInput))
}
