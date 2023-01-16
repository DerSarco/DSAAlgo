package section3trees.chapter8BinarySearchTrees

import example

fun main() {
    "building a BST" example {
        val bst = BinarySearchTree<Int>()
        (0..4).forEach {
            bst.insert(it)
        }
        println(bst)
    }

    val exampleTree = BinarySearchTree<Int>().apply {
        insert(3)
        insert(1)
        insert(4)
        insert(0)
        insert(2)
        insert(5)
    }

    "building a BST balances" example {
        println(exampleTree)
    }

    "Finding a node" example {
        if (exampleTree.contains(5)) {
            println("Found 5!")
        } else {
            println("Couldn't found 5")
        }
    }

    "removing a node" example {
        println("Tree before removal:")
        println(exampleTree)
        exampleTree.remove(3)
        println("Tree after removal:")
        println(exampleTree)
    }
}
