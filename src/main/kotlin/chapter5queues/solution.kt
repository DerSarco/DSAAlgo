package chapter5queues

import chapter5queues.doublestack.StackImpl
import chapter5queues.doublestack.StackQueue
import chapter5queues.linkedlist.LinkedListQueue
import chapter5queues.ringbuffer.RingBufferQueue
import example

fun main() {
    "ArrayList Solution" example {
        //Queue inicial propuesto por el libro
        val queue = ArrayListQueue<String>().apply {
            enqueue("D")
            enqueue("S")
            enqueue("A")
            enqueue("L")
            enqueue("G")
        }
        println(queue)
        //modificaciones propuestas por el libro
        queue.enqueue("R")
        queue.enqueue("O")
        queue.dequeue()
        queue.enqueue("C")
        queue.dequeue()
        queue.dequeue()
        queue.enqueue("K")


        println(queue)
        //[L, G, R, O, C, K]
    }

    "Linked List solution" example {
        //Queue inicial propuesto por el libro
        val queue = LinkedListQueue<String>().apply {
            enqueue("D")
            enqueue("S")
            enqueue("A")
            enqueue("L")
            enqueue("G")
        }

        //modificaciones propuestas por el libro
        queue.enqueue("R")
        queue.enqueue("O")
        queue.dequeue()
        queue.enqueue("C")
        queue.dequeue()
        queue.dequeue()
        queue.enqueue("K")
        println(queue)
        //L -> G -> R -> O -> C -> K
    }

    "Ring Buffer solution" example {
        //Queue inicial propuesto por el libro
        val queue = RingBufferQueue<String>(4).apply {
            enqueue("D")
            enqueue("S")
            enqueue("A")
            enqueue("L")
            enqueue("G")
        }

        //modificaciones propuestas por el libro
        queue.enqueue("R")
        queue.enqueue("O")
        queue.dequeue()
        queue.enqueue("C")
        queue.dequeue()
        queue.dequeue()
        queue.enqueue("K")
        println(queue)
        //[L, C, K]
    }

    "Double Stack solution" example {
        //Queue inicial propuesto por el libro
        val queue = StackQueue<String>().apply {
            enqueue("D")
            enqueue("S")
            enqueue("A")
            enqueue("L")
            enqueue("G")
        }

        //modificaciones propuestas por el libro
        queue.enqueue("R")
        queue.enqueue("O")
        queue.dequeue()
        queue.enqueue("C")
        queue.dequeue()
        queue.dequeue()
        queue.enqueue("K")
        println(queue)
    }

    //Challenges

    "Monopoly Challenge" example {
        val monopoly = ArrayListQueue<String>().apply {
            enqueue("Carlos")
            enqueue("Marcos")
            enqueue("Canela")
            enqueue("Tamara")
        }


        for (number in 0..10) {
            println(monopoly.nextPlayer())
        }
    }

    "Reverse Data" example {
        val queue = ArrayListQueue<String>().apply {
            enqueue("Comida")
            enqueue("Bebida")
            enqueue("Baño")
            enqueue("Cama")
        }

        println(queue)
        println("-------Reversed-------")
        queue.reverse()
        println(queue)
    }
}

fun <T : Any> Queue<T>.nextPlayer(): T? {
    val person = this.dequeue() ?: return null
    this.enqueue(person)
    return person
}

fun <T : Any> Queue<T>.reverse() {
    val aux = StackImpl<T>()

    var next = dequeue()
    while (next != null) {
        aux.push(next)
        next = dequeue()
    }

    next = aux.pop()
    while (next != null) {
        this.enqueue(next)
        next = aux.pop()
    }
}