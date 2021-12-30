class Solution43 {
    fun multiply(num1: String, num2: String): String {
        val stringsToSum = mutableListOf<String>()
        val longerNumb = if(num1.length > num2.length) num1 else num2
        val shorterNumb = if(num1.length > num2.length) num2 else num1
        shorterNumb.forEachIndexed{index, it->
            var multipliedString = multiplyIndividual(it, longerNumb)
            for(index1 in 1 until (shorterNumb.length - index) ) multipliedString+='0'
            stringsToSum.add(multipliedString)
        }
        var answer = "0"
        stringsToSum.forEach{
            answer = sumToNumbers(answer, it)
        }
        var indexWithoutZeroes = 0
        while (answer[indexWithoutZeroes]=='0')indexWithoutZeroes++
        return answer.substring(indexWithoutZeroes)
    }

    fun multiplyIndividual(individualNumber: Char, number: String): String{
        var reminder = 0
        val convertedNumber = individualNumber.toString().toInt()
        val answer = StringBuilder()
        for(index in number.length-1 downTo 0){
            val dumpMul = (number[index].toString().toInt() * convertedNumber) + reminder
            answer.append((dumpMul%10))
            reminder = dumpMul / 10
        }
        if(reminder!= 0) answer.append(reminder)
        return answer.toString().reversed()
    }

    fun sumToNumbers(number1:String, number2: String): String{
        var firstIterator = number1.length - 1
        var secondIterator = number2.length - 1
        var reminder = 0
        val answer = StringBuilder()
        while(firstIterator >= 0 || secondIterator >= 0){
            when {
                firstIterator < 0 -> while(secondIterator>= 0){
                    val sum = number2[secondIterator--].toString().toInt() + reminder
                    answer.append(sum%10)
                    reminder = sum /10
                }
                secondIterator < 0 -> while(firstIterator>= 0){
                    val sum = number1[firstIterator--].toString().toInt() + reminder
                    answer.append(sum%10)
                    reminder = sum /10
                }
                else -> {
                    val sum = number1[firstIterator--].toString().toInt() + number2[secondIterator--].toString().toInt()  + reminder
                    answer.append(sum%10)
                    reminder = sum /10
                }
            }
        }
        if(reminder!= 0) answer.append(reminder)
        return answer.toString().reversed()
    }

}

fun main() {
    val s = Solution43()
    s.multiply("123","456")
}