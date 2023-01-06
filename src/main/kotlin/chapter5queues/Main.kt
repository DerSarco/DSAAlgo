package chapter5queues

import chapter5queues.doublestack.StackQueue
import chapter5queues.linkedlist.LinkedListQueue
import chapter5queues.ringbuffer.RingBuffer
import chapter5queues.ringbuffer.RingBufferQueue
import example

fun main() {
    "Queue with arraylist" example {
        val queue = ArrayListQueue<String>().apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Erir")
        }

        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")
    }

    "Queue with Doubly Linked List" example {
        val queue = LinkedListQueue<String>().apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Erir")
        }
        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")
    }

    "Queue with ring buffer" example {
        val queue = RingBufferQueue<String>(10).apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }
        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")
    }

    "Queue with double stack" example {
        val queue = StackQueue<String>().apply {
            enqueue("Brian")
            enqueue("Ryan")
            enqueue("Mark")
        }

        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")
    }
}