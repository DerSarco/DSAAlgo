class LinkedList<T : Any> :
    Iterable<T>,
    Collection<T>,
    MutableIterable<T>,
    MutableCollection<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size = 0
        private set

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun contains(element: T): Boolean {
        for (item in this) {
            if (item == element) return true
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for (searched in elements) {
            if (!contains(searched)) return false
        }
        return true
    }

    /**
     * Función que agrega una nuevo nodo al inicio
     * del LinkedList
     */
    fun push(value: T): LinkedList<T> = apply {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
    }

    /**
     * Función que agrega una nuevo nodo al final
     * del LinkedList
     */
    fun append(value: T): LinkedList<T> = apply {
        if (isEmpty()) {
            return push(value)
        }
        val newNode = Node(value = value)
        tail!!.next = newNode

        tail = newNode
        size++
    }

    /**
     * Función que obtiene la posición del nodo
     */

    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    /**
     * Función que inserta un nuevo nodo
     */

    fun insert(value: T, afterNode: Node<T>): Node<T> {
        1//
        if (tail == afterNode) {
            append(value)
            return tail!!
        }
        //2
        val newNode = Node(value = value, next = afterNode.next)
        //3
        afterNode.next = newNode
        size++
        return newNode
    }

    /**
     * Función que elimina la primera entrada de la LinkedList
     */

    fun pop(): T? {
        if (isEmpty()) return null

        val result = head?.value
        head = head?.next
        size--
        if (isEmpty()) {
            tail = null
        }
        return result
    }

    /**
     * Función para remover ultima entrada de la LinkedList
     */

    fun removeLast(): T? {
        //1
        val head = head ?: return null
        //2
        if (head.next == null) return pop()
        //3
        size--

        //4
        var prev = head
        var current = head
        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }
        //5
        prev.next = null
        tail = prev
        return current.value
    }

    /**
     * Función que remueve un nodo de un punto especifico
     * de la LinkedList
     */

    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value

        if (node.next == tail) {
            tail = node
        }
        if (node.next != null) {
            size--
        }
        node.next = node.next?.next
        return result
    }

    /**
     * Función que imprime la LinkedList reversada
     */
    fun printedInReverse() {
        if (isEmpty()) {
            "Empty List"
        } else {
            head!!.printReversed()
        }
    }

    /**
     * Función que crea una nueva LinkedList reversada
     */

    fun <T : Any> addInReverse(list: LinkedList<T>, node: Node<T>) {
        val next = node.next
        if (next != null) {
            addInReverse(list, next)
        }
        list.append(node.value)
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }

    override fun iterator(): MutableIterator<T> {
        return LinkedListIterator(this)
    }

    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for (element in elements) {
            append(element)
        }
        return true
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun remove(element: T): Boolean {
        val iterator = iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (item == element) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (item in elements) {
            result = remove(item) || result
        }
        return result
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = this.iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (!elements.contains(item)) {
                iterator.remove()
                result = true
            }
        }
        return result
    }

}