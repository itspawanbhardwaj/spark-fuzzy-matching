package com.pb.fuzzy.matching

import scala.reflect.runtime.universe.TypeTag

import com.pb.fuzzy.matching.functions._

import org.apache.spark.sql.Row
import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions._

class functionsSuite extends SparkFunSuite {

  private val sentence1: String = "Jonathan Niese"
  private val sentence2: String = "Jonathon"
  private val document = s"$sentence1 $sentence2"
  private val xml = s"<xml><p>$sentence1</p><p>$sentence2</p></xml>"

  private def testFunction[T: TypeTag](function: UserDefinedFunction, str1: String, str2: String, expected: Any): Unit = {
    val values: Seq[(Int, String, String)] = Seq((0, str1, str2), (2, "Ashcroft", "Asicroft"), (1, "The Shawshank Redemption", "Th Shwshnk Rdmptn"))

    val df = sqlContext.createDataFrame(values).toDF("id", "str1", "str2")
    val actual = df.select(function(col("str1"), col("str2"))) //.first().get(0)
    actual.show()
    //assert(actual === expected)
  }

  private def testNgramFunction[T: TypeTag](function: UserDefinedFunction, str1: String, str2: String, ngramSize: Int, expected: Any): Unit = {
    val df = sqlContext.createDataFrame(Seq((0, str1, str2), (2, "Ashcroft", "Asicroft"), (1, "The Shawshank Redemption", "Th Shwshnk Rdmptn"))).toDF("id", "str1", "str2")

    val actual = df.select(function(col("str1"), col("str2"), lit(ngramSize))) //.first().get(0)

    actual.show()
    //assert(actual === expected)
  }

  private def testComputeFunction[T: TypeTag](function: UserDefinedFunction, str1: String, expected: Any): Unit = {
    val df = sqlContext.createDataFrame(Seq((2, "Ashcroft", "Asicroft"), (1, "The Shawshank Redemption", "Th Shwshnk Rdmptn"))).toDF("id", "str1", "str2")
    val actual = df.select(function(col("str1"))) //.first().get(0)
    actual.show()
    //assert(actual === expected)
  }

  test("levenshteinFn") {
    testFunction(levenshteinFn, sentence1, sentence2, null)
  }

  test("hammingFn") {

    testFunction(hammingFn, sentence1, sentence2, null)
  }

  test("jaroFn") {

    testFunction(jaroFn, sentence1, sentence2, null)
  }

  test("jaroWinklerFn") {

    testFunction(jaroWinklerFn, sentence1, sentence2, null)
  }

  test("ratcliffObershelpFn") {

    testFunction(ratcliffObershelpFn, sentence1, sentence2, null)
  }
  test("metaphoneFn") {

    testFunction(metaphoneFn, sentence1, sentence2, null)
  }

  test("nysiisFn") {

    testFunction(nysiisFn, sentence1, sentence2, null)
  }
  test("refinedNysiisFn") {

    testFunction(refinedNysiisFn, sentence1, sentence2, null)
  }

  test("refinedSoundexFn") {

    testFunction(refinedSoundexFn, sentence1, sentence2, null)
  }

  test("soundexFn") {

    testFunction(soundexFn, sentence1, sentence2, null)
  }

  test("diceSorensenFn") {
    testNgramFunction(diceSorensenFn, sentence1, sentence2, 1, null)
  }

  test("jaccardFn") {
    testNgramFunction(jaccardFn, sentence1, sentence2, 1, null)
  }

  test("nGramFn") {
    testNgramFunction(nGramFn, sentence1, sentence2, 1, null)
  }

  test("overlapFn") {
    testNgramFunction(overlapFn, sentence1, sentence2, 1, null)
  }

  test("computeMetaphoneFn") {
    testComputeFunction(computeMetaphoneFn, sentence2, null)
  }

  test("computeNysiisFn") {
    testComputeFunction(computeNysiisFn, sentence2, null)
  }

  test("computeRefinedNysiisFn") {
    testComputeFunction(computeRefinedNysiisFn, sentence2, null)
  }

  test("computeRefinedSoundexFn") {
    testComputeFunction(computeRefinedSoundexFn, sentence2, null)
  }

}
