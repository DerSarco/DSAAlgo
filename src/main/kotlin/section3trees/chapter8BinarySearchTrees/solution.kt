package section3trees.chapter8BinarySearchTrees

import example

fun main(args: Array<String>) {
    val exampleTree = BinarySearchTree<Int>().apply {
        insert(3)
        insert(1)
        insert(4)
        insert(0)
        insert(2)
        insert(5)
    }

    val exampleTree2 = BinarySearchTree<Int>().apply {
        insert(3)
        insert(1)
        insert(4)
        insert(0)
        insert(2)
        insert(5)
    }

    val exampleTree3 = BinarySearchTree<Int>().apply {
        insert(1)
        insert(4)
        insert(3)
        insert(0)
        insert(2)
        insert(5)
    }

    "check if is a BST" example {
        println(exampleTree.toString())
        println(exampleTree.root?.isBinarySearchTree)
    }

    "Check if 2 BST are equals" example {
        println(exampleTree.root == exampleTree2.root)
        println(exampleTree.root == exampleTree3.root)
    }

    "Check if 2 BST contains the same items" example {
        println(exampleTree.contains(exampleTree2))
        println(exampleTree.contains(exampleTree3))
    }
}