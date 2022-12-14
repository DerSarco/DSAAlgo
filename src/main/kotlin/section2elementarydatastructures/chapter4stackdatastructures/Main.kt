import section2elementarydatastructures.chapter3LinkedList.LinkedList
import section2elementarydatastructures.chapter4stackdatastructures.StackImpl
import section2elementarydatastructures.chapter4stackdatastructures.checkParentheses
import section2elementarydatastructures.chapter4stackdatastructures.printInReverseStack
import section2elementarydatastructures.chapter4stackdatastructures.stackOf

/*
 * Copyright (c) 2019 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

fun main() {
    "Using a Stack" example {
        val stack = StackImpl<Int>().apply {
            push(1)
            push(2)
            push(3)
            push(4)
        }

        print(stack)
        val poppedElement = stack.pop()
        if (poppedElement != null) {
            println("Popped: $poppedElement")
        }
        println(stack)
    }

    "Initializing a stack from a list" example {
        val list = listOf("A", "B", "C", "D")
        val stack = StackImpl.create(list)
        print(stack)
        println("Popped: ${stack.pop()}")
    }

    "Initializing a stack from an array literal" example {
        val stack = stackOf(1.0, 2.0, 3.0, 4.0)
        print(stack)
        println("Popped: ${stack.pop()}")
    }

    /**
     * Challenges
     */

    "Reverse a LinkedList" example {
        val list = LinkedList<Int>().apply {
            add(1)
            add(2)
            add(3)
            add(4)
        }

        println("List:$list")
        println("Reversed List")
        list.printInReverseStack()
    }

    "Parentheses validation" example {
        val stringForChecking = ")asdasdas("
        val validStringChecking = "habia una vez (largo como un pez)"

        println("Unvalid characters: ${stringForChecking.checkParentheses()}")
        println("Valid characters: ${validStringChecking.checkParentheses()}")

    }
}
