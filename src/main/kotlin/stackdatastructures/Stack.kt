package stackdatastructures

interface Stack<T : Any> {
    fun push(element: T)
    fun pop(): T?
    fun peek(): T?
    val count: Int
    val isEmpty: Boolean
        get() = count == 0
}