class KeyboardLocks {
    val solution = mutableSetOf<String>()
    fun getPossibleVariations(keyboard: List<List<Char>>, reportedPin: String): List<String> {
        val possibleNodes = mutableListOf<List<Char>>()
        reportedPin.forEach {
            val currentAdjacent = mutableListOf(it)
            currentAdjacent.addAll(getPossibleAdjacentNodes(keyboard, it))
            possibleNodes.add(currentAdjacent)
        }
        findPossibleVariations(possibleNodes, reportedPin.length,  "")
        return solution.toList()
    }

    private fun getPossibleAdjacentNodes(keyboard: List<List<Char>>, node: Char): List<Char> {
        val result = mutableListOf<Char>()
        keyboard.forEachIndexed { rowsIndex, row ->
            row.forEachIndexed { charsIndex, char ->
                if (char == node) {
                    if (rowsIndex > 0) result.add(keyboard[rowsIndex - 1][charsIndex])
                    if (rowsIndex < keyboard.size - 1) result.add(keyboard[rowsIndex + 1][charsIndex])
                    if (charsIndex > 0) result.add(keyboard[rowsIndex][charsIndex - 1])
                    if (charsIndex < row.size - 1) result.add(keyboard[rowsIndex][charsIndex + 1])
                }
            }
        }
        return result
    }

    private fun findPossibleVariations(
        nodes: List<List<Char>>,
        neighbourIndex: Int,
        currentString: String
    ) {
        if (currentString.length == nodes.size) {
            solution.add(currentString)
            return
        }
        nodes[neighbourIndex].forEach {
            findPossibleVariations(nodes, neighbourIndex + 1, currentString + it)
        }
    }
}

fun main() {
    val keyboardFinder = KeyboardLocks()

    val solution = keyboardFinder.getPossibleVariations(
        listOf(
            listOf('1', '2', '3'),
            listOf('4', '5', '6'),
            listOf('7', '8', '9'),
            listOf('*', '0', '#')
        ),
        "13"
    )
    solution.forEach { print("$it ") }

}