package com.pb.fuzzy.matching

import org.apache.spark.sql.SparkSession
import org.apache.log4j.Logger
import org.apache.log4j.Level

import com.pb.fuzzy.matching.functions._

import org.apache.spark.sql.functions._

object FuzzyMatchingJoinExample {

  def getSparkSession(appName: String): SparkSession = {
    Logger.getLogger("org").setLevel(Level.OFF);
    Logger.getLogger("akka").setLevel(Level.OFF);
    SparkSession
      .builder()
      .appName(appName)
      .master("local")
      .getOrCreate()
  }

  def main(args: Array[String]) {
    val sparkSession = getSparkSession("Fuzzy matching")

    val df = sparkSession.read.option("header", "true").option("separator", ";").option("inferSchema", "true").csv("src/test/data/movies1.txt")
    val dfWithWrongTitles = sparkSession.read.option("header", "true").option("separator", ";").option("inferSchema", "true").csv("src/test/data/movies2.txt")

    println("Dataset with proper names")
    df.show(5)

    println("Dataset with misspelled names")
    dfWithWrongTitles.show(5)

    val joinedDF = df.join(dfWithWrongTitles, levenshteinFn(df("title"), dfWithWrongTitles("title")) < 5)

    println("Dataset after fuzzy join")

    joinedDF.show(5)

  }
}