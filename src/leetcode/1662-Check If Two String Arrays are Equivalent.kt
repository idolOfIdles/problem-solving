package leetcode

class `1662-Check If Two String Arrays are Equivalent` {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        return word1.reduce{a,b->a.plus(b)}.equals(word2.reduce{a,b->a.plus(b)})
    }
}
