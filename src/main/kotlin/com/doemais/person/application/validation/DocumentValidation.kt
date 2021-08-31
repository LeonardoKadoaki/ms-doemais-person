package com.doemais.person.application.validation

fun String.isValidCpf(charactersToIgnore: List<Char> = listOf('.', '-')): Boolean {
    val cleanCpf = this.filterNot { it in charactersToIgnore }
    if (cleanCpf.containsInvalidCPFChars() || cleanCpf.isInvalidCpfSize()) return false
    return cleanCpf.hasValidVerificationDigits()
}

private fun String.containsInvalidCPFChars() = this.any { !it.isDigit() }
private fun String.isInvalidCpfSize() = this.length != 11

private fun String.hasValidVerificationDigits(): Boolean {
    val firstNineDigits = substring(0..8)
    val digits = substring(9..10)

    return firstNineDigits.calculateDigits() == digits
}

private fun String.calculateDigits(): String {
    val numbers = map { it.toString().toInt() }
    val firstDigit = numbers.calculateFirstVerificationDigit()
    val secondDigit = numbers.calculateSecondVerificationDigit(firstDigit)

    return "$firstDigit$secondDigit"
}

private fun List<Int>.calculateFirstVerificationDigit(): Int {

    val firstNineDigits = this
    val weights = (10 downTo 2).toList()
    val sum = firstNineDigits.withIndex().sumBy { (index, element) -> weights[index] * element }

    val remainder = sum % 11
    return if(remainder < 2) 0 else 11 - remainder
}

private fun List<Int>.calculateSecondVerificationDigit(firstDigit: Int): Int {
    val firstTenDigits = this + firstDigit
    val weights = (11 downTo 2).toList()
    val sum = firstTenDigits.withIndex().sumBy { (index, element) -> weights[index] * element }

    val remainder = sum % 11
    return if (remainder < 2) 0 else 11 - remainder
}

