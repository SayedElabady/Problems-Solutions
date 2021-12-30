class Solution843 {
    fun findSecretWord(wordList: Array<String>, master: Master) {
        val zeroMatchesCount = IntArray(wordList.size){ -1 }
        for(wordToCalculateIndex in wordList.indices){
            var wordNonZeroMatches = 0
            for(secondWordIndex in wordList.indices){
                if(wordToCalculateIndex != secondWordIndex && calculateMatch(wordList[wordToCalculateIndex], wordList[secondWordIndex]) == 0){
                    wordNonZeroMatches++
                }
            }
            zeroMatchesCount[wordNonZeroMatches]=wordToCalculateIndex
        }

        val leastZeroMatches = zeroMatchesCount.first{ it != -1 }
        var matches = master.guess(wordList[leastZeroMatches])
       // wordList.removeAt(leastZeroMatches)
        var length = wordList.size-1
        for(iteration in 0 until 9){
            if(matches==6) return
           for(index in 0 until length){
                if(calculateMatch(wordList[length], wordList[index]) != matches){
                    length--
                    wordList[index] = wordList[length]
                }
            }

            matches = master.guess(wordList[length])
        }

    }

    fun calculateMatch(firstWord: String, secondWord: String) : Int{
        var numberOfMatches = 0

        for(index in firstWord.indices){
            if(firstWord.get(index) == secondWord[index]) numberOfMatches++
        }

        return numberOfMatches
    }
}
class Master{
    fun guess(word:String) : Int{return 0}
}