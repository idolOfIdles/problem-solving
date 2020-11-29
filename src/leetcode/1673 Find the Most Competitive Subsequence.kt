package leetcode

import java.util.*

class `1673 Find the Most Competitive Subsequence` {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray {

        val stackedIndexes = Stack<Int>()

        for(i in nums.indices){
            val remaining = nums.size - i
            while (!stackedIndexes.isEmpty()
                && nums[stackedIndexes.peek()] > nums[i]
                &&  remaining>= k - stackedIndexes.size+1  ){
                stackedIndexes.pop()
            }

            if(stackedIndexes.size < k )
                stackedIndexes.add(i)
        }

        return stackedIndexes.map { nums[it] }.toIntArray()
    }
}

fun main(){
    println(`1673 Find the Most Competitive Subsequence`().mostCompetitive(intArrayOf(3,5,2,6), 2).joinToString{i->i.toString()})
    println(`1673 Find the Most Competitive Subsequence`().mostCompetitive(intArrayOf(2,4,3,3,5,4,9,6), 4).joinToString{i->i.toString()})
}
