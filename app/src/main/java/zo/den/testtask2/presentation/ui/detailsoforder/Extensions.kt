package zo.den.testtask2.presentation.ui.detailsoforder
import kotlin.NoSuchElementException

fun <T> T?.throwIfNull(): T {
    return this ?: throw NoSuchElementException()
}