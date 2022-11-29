package com.prospect.fatuapp.utils

interface Calculation {

    fun Addition(a :Int, b:Int): Int {

        return (a+b)
    }
    fun Multiplication(a: Int,b: Int): Int{

        return (a*b)
    }
    fun sub(a: Int,b: Int):Int{
        return (a-b)
    }
    fun Division(a:Int,b: Int):Int{
        return (a/b)
    }
}