package section3trees.chapter6trees

import com.sun.source.tree.Tree
import section2elementarydatastructures.chapter5queues.Queue
import section3trees.chapter6trees.queue.ArrayListQueueTree


/**
 * Un tree está compuesto por nodos, cada nodo apunta hacia otros nodos, cada cosa tiene un termino definido
 * por ejemplo, un child puede tener un parent, en simples palabras el parent es el nodo que está por sobre
 * el nodo children [ parent -> children ]
 *
 * El root (raíz) es el nodo que no tiene padre, es el primer nodo en la cima del árbol.
 *
 * leaf son los nodos que no tienen hijos que se encuentran al final del árbol
 */

class TreeNode<T : Any>(val value: T) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) {
        children.add(child)
    }

    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }

    fun forEachLevelOrder(visit: Visitor<T>) {
        visit(this)
        val queue = ArrayListQueueTree<TreeNode<T>>()
        children.forEach { queue.enqueue(it) }

        var node = queue.dequeue()
        while (node != null) {
            visit(node)
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }


    fun search(value: T): TreeNode<T>? {
        var result: TreeNode<T>? = null

        forEachLevelOrder {
            if (it.value == value) {
                result = it
            }
        }
        return result
    }

    override fun toString(): String {
        val text = buildString {
            appendLine("------- Tree ------")
            for (child in children) {
                append("${child.value} ->")
            }
            appendLine("------- End ------")
        }
        return text
    }


    /*Challenges*/
    fun printEachLevel() {
        val queue = ArrayListQueueTree<TreeNode<T>>()
        var nodesLeftInCurrentLevel = 0

        queue.enqueue(this)

        while (queue.isEmpty.not()) {
            nodesLeftInCurrentLevel = queue.count
            while (nodesLeftInCurrentLevel > 0) {
                val node = queue.dequeue()
                node?.let {
                    print("${node.value} - ")
                    node.children.forEach { queue.enqueue(it) }
                    nodesLeftInCurrentLevel--
                } ?: break
            }
            println()
        }
    }
}

typealias Visitor<T> = (TreeNode<T>) -> Unit