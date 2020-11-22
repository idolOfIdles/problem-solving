package leetcode

import java.lang.StringBuilder

fun toChar(n:Int): Char {
    return (n+'a'.toInt()-1).toChar()
}
fun getSmallestString(n: Int, k: Int): String {
    val ans = StringBuilder()
    var remaining = k
    for(i in 1..n){
        if(1 + 26*(n-i)>=remaining && n-i + 1 <= remaining){
            ans.append('a')
            remaining--
        }else{
            ans.append(toChar(remaining - 26*(n-i)))
            remaining = remaining - (remaining - 26*(n-i))
        }

    }
    return ans.toString()
}

fun main(){
//    println(getSmallestString(3,27))
    println(getSmallestString(5,73))
}

