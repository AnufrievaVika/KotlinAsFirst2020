@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import lesson3.task1.isPrime
import kotlin.math.pow
import kotlin.math.sqrt

// Урок 4: списки
// Максимальное количество баллов = 12
// Рекомендуемое количество баллов = 8
// Вместе с предыдущими уроками = 24/33

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая (2 балла)
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double = sqrt(v.map { it * it }.sum())

/**
 * Простая (2 балла)
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double =
    if (list.sum() == 0.0) {
        0.0
    } else {
        list.sum() / list.count()
    }

/**
 * Средняя (3 балла)
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    var k = mean(list)
    for (i in 0 until list.size) {
        val element = list[i]
        list[i] = element - k
    }
    return list
}


/**
 * Средняя (3 балла)
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int {
    var i: Int
    var element = 0
    for (i in a.indices) {
        element += a[i] * b[i]
    }
    return element
}

/**
 * Средняя (3 балла)
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int {
    var number = x.toDouble()
    var k = 0
    for (i in p.indices)
        k += (p[i] * number.pow(i)).toInt()

    return (k)
}

/**
 * Средняя (3 балла)
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> {
    var k = 0
    for (i in 0 until list.size) {
        k += list[i]
        list[i] = k
    }
    return list
}

/**
 * Средняя (3 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    var numbers: ArrayList<Int> = arrayListOf()
    var i: Int
    if (isPrime(n)) numbers.add(n)
    else {
        var k = n
        for (i in 1..n / 2) {
            var m = n
            if (isPrime(i) && (n % i == 0)) {
                while (m % i == 0) {
                    numbers.add(i)
                    m /= i
                    k /= i
                }
            }
            if (k == 1) break
        }
    }
    return numbers
}

/**
 * Сложная (4 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String {
    var k = factorize(n)
    var m = k.joinToString(separator = "*")
    return m
}
/**
 * Средняя (3 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */

fun convert(n: Int, base: Int): List<Int> {
    var k: ArrayList<Int> = arrayListOf()
    var b: Int
    var a = n
    if (n == 0) k.add(0)
    else {
        while (a > 0) {
            b = a % base
            a /= base
            k.add(0, b)
        }
    }
    return k
}

/**
 * Сложная (4 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String {
    var k = ""
    var b: String
    var a = n
    if (n == 0) k = "0"
    else {
        while (a > 0) {
            b = if (a % base < 10) (a % base).toString()
            else (a % base + 87).toChar().toString()
            a /= base
            k = b + k
        }
    }
    return k
}


/**
 * Средняя (3 балла)
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var k = 0
    var i: Int
    for (i in digits.indices) {
        k += digits[i] * (base.toDouble()).pow(digits.size - 1 - i).toInt()
    }
    return k
}

/**
 * Сложная (4 балла)
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная (5 баллов)
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    var k = ""
    var num = n
    while (num >= 1000) {
        num -= 1000
        k += "M"
    }
    while (num >= 500) {
        num -= 500
        k += "D"
    }
    while (num >= 100) {
        num -= 100
        k += "C"
    }
    while (num >= 50) {
        num -= 50
        k += "L"
    }
    while (num >= 10) {
        num -= 10
        k += "X"
    }
    while (num >= 5) {
        num -= 5
        k += "V"
    }
    while (num >= 1) {
        num -= 1
        k += "I"
    }
    k = k.replace("DCCCC", "CM")
    k = k.replace("CCCC", "CD")
    k = k.replace("LXXXX", "XC")
    k = k.replace("XXXX", "XL")
    k = k.replace("VIIII", "IX")
    k = k.replace("IIII", "IV")
    return k
}

/**
 * Очень сложная (7 баллов)
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var num = n
    var k1: Int
    var k2: Int
    var k3: Int
    var k4: Int
    var k5: Int
    var k6: Int
    var l = ""


    while (num > 99999) {
        k1 = num / 100000
        num %= 100000
        when (k1) {
            1 -> {l += "сто"}
            2 -> {l += "двести"}
            3 -> {l += "триста"}
            4 -> {l += "четыреста"}
            5 -> {l += "пятьсот"}
            6 -> {l += "шестьсот"}
            7 -> {l += "семьсот"}
            8 -> {l += "восемьсот"}
            9 -> {l += "девятьсот"}
        }
    }
    if (n / 100000 != 0) {l += ' '}


    while (num > 9999) {
        k2 = num / 10000
        num %= 10000
        when (k2) {
            2 -> {l += "двадцать"}
            3 -> {l += "тридцать"}
            4 -> {l += "сорок"}
            5 -> {l += "пятьдесят"}
            6 -> {l += "шестьдесят"}
            7 -> {l += "семьдесят"}
            8 -> {l += "восемьдесят"}
            9 -> {l += "девяносто"}
        }
        if ((k2 == 1) && (num / 1000 % 10 == 0)) {l += "десять тысяч"}
    }
    if ((n / 10000 % 10 != 0) && (n / 10000 % 10 != 1)) {l += ' '}


    while (num > 999) {
        k2 = n / 10000 % 10
        k3 = num / 1000
        num = n % 1000
        when {
            (k2 == 1) && (k3 == 1) -> {l += "одиннадцать тысяч"}
            (k2 == 1) && (k3 == 2) -> {l += "двенадцать тысяч"}
            (k2 == 1) && (k3 == 3) -> {l += "тринадцать тысяч"}
            (k2 == 1) && (k3 == 4) -> {l += "четырнадцать тысяч"}
            (k2 == 1) && (k3 == 5) -> {l += "пятнадцать тысяч"}
            (k2 == 1) && (k3 == 6) -> {l += "шестнадцать тысяч"}
            (k2 == 1) && (k3 == 7) -> {l += "семнадцать тысяч"}
            (k2 == 1) && (k3 == 8) -> {l += "восемнадцать тысяч"}
            (k2 == 1) && (k3 == 9) -> {l += "девятнадцать тысяч"}
            (k3 == 1) -> {l += "одна тысяча"}
            (k3 == 2) -> {l += "две тысячи"}
            (k3 == 3) -> {l += "три тысячи"}
            (k3 == 4) -> {l += "четыре тысячи"}
            (k3 == 5) -> {l += "пять тысяч"}
            (k3 == 6) -> {l += "шесть тысяч"}
            (k3 == 7) -> {l += "семь тысяч"}
            (k3 == 8) -> {l += "восемь тысяч"}
            (k3 == 9) -> {l += "девять тысяч"}
        }
    }
    if (((n / 100000 != 0) || (n / 10000 % 10 != 0)) && (n / 10000 % 10 != 1) && (n / 1000 % 10 == 0)) {l += "тысяч"}
    if (((n / 100000 != 0) || (n / 10000 != 0)) && (n / 1000 % 10 == 0) && (n % 1000 != 0)) {l += " "}
    if (n / 1000 % 10 != 0) {l += ' '}


    while (num > 99) {
        k4 = num / 100
        num %= 100
        when (k4) {
            1 -> {l += "сто"}
            2 -> {l += "двести"}
            3 -> {l += "триста"}
            4 -> {l += "четыреста"}
            5 -> {l += "пятьсот"}
            6 -> {l += "шестьсот"}
            7 -> {l += "семьсот"}
            8 -> {l += "восемьсот"}
            9 -> {l += "девятьсот"}
        }
    }
    if ((n / 100 % 10 != 0) && (num != 0)) {l += ' '}


    while (num > 9) {
        k5 = num / 10
        num %= 10
        when (k5) {
            2 -> {l += "двадцать"}
            3 -> {l += "тридцать"}
            4 -> {l += "сорок"}
            5 -> {l += "пятьдесят"}
            6 -> {l += "шестьдесят"}
            7 -> {l += "семьдесят"}
            8 -> {l += "восемьдесят"}
            9 -> {l += "девяносто"}
        }
        if ((k5 == 1) && (num % 10 == 0)) {l += "десять"}
    }
    if ((n / 10 % 10 != 0) && (n / 10 % 10 != 1) && (num != 0)) {l += ' '}


    while (num > 0) {
        k5 = n % 100 / 10
        k6 = num
        num = 0
        when {
            (k5 == 1) && (k6 == 1) -> {l += "одиннадцать"}
            (k5 == 1) && (k6 == 2) -> {l += "двенадцать"}
            (k5 == 1) && (k6 == 3) -> {l += "тринадцать"}
            (k5 == 1) && (k6 == 4) -> {l += "четырнадцать"}
            (k5 == 1) && (k6 == 5) -> {l += "пятнадцать"}
            (k5 == 1) && (k6 == 6) -> {l += "шестнадцать"}
            (k5 == 1) && (k6 == 7) -> {l += "семнадцать"}
            (k5 == 1) && (k6 == 8) -> {l += "восемнадцать"}
            (k5 == 1) && (k6 == 9) -> {l += "девятнадцать"}
            (k6 == 1) -> {l += "один"}
            (k6 == 2) -> {l += "два"}
            (k6 == 3) -> {l += "три"}
            (k6 == 4) -> {l += "четыре"}
            (k6 == 5) -> {l += "пять"}
            (k6 == 6) -> {l += "шесть"}
            (k6 == 7) -> {l += "семь"}
            (k6 == 8) -> {l += "восемь"}
            (k6 == 9) -> {l += "девять"}
        }
    }
    return l
}