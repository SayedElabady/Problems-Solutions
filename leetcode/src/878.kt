class Solution878 {
    val MOD = 1_000_000_007

    fun nthMagicalNumber(n: Int, a: Int, b: Int): Int {
        val aLong = minOf(a, b).toLong()
        val bLong = maxOf(a, b).toLong()
        val nLong = n.toLong()
        val lcm = a * b / gcd(bLong, aLong)
        var left = minOf(aLong, bLong)
        var right = 60L
        while(left< right){
            val mid = (left + right).shr(1)
            val divisors = getNumberOfDivisors(aLong, bLong, mid, lcm)
            if(divisors == nLong) return getAnswer(aLong, bLong, nLong, mid, lcm)
            else if(divisors > n){
                right = mid - 1
            }else {
                left = mid + 1
            }
        }
        return ((right)%MOD).toInt()
    }

    fun getAnswer(a:Long, b:Long, n:Long, value: Long, lcm: Long):Int{
        var current = value
        while(getNumberOfDivisors(a, b, current, lcm) ==n ){
            current--
        }
        return ((current+1) %MOD).toInt()
    }
    fun getNumberOfDivisors(a: Long, b: Long, value: Long, lcm: Long): Long{
        if(b%a==0L) return value/a
        return (value/a) + (value/b) - (value/(lcm))
    }

    fun gcd(a: Long, b: Long): Long{
        if(b == 0L) return a
        return gcd(b, a%b)
    }
}

fun main() {
    val s= Solution878()
    s.nthMagicalNumber(10,10,8)
}