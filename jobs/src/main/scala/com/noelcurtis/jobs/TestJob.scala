package com.noelcurtis.jobs

import org.apache.spark.SparkContext

object FilterFunctions {
  private val testText = "lorem"

  def filterTestText(text: String): Boolean = {
    if (!text.isEmpty && text.toLowerCase.contains(testText)) {
      return true
    } else {
      return false
    }
  }
}

case class TestJob(filePath: String, sparkContext: SparkContext) {

  def execute(): Unit = {
    val textFile = sparkContext.textFile(filePath)
    val count = textFile.filter(FilterFunctions.filterTestText).count()
    println(s"Number of lines is $count")
  }

}
