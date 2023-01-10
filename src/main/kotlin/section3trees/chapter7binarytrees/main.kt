package section3trees.chapter7binarytrees

import section3trees.chapter7binarytrees.BinaryNode

fun main() {

    val zero = BinaryNode(0)
    val one = BinaryNode(1)
    val five = BinaryNode(5)
    val seven = BinaryNode(7)
    val eight = BinaryNode(8)
    val nine = BinaryNode(9)

    seven.leftChild = one
    one.leftChild = zero
    one.rightChild = five
    seven.rightChild = nine
    nine.leftChild = eight

    val tree = seven
    println(tree)

    tree.traverseInOrder { println(it) }
    println("\n")
    tree.traversePreOrder { println(it) }
    println("\n")
    tree.traversePostOrder { println(it) }
    println("\n")
    println(tree.height())
}