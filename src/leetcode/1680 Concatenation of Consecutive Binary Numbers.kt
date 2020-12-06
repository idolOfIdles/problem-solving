package leetcode

import java.lang.StringBuilder

fun concatenatedBinary(n: Int): Int {

    val binary = StringBuilder()
    for(i in 1..n){
       binary.append(i.toString(2))
    }
    val mod = 1_000_000_000 + 7
    val powerOfTwo = Array<Int>(binary.length){1}
    for(i in powerOfTwo.indices){
        if(i>0){
            powerOfTwo[i] = (powerOfTwo[i-1]*2)%mod
        }
    }

    var ans = 0
    binary.toString().toCharArray().reversedArray().forEachIndexed{ i,v->
        if(v == '1'){
            ans = (ans + powerOfTwo[i])%mod
        }
    }
    return ans


}

fun main(){
//    println(concatenatedBinary(1))
    println(concatenatedBinary(3))
    println(concatenatedBinary(12))
//    println(concatenatedBinary(12))
//    println(BigInteger(3.toString(2)).toInt())
}
