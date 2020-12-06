package leetcode

import java.lang.StringBuilder


fun interpret(command: String): String {
    var i = 0
    val ans = StringBuilder()
    while( i < command.length){
        if(command[i] == 'G'){
            ans.append('G')
            i++
        }else if(command[i] == '('){
            if(command[i+1] == ')'){
                ans.append('o')
                i = i+2
            }else{
                ans.append("al")
                i = i+4
            }
        }
    }
    return ans.toString()

}

fun main(){
    println(interpret("G()(al)"))
    println(interpret("G()()()()(al)"))
    println(interpret("(al)G(al)()()G"))
}
