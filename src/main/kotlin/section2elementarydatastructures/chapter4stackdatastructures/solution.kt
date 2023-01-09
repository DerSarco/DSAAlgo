package section2elementarydatastructures.chapter4stackdatastructures

import section2elementarydatastructures.chapter3LinkedList.LinkedList


fun <T : Any> LinkedList<T>.printInReverseStack() {
    val stack = StackImpl<T>()

    for (node in this) {
        stack.push(node)
    }

    var node = stack.pop()
    while (node != null) {
        println(node)
        node = stack.pop()
    }
}

fun String.checkParentheses(): Boolean {
    val stack = StackImpl<Char>()
    for (character in this) {
        when (character) {
            '(' -> stack.push(character)
            ')' -> if (stack.isEmpty) {
                return false
            } else {
                stack.pop()
            }
        }
    }
    return stack.isEmpty
}