package leetcode
class OddEven(var odd:Int = 0, var even:Int = 0)
fun waysToMakeFair(nums: IntArray): Int {
    val leftSum = Array<OddEven>(nums.size){ OddEven() }
    val rightSum = Array<OddEven>(nums.size){OddEven()}
    for(i in nums.indices){
        val odd = if (i%2==1) nums[i] else 0
        val even = if (i%2==0) nums[i] else 0
        val old_odd = if(i>0) leftSum.get(i-1).odd else 0
        val old_even = if(i>0) leftSum.get(i-1).even else 0
        leftSum[i] = OddEven(odd+ old_odd,even + old_even)
    }

    for(i in nums.indices.reversed()){
        val odd = if (i%2==1) nums[i] else 0
        val even = if (i%2==0) nums[i] else 0
        val old_odd = if(i+1<nums.size) rightSum.get(i+1).odd else 0
        val old_even = if(i+1<nums.size) rightSum.get(i+1).even else 0
        rightSum[i] = OddEven(odd+ old_odd,even + old_even)
    }

    var ans = 0;
    for(i in nums.indices){
        var os = 0
        var es = 0
        if(i>0) os = os + leftSum.get(i-1).odd
        if(i+1<nums.size) os = os + rightSum.get(i+1).even
        if(i>0) es = es + leftSum.get(i-1).even
        if(i+1<nums.size) es = es + rightSum.get(i+1).odd
        if(os == es) ans++
    }

    return ans
}

fun main(){
    println(waysToMakeFair(intArrayOf(2,1,6,4)))
    println(waysToMakeFair(intArrayOf(1,1,1)))
    println(waysToMakeFair(intArrayOf(1,2,3)))
}
