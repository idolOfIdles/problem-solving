package leetcode


fun minimumEffort(tasks: Array<IntArray>): Int {

    val actSum = tasks.sumBy { it[0] }
    val min = tasks.map { it[1] }.max()
    var startSum = Math.max(min?:0, actSum)
    var currentCost = startSum
    tasks.sortWith(Comparator {a:IntArray,b:IntArray-> (b[1] - b[0]) - (a[1] - a[0]) })
    for(task in tasks){
        if(currentCost< task[1]){
            startSum = startSum + task[1] - currentCost
            currentCost = task[1]
        }

        currentCost = currentCost - task[0]
        if(currentCost < 0) {
            startSum = startSum + Math.abs(currentCost)
            currentCost = 0
        }
    }
    return startSum
}
fun main(){
    println(minimumEffort(arrayOf(intArrayOf(1,2), intArrayOf(2,4), intArrayOf(4,8))))
    println(minimumEffort(arrayOf(intArrayOf(1,3), intArrayOf(2,4), intArrayOf(10,11),intArrayOf(10,12), intArrayOf(8,9))))
    println(minimumEffort(arrayOf(intArrayOf(1,7), intArrayOf(2,8), intArrayOf(3,9),intArrayOf(4,10), intArrayOf(5,11), intArrayOf(6,12))))
}
