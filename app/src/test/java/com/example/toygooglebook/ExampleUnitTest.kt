package com.example.toygooglebook

import org.junit.Test

import org.junit.Assert.*
import kotlin.system.measureTimeMillis

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun `재귀`() {

        val time1 = measureTimeMillis {
            println(factorialLoop(1000000))
        }

        println(time1)

        val time2 = measureTimeMillis {
            println(factorial(1000000, 1))
        }
        println(time2)


        fib = { n: Int ->
            when (n) {
                0, 1 -> 1L
                else -> fib(n - 1) * n
            }
        }.memoize()

        val time3 = measureTimeMillis {
            fib(1000000)
        }

        println(time3)
    }


    private fun factorialLoop(n: Long): Long {
        var acc = 1L
        for (number in 1..n) {
            acc *= number
        }
        return acc
    }

    private tailrec fun factorial(n: Long, acc: Long): Long {
        return if (n <= 0) {
            acc
        } else {
            factorial(n - 1, n * acc)
        }
    }

    private lateinit var fib: (Int) -> (Long)

    private fun <T, R> ((T) -> R).memoize(): ((T) -> R) {
        val original = this
        val cache = mutableMapOf<T, R>()
        return { n: T -> cache.getOrPut(n) { original(n) } }
    }


}