package stackdatastructures

class StackImpl<T : Any> : Stack<T> {
    private val storage = arrayListOf<T>()

    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("-----------")

    }

    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        if (isEmpty) {
            return null
        }
        return storage.removeAt(storage.size - 1)
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size

    companion object {
        fun <T: Any> create(items: Iterable<T>): Stack<T> {
            val stack = StackImpl<T>()
            for(item in items) {
                stack.push(item)
            }
            return stack
        }
    }
}
fun <T: Any> stackOf(vararg element: T): Stack<T>{
    return StackImpl.create(element.asList())
}