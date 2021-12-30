class Solution721 {
//    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
//        val ref = HashMap<String, MutableList<Int>>()
//        val graph = Array(accounts.size){mutableListOf<Int>()}
//        accounts.forEachIndexed{ index, it ->
//            for(iterator in 1 until it.size){
//                if(ref.contains(it[iterator])){
//                    val last = ref[it[iterator]]?.last()?:0
//                    ref[it[iterator]]?.add(index)
//                    graph[last].add(index)
//                    graph[index].add(last)
//                }else{
//                    ref[it[iterator]] = mutableListOf(index)
//                }
//            }
//        }
//        val visited = BooleanArray(accounts.size)
//        val answer = mutableListOf<List<String>>()
//        graph.forEachIndexed{ index, it ->
//            if(!visited[index] && it.isNotEmpty()){
//                val elements = mutableListOf<String>()
//                elements.add(accounts[index][0])
//                elements.addAll(dfs(graph,index, accounts, visited))
//                answer.add(elements)
//            }
//        }
//        for (index in accounts.indices){
//            if(!visited[index]) answer.add(accounts[index])
//        }
//        return answer
//    }
//
//    fun dfs(graph: Array<MutableList<Int>>, index: Int, accounts: List<List<String>>, visited: BooleanArray): List<String>{
//        visited[index] = true
//        val items = accounts[index].subList(1, accounts[index].size).toHashSet()
//
//        for(target in graph[index].indices){
//            if(!visited[graph[index][target]]){
//                items.addAll(dfs(graph, graph[index][target], accounts, visited ))
//            }
//        }
//        return items.toList()
//
//    }


    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {

        val graph = HashMap<String, MutableList<String>>()
        accounts.forEachIndexed { index, it ->
            val firstEmail = it[1]
            for (iterator in 2 until it.size) {
                if (!graph.contains(firstEmail)) {
                    graph[firstEmail] = mutableListOf<String>()
                }
                graph[firstEmail]?.add(it[iterator])
                if (!graph.contains(it[iterator])) {
                    graph[it[iterator]] = mutableListOf<String>()
                }
                graph[it[iterator]]?.add(firstEmail)

            }
        }
        val visited = hashSetOf<String>()
        val answer = mutableListOf<List<String>>()
        accounts.forEach {
            if (!visited.contains(it[1])) {
                //mutableListOf(it[1])
                val connectedList: MutableList<String> = dfs(graph, it[1], visited, mutableListOf<String>())
                connectedList.sort()
                val account = mutableListOf(it[0])
                account.addAll(connectedList)
                answer.add(account)
            }
        }
        return answer
    }

    fun dfs(
        graph: HashMap<String, MutableList<String>>,
        word: String,
        visited: HashSet<String>,
        connectedList: MutableList<String>
    ): MutableList<String> {
        visited.add(word)
        val items = graph[word] ?: listOf<String>()
        connectedList.add(word)

        for (target in items.indices) {
            if (!visited.contains(items[target])) {
                dfs(graph, items[target], visited, connectedList)
            }
        }
        return connectedList
    }

}

fun main() {
    val s = Solution721()

    s.accountsMerge(listOf(listOf("John","johnsmith@mail.com","john_newyork@mail.com"), listOf("John","johnsmith@mail.com","john00@mail.com"),
        listOf("Mary","mary@mail.com"), listOf("John","johnnybravo@mail.com")))
//    s.accountsMerge(
//        listOf(
//            listOf("Alex", "Alex5@m.co", "Alex4@m.co", "Alex0@m.co"),
//            listOf("Ethan", "Ethan3@m.co", "Ethan3@m.co", "Ethan0@m.co"),
//            listOf("Kevin", "Kevin4@m.co", "Kevin2@m.co", "Kevin2@m.co"),
//            listOf("Gabe", "Gabe3@m.co", "Gabe4@m.co", "Gabe2@m.co"),
//            listOf("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe2@m.co")
//        )
//    )
}