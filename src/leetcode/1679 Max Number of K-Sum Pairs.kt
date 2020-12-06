package leetcode


fun maxOperations(nums: IntArray, k: Int): Int {
    val mapOfCount = HashMap<Int,Int>()
    nums.forEach {
        val count = mapOfCount.getOrDefault(it, 0)
        mapOfCount.put(it, count+1)
    }

    var count = 0
    nums.forEach {
        val current_count = mapOfCount.getOrDefault(it, 0)
        val k_it_count = mapOfCount.getOrDefault(k-it, 0)
        if( (current_count > 0 && k_it_count > 0)
            && (it*2 != k || current_count>1) ){
            count++
            mapOfCount.put(it, current_count-1)
            mapOfCount.put(k-it, mapOfCount.get(k-it)!!-1)
        }
    }

    return count
}

fun main(){
    println(maxOperations(intArrayOf(4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4), 2))
    println(maxOperations(intArrayOf(1,2,3,4), 5))
    println(maxOperations(intArrayOf(3,1,3,4,3), 6))
}
