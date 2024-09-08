object Q5 {
  def countLetterOccurrences(words: List[String]): Int = {
    //Map each word to its length
    val wordLengths = words.map(_.length)

    //Reduce the list of word lengths to calculate the total sum
    val totalLetters = wordLengths.reduce(_ + _)

    totalLetters
  }

  def main(args: Array[String]): Unit = {
    val words = List("apple", "banana", "cherry", "date")

    val totalCount = countLetterOccurrences(words)
    println(s"Total count of letter occurrences: $totalCount")  // Output: 21
  }
}
