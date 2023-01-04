package chapter3LinkedList

fun <T : Any> Node<T>.printReversed() {
    this.next?.printReversed()
    if (this.next != null) {
        print(" <- ")
    }
    print(this.value.toString())
}

fun <T : Any> LinkedList<T>.getMiddle(): Node<T>? {
    var fast = this.nodeAt(0)
    var slow = this.nodeAt(0)

    while (fast != null) {
        fast = fast.next
        if (fast != null) {
            fast = fast.next
            slow = slow?.next
        }
    }
    return slow
}

fun <T : Any> LinkedList<T>.reversed(): LinkedList<T> {
    val result = LinkedList<T>()
    val head = this.nodeAt(0)
    if (head != null) {
        addInReverse(result, head)
    }
    return result
}

fun <T : Comparable<T>> LinkedList<T>.mergeSorted(otherList: LinkedList<T>): LinkedList<T> {
    if (this.isEmpty()) return otherList
    if (otherList.isEmpty()) return this
    val result = LinkedList<T>()

    var left = nodeAt(0)
    var right = otherList.nodeAt(0)

    while (left != null && right != null) {
        if (left.value < right.value) {
            left = append(result, left)
        } else {
            right = append(result, right)
        }
    }
    while (left != null) {
        left = append(result, left)
    }

    while (right != null) {
        right = append(result, right)
    }

    return result
}

private fun <T : Comparable<T>> append(
    result: LinkedList<T>,
    node: Node<T>
): Node<T>? {
    result.append(node.value)
    return node.next
}
