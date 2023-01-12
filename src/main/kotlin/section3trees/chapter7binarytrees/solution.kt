package section3trees.chapter7binarytrees

fun main() {
    val fifthTeen = BinaryNode(15)
    val ten = BinaryNode(10)
    val twentyFive = BinaryNode(25)
    val five = BinaryNode(5)
    val twelve = BinaryNode(12)
    val sevenTeen = BinaryNode(17)

    fifthTeen.leftChild = ten
    fifthTeen.rightChild = twentyFive

    ten.leftChild = five
    ten.rightChild = twelve

    twentyFive.leftChild = sevenTeen

    val list = fifthTeen.serialization()
    println(list)
    println(list.asReversed())
    println(fifthTeen.deserializeOptimized(list))

}
