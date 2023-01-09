package section2elementarydatastructures.chapter5queues.ringbuffer

import section2elementarydatastructures.chapter5queues.Queue

class RingBufferQueue<T: Any>(size: Int): Queue<T> {
    private val ringBuffer: RingBuffer<T> = RingBuffer(size)
    override val count: Int
        get() = ringBuffer.count

    override fun peek(): T? = ringBuffer.first

    override fun enqueue(element: T): Boolean = ringBuffer.write(element)

    override fun dequeue(): T?  = if(isEmpty) null else ringBuffer.read()

    override fun toString(): String = ringBuffer.toString()
}