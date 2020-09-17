package ru.skillbranch.devintensive.extensions

fun String.truncate(length: Int = 16): String {
    val trimMessage = this.trim()
    return if (trimMessage.length <= length) trimMessage else trimMessage.substring(0, length).trim() + "..."
}

fun String.stripHtml(): String {
    val htmlRegex = Regex("(<.*?>)|(&[^ а-я]{1,4}?;)")
    val spaceRegex = Regex(" {2,}")
    return this.replace(htmlRegex, "").replace(spaceRegex, " ")
}