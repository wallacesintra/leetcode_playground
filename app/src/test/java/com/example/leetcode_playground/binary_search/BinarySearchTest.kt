package com.example.leetcode_playground.binary_search

import androidx.annotation.Nullable
import org.junit.Test
import org.junit.Assert.*
import kotlin.test.assertEquals

class BinarySearchTest {
    @Test
    fun `doesBinarySearchReturnIntOrNull` (){
        //given
        val nums = emptyList<Int>()
        val target = 1

        //when
        val actual = binary_search(nums= nums, target = target)

        //then
        assertEquals(
            expected = true,
            actual = actual is Int?
        )

    }

    @Test
    fun `doesBinarySearchReturn` (){
        //given
        val nums = listOf(1, 2, 3, 4,5,6,7)
        val target = 3

        //when
        val actual = binary_search(nums= nums, target = target)

        //then
        assertEquals(
            expected = 2,
            actual = actual
        )

    }
    @Test
    fun `doesBinarySearchReturnInt` (){
        //given
        val nums = listOf(1, 2, 3, 4,5)
        val target = 3

        //when
        val actual = binary_search(nums= nums, target = target)

        //then
        assertEquals(
            expected = 2,
            actual = actual
        )

    }




}