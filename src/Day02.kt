fun main() {

    fun compare(first: Char, second: Char): Int {
        return when (first - second) {
            0 -> 3
            1, -2 -> 0
            -1, 2 -> 6
            else -> throw IllegalArgumentException()
        } + when (second) {
            'X' -> 1
            'Y' -> 2
            'Z' -> 3
            else -> throw IllegalArgumentException()
        }
    }

    fun part1(input: List<String>): Int {
        return input.sumOf {
            compare(it[0] + ('X' - 'A'), it[2])
        }
    }

    fun points(first: Char, second: Char): Int {
        val play = when (first) {
            'A' -> 0
            'B' -> 1
            'C' -> 2
            else -> throw IllegalArgumentException()
        }

        val result = when (second) {
            'X' -> -1
            'Y' -> 0
            'Z' -> 1
            else -> throw IllegalArgumentException()
        }

        val answer = (play + result + 3) % 3

        return (result + 1) * 3 + (answer + 1)

    }

    fun part2(input: List<String>): Int {
        return input.sumOf {
            points(it[0], it[2])
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    println(part1(testInput))
    check(part1(testInput) == 15)
    val input = readInput("Day02")
    println(part1(input))

    println(part2(testInput))
    check(part2(testInput) == 12)
    println(part2(input))
}

