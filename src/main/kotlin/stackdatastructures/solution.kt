package stackdatastructures

import LinkedList.LinkedList


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