class LinkedListIterator<T : Any>(
    private val list: LinkedList<T>
) : MutableIterator<T> {

    private var index = 0
    private var lastNode: Node<T>? = null

    override fun hasNext(): Boolean {
        return index < list.size
    }

    override fun next(): T {
        //1
        if (index >= list.size) throw IndexOutOfBoundsException()
        //2
        lastNode = if (index == 0) {
            list.nodeAt(0)
        } else {
            lastNode?.next
        }
        index++
        return lastNode!!.value
    }

    override fun remove() {
        if(index == 1){
            list.pop()
        }else {
            val prevNode = list.nodeAt(index - 2) ?: return
            list.removeAfter(prevNode)
        }
        index--
    }
}