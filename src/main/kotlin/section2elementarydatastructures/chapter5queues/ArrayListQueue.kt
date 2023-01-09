package section2elementarydatastructures.chapter5queues

class ArrayListQueue<T : Any> : Queue<T> {
    private val list = arrayListOf<T>()
    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }


    override fun dequeue(): T? =
        if (isEmpty) null else list.removeAt(0)


    override val count: Int
        get() = list.size

    override fun peek(): T? = list.getOrNull(0)

    override fun toString(): String = list.toString()
}