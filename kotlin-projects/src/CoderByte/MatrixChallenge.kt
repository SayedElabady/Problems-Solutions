package CoderByte

    val visitedNodes = Array(4) { arrayOf(false, false, false, false) }

    fun MatrixChallenge(strArr: Array<String>): String {
        val matrixSepratedWords = strArr[0].split(',')
        val charMatrix = Array(4) { matrixSepratedWords[it] }
        val notFoundWords = mutableListOf<String>()
        val constructed = mutableListOf<String>()
        val requiredWordsForSearch = strArr[1].split(',')
        outerFor@ for (requiredWordForSearch in requiredWordsForSearch) {
            for (arrayIndex in 0 until charMatrix.size) {
                for (wordIndex in 0 until charMatrix[arrayIndex].length) {
                    if (charMatrix[arrayIndex][wordIndex] == requiredWordForSearch[0]) {
                        visitedNodes.run {
                            this.fill(arrayOf(false, false, false, false))
                        }
                        if (checkIfWordCanBeFound(requiredWordForSearch, charMatrix, 0, arrayIndex, wordIndex)) {
                            constructed.add(requiredWordForSearch)
                            continue@outerFor
                        }
                    }
                }
            }
        }
        requiredWordsForSearch.forEachIndexed { index, word ->
            if(constructed.find { word == it} == null)
                notFoundWords.add(word)
        }
        return if (notFoundWords.isNotEmpty()) {
            notFoundWords.joinToString(separator = ",")
        } else "true"
    }

    fun checkIfWordCanBeFound(word: String, matrix: Array<String>, wordIndex: Int, xIndex: Int, yIndex: Int): Boolean {
        if (wordIndex == word.length) return true
        if (xIndex == 4 || yIndex == 4 || yIndex < 0 || xIndex < 0 || matrix[xIndex][yIndex] != word[wordIndex]) return false
        if (visitedNodes[xIndex][yIndex]) return false
        visitedNodes[xIndex][yIndex] = true
        return checkIfWordCanBeFound(
            word, matrix, wordIndex + 1, xIndex + 1, yIndex
        ) || checkIfWordCanBeFound(
            word, matrix, wordIndex + 1, xIndex - 1, yIndex
        ) || checkIfWordCanBeFound(
            word, matrix, wordIndex + 1, xIndex + 1, yIndex + 1
        ) || checkIfWordCanBeFound(
            word, matrix, wordIndex + 1, xIndex + 1, yIndex - 1
        ) || checkIfWordCanBeFound(
            word, matrix, wordIndex + 1, xIndex - 1, yIndex - 1
        ) || checkIfWordCanBeFound(
            word, matrix, wordIndex + 1, xIndex - 1, yIndex + 1
        ) || checkIfWordCanBeFound(
            word, matrix, wordIndex + 1, xIndex, yIndex + 1
        ) || checkIfWordCanBeFound(
            word, matrix, wordIndex + 1, xIndex, yIndex - 1
        )

    }


fun main() {
    println(MatrixChallenge(arrayOf("aaey, rrum, tgmn, ball", "all,ball,mur,raeymnl,rumk,tall,true,trum,yes")))
}