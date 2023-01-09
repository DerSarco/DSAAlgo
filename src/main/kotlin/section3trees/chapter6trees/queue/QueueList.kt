package section3trees.chapter6trees.queue

import Queue

class ArrayListQueueTree<T : Any> : Queue<T> {
    private val queue = arrayListOf<T>()

    override fun enqueue(element: T): Boolean {
        queue.add(element)
        return true
    }

    override fun dequeue(): T? {
        if (isEmpty) return null
        return queue.removeAt(0)
    }

    override val count: Int
        get() = queue.size

    override fun peek(): T? = queue.getOrNull(0)

    override fun toString(): String = queue.toString()
}