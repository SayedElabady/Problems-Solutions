fun main() {
    val sol = Solution12()
    sol.pathInZigZagTree(14).forEach { println(it) }

}

class Solution12 {
    val list = mutableListOf<Pair<Int, Int>>()
    fun pathInZigZagTree(label: Int): List<Int> {
        generate()
        var leafLevel = 0
        var valueRank = 0
        for (i in 0 until list.size)
            if (label <= list[i].second && label >= list[i].first) {
                leafLevel = i
                valueRank = getRank(label, leafLevel)
                break
            }


        return getLevels(leafLevel, valueRank)
    }

    fun getLevels(initialLevel: Int, initialRank: Int): List<Int> {
        var ans = mutableListOf<Int>()
        var currentRank = initialRank
        for (level in initialLevel downTo 1) {
            if (level % 2 == 0) {
                for (i in list[level].second downTo list[level].first step 1) {
                    if (currentRank == i - list[level].first) {
                        currentRank = (i - list[level].first) / 2
                        ans.add(i)
                        break
                    }
                }
            } else {
                for (i in list[level].first..list[level].second) {
                    if (currentRank == list[level].second - i) {
                        currentRank = (list[level].second - i) / 2
                        ans.add(i)
                        break
                    }
                }
            }
        }
        ans.add(1)
        return ans.reversed()
    }

    private fun getRank(label: Int, leafLevel: Int): Int {
        if (leafLevel % 2 == 0) {
            for (i in list[leafLevel].second downTo list[leafLevel].first step 1) {
                if (i == label)
                    return i - list[leafLevel].first
            }
        } else {
            for (i in list[leafLevel].first..list[leafLevel].second) {
                if (i == label)
                    return list[leafLevel].second - i
            }
        }
        return 0
    }

    fun generate() {
        var mult = 1
        var sum = 1
        list.add(Pair(1, 1))
        while (sum <= 1000000) {
            mult *= 2
            list.add(Pair(sum + 1, sum + mult))
            sum += mult
        }

    }
}