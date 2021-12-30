class Solution68B {

    fun findAllRecipes(recipes: Array<String>, ingredients: List<List<String>>, supplies: Array<String>): List<String> {
        val made = HashSet<String>()
        val notMade = HashSet<String>()
        val processing = HashSet<String>()
        val sup = HashSet<String>()
        supplies.forEach { sup.add(it) }

        recipes.forEachIndexed { index, it ->
            canMake(index, recipes, ingredients, sup, made, notMade,processing)
        }
        return made.toList()
    }

    fun canMake(
        index: Int,
        recipes: Array<String>,
        ingredients: List<List<String>>,
        sup: HashSet<String>,
        made: HashSet<String>,
        notMade: HashSet<String>,
        processing: HashSet<String>
    ): Boolean {
        var answer = true
        val recipe = recipes[index]
        if (made.contains(recipe)) return true
        if (notMade.contains(recipe)) return false
        processing.add(recipe)
        ingredients[index].forEachIndexed { current, it ->
            if (recipes.contains(it)) {
                if (notMade.contains(it) || processing.contains(it)) answer = false
                else if (!made.contains(it))
                    answer = answer.and(canMake(recipes.indexOf(it), recipes, ingredients, sup, made, notMade, processing))
            } else {
                if (!sup.contains(it)) answer = false
            }
        }
        processing.remove(recipe)
        if (answer) {
            made.add(recipe)
        } else {
            notMade.add(recipe)
        }
        return answer
    }

}

fun main() {
    val s = Solution68B()
    s.findAllRecipes(
        arrayOf("bread", "sandwich", "burger"),
        listOf(listOf("sandwich", "flour"), listOf("bread", "meat"), listOf("sandwich", "meat", "bread")),
        arrayOf("yeast", "flour", "meat")
    )
}