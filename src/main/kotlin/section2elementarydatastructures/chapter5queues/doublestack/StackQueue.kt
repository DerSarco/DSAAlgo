package section2elementarydatastructures.chapter5queues.doublestack

import section2elementarydatastructures.chapter5queues.Queue

class StackQueue<T : Any> : Queue<T> {
    private val leftStack= StackImpl<T>()
    private val rightStack = StackImpl<T>()

    override val isEmpty: Boolean
        get() = leftStack.isEmpty && rightStack.isEmpty

    override val count: Int
        get() = leftStack.count + rightStack.count

    override fun enqueue(element: T): Boolean {
        rightStack.push(element)
        return true
    }

    override fun dequeue(): T? {
        if(leftStack.isEmpty){
            transferElements()
        }
        return leftStack.pop()
    }

    private fun transferElements() {
        var nextElement = rightStack.pop()
        while (nextElement != null) {
            leftStack.push(nextElement)
            nextElement = rightStack.pop()
        }
    }

    override fun peek(): T? {
        if (leftStack.isEmpty) {
            transferElements()
        }
        return leftStack.peek()
    }

    override fun toString(): String {
        return "Left Stack: \n$leftStack Right Stack: \n$rightStack"
    }
}