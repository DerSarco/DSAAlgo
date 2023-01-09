package section3trees.chapter6trees


fun main() {
    val tree = numericTree()
    tree.printEachLevel()
}

fun numericTree(): TreeNode<Int> {

    val tree = TreeNode(15)

    val child1 = TreeNode(1)
    val child2 = TreeNode(17)
    val child3 = TreeNode(20)

    val child4 = TreeNode(1)
    val child5 = TreeNode(5)
    val child6 = TreeNode(0)
    val child7 = TreeNode(2)
    val child8 = TreeNode(5)
    val child9 = TreeNode(7)

    tree.add(child1)
    tree.add(child2)
    tree.add(child3)

    child1.add(child4)
    child1.add(child5)
    child1.add(child6)

    child2.add(child7)

    child3.add(child8)
    child3.add(child9)

    return tree
}