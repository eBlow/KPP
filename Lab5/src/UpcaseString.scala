package lab5

import scala.annotation.tailrec

object UpcaseString {
  def upcaseString(source: String): String = {
    val newString = new StringBuilder
    for(symbol<-source) newString.append( symbol.toUpper)
    newString.toString()
  }
  
  @tailrec
  def upcaseStringTailRec(source: String,
      result: StringBuilder = new StringBuilder, index: Int = 0): String = {
    if(source.length <= index) return result.toString   
    upcaseStringTailRec(source, result.append(source.charAt(index).toUpper), index + 1)
  }
}