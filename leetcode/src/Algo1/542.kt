package Algo1

import kotlin.math.min

class Solution542 {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val distance = Array(mat.size) { IntArray(mat[0].size) { Int.MAX_VALUE } }
        (0 until mat.size).forEach { i ->
            (0 until mat[0].size).forEach { j ->
                if (mat[i][j] == 0)
                    distance[i][j] = 0
                else {
                    if (i > 0)
                        distance[i][j] = min(distance[i][j], distance[i - 1][j] + 1)
                    if (j > 0)
                        distance[i][j] = min(distance[i][j], distance[i][j - 1] + 1)
                }
            }
        }
        (mat.size - 1 downTo 0).forEach { i ->
            (mat[0].size - 1 downTo 0).forEach { j ->
                if (i < mat.size - 1)
                    distance[i][j] = min(distance[i][j], distance[i + 1][j] + 1)
                if (j < mat[0].size - 1)
                    distance[i][j] = min(distance[i][j], distance[i][j + 1] + 1)
            }
        }
        return distance
    }
}