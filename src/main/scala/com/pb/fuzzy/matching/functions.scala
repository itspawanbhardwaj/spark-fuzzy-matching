package com.pb.fuzzy.matching

import org.apache.spark.sql.functions.udf

import com.rockymadden.stringmetric.phonetic.MetaphoneAlgorithm
import com.rockymadden.stringmetric.phonetic.MetaphoneMetric
import com.rockymadden.stringmetric.phonetic.NysiisAlgorithm
import com.rockymadden.stringmetric.phonetic.NysiisMetric
import com.rockymadden.stringmetric.phonetic.RefinedNysiisAlgorithm
import com.rockymadden.stringmetric.phonetic.RefinedNysiisMetric
import com.rockymadden.stringmetric.phonetic.RefinedSoundexAlgorithm
import com.rockymadden.stringmetric.phonetic.RefinedSoundexMetric
import com.rockymadden.stringmetric.phonetic.SoundexAlgorithm
import com.rockymadden.stringmetric.phonetic.SoundexMetric
import com.rockymadden.stringmetric.similarity.DiceSorensenMetric
import com.rockymadden.stringmetric.similarity.HammingMetric
import com.rockymadden.stringmetric.similarity.JaccardMetric
import com.rockymadden.stringmetric.similarity.JaroMetric
import com.rockymadden.stringmetric.similarity.JaroWinklerMetric
import com.rockymadden.stringmetric.similarity.LevenshteinMetric
import com.rockymadden.stringmetric.similarity.NGramMetric
import com.rockymadden.stringmetric.similarity.OverlapMetric
import com.rockymadden.stringmetric.similarity.RatcliffObershelpMetric
import com.rockymadden.stringmetric.similarity.WeightedLevenshteinMetric

/**
 * A collection of Spark SQL UDFs that wrap different fuzzy matching algorithms functions.
 */
object functions {

  def levenshteinFn = udf { (document: String, document1: String) =>
    LevenshteinMetric.compare(document, document1)
  }

  def diceSorensenFn = udf { (document: String, document1: String, nGramSize: Int) =>
    DiceSorensenMetric(nGramSize).compare(document, document1)
  }
  def hammingFn = udf { (document: String, document1: String) =>
    HammingMetric.compare(document, document1)
  }

  def jaccardFn = udf { (document: String, document1: String, nGramSize: Int) =>
    JaccardMetric(nGramSize).compare(document, document1)
  }
  def jaroFn = udf { (document: String, document1: String) =>
    JaroMetric.compare(document, document1)
  }

  def jaroWinklerFn = udf { (document: String, document1: String) =>
    JaroWinklerMetric.compare(document, document1)
  }

  def nGramFn = udf { (document: String, document1: String, nGramSize: Int) =>
    NGramMetric(nGramSize).compare(document, document1)
  }

  def overlapFn = udf { (document: String, document1: String, nGramSize: Int) =>
    OverlapMetric(nGramSize).compare(document, document1)
  }

  def ratcliffObershelpFn = udf { (document: String, document1: String) =>
    RatcliffObershelpMetric.compare(document, document1)
  }

  def weightedLevenshteinFn = udf { (document: String, document1: String, deleteWeight: Int, insertWeight: Int, substituteWeight: Int) =>
    WeightedLevenshteinMetric(deleteWeight, insertWeight, substituteWeight).compare(document, document1)
  }

  /*Phonetic package*/
  /*Useful for indexing by word pronunciation and performing sounds-like comparisons. All metrics return a boolean value indicating if the two strings sound the same, per the algorithm used. All metrics have an algorithm counterpart which provide the means to perform indexing by word pronunciation.*/

  def metaphoneFn = udf { (document: String, document1: String) =>
    MetaphoneMetric.compare(document, document1)
  }

  def computeMetaphoneFn = udf { (document: String) =>
    MetaphoneAlgorithm.compute(document)
  }

  def nysiisFn = udf { (document: String, document1: String) =>
    NysiisMetric.compare(document, document1)
  }

  def computeNysiisFn = udf { (document: String) =>
    NysiisAlgorithm.compute(document)
  }

  def refinedNysiisFn = udf { (document: String, document1: String) =>
    RefinedNysiisMetric.compare(document, document1)
  }

  def computeRefinedNysiisFn = udf { (document: String) =>
    RefinedNysiisAlgorithm.compute(document)
  }

  def refinedSoundexFn = udf { (document: String, document1: String) =>
    RefinedSoundexMetric.compare(document, document1)
  }

  def computeRefinedSoundexFn = udf { (document: String) =>
    RefinedSoundexAlgorithm.compute(document)
  }

  def soundexFn = udf { (document: String, document1: String) =>
    SoundexMetric.compare(document, document1)
  }

  def computeSoundexFn = udf { (document: String) =>
    SoundexAlgorithm.compute(document)
  }

   
}
