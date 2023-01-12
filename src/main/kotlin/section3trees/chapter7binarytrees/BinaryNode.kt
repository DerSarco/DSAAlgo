package section3trees.chapter7binarytrees

import kotlin.math.max

typealias Visitor<T> = (T?) -> Unit

class BinaryNode<T>(val value: T) {
    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null

    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    fun traversePreOrder(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }


    fun traversePostOrder(visit: Visitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }

    /**
     * Challenges
     */

    fun height(node: BinaryNode<T>? = this): Int {
        return node?.let { 1 + max(height(node.leftChild), height(node.rightChild)) } ?: -1
    }

    fun traversePreOrderWithNull(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrderWithNull(visit) ?: visit(null)
        rightChild?.traversePreOrderWithNull(visit) ?: visit(null)
    }

    fun serialization(node: BinaryNode<T> = this): MutableList<T?> {
        val list = mutableListOf<T?>()
        node.traversePreOrderWithNull { list.add(it) }
        return list
    }

    private fun deserialize(list: MutableList<T?>): BinaryNode<T?>?{
        val rootValue = list.removeAt(list.size -1 ) ?: return null

        val rootNode = BinaryNode<T?>(rootValue)

        rootNode.leftChild = deserialize(list)
        rootNode.rightChild = deserialize(list)

        return rootNode
    }

    fun deserializeOptimized(list: MutableList<T?>): BinaryNode<T?>? {
        return deserialize(list.asReversed())
    }


    override fun toString(): String = diagram(this)

    private fun diagram(
        node: BinaryNode<T>?,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String {
        return node?.let {
            if (it.leftChild == null && it.rightChild == null) {
                "$root:${it.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(node.leftChild, "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }

}