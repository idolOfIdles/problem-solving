package leetcode

class `1672 Richest Customer Wealth` {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        var max = Int.MIN_VALUE
        accounts.forEach { max = Math.max( it.sum(), max) }
        return max
    }
}

fun main(){
    println(`1672 Richest Customer Wealth`().maximumWealth(arrayOf(intArrayOf(1,2,3), intArrayOf(3,2,1))))
    println(`1672 Richest Customer Wealth`().maximumWealth(arrayOf(intArrayOf(2,8,7), intArrayOf(7,1,3), intArrayOf(1,9,5))))
}
