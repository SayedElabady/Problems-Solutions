package CoderByte

import java.util.*

fun StringChallenge(str: String): String {

    val tagsStack = Stack<String>()
    for (stringIterator in 0 until str.length) {
        if (str[stringIterator] == '<') {
            // Closing tag
            if (str[stringIterator + 1] == '/') {
                val tag: String = when {
                    str[stringIterator + 3] == '>' -> str.substring(stringIterator + 2, stringIterator + 3)
                    str[stringIterator + 4] == '>' -> str.substring(stringIterator + 2, stringIterator + 4)
                    else -> str.substring(stringIterator + 2, stringIterator + 5)
                }
                if (tagsStack.peek() != tag) {
                    return tagsStack.peek()
                }else {
                    tagsStack.pop()
                }
            } else {
                val tag: String = when {
                    str[stringIterator + 2] == '>' -> str.substring(stringIterator + 1, stringIterator + 2)
                    str[stringIterator + 3] == '>' -> str.substring(stringIterator + 1, stringIterator + 3)
                    else -> str.substring(stringIterator + 1, stringIterator + 4)
                }
                tagsStack.push(tag)
            }
        }
    }

    return "true"

}

fun main() {
    println(StringChallenge("<div>abc</div><p><em><i>test test test</i></em></p>"))
}