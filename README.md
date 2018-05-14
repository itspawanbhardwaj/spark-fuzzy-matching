

## Metrics and algorithms

* __[Dice / Sorensen](http://en.wikipedia.org/wiki/Dice%27s_coefficient)__ (Similarity metric)
* __[Double Metaphone](http://en.wikipedia.org/wiki/Metaphone)__  phonetic metric and algorithm)
* __[Hamming](http://en.wikipedia.org/wiki/Hamming_distance)__ (Similarity metric)
* __[Jaccard](http://en.wikipedia.org/wiki/Jaccard_index)__ (Similarity metric)
* __[Jaro](http://en.wikipedia.org/wiki/Jaro-Winkler_distance)__ (Similarity metric)
* __[Jaro-Winkler](http://en.wikipedia.org/wiki/Jaro-Winkler_distance)__ (Similarity metric)
* __[Levenshtein](http://en.wikipedia.org/wiki/Levenshtein_distance)__ (Similarity metric)
* __[Metaphone](http://en.wikipedia.org/wiki/Metaphone)__ (Phonetic metric and algorithm)
* __[Monge-Elkan](http://www.cs.cmu.edu/~pradeepr/papers/ijcai03.pdf)__  similarity metric)
* __[Match Rating Approach](http://en.wikipedia.org/wiki/Match_rating_approach)__  phonetic metric and algorithm)
* __[Needleman-Wunch](http://en.wikipedia.org/wiki/Needleman%E2%80%93Wunsch_algorithm)__  similarity metric)
* __[N-Gram](http://en.wikipedia.org/wiki/N-gram)__ (Similarity metric)
* __[NYSIIS](http://en.wikipedia.org/wiki/New_York_State_Identification_and_Intelligence_System)__ (Phonetic metric and algorithm)
* __[Overlap](http://en.wikipedia.org/wiki/Overlap_coefficient)__ (Similarity metric)
* __[Ratcliff-Obershelp](http://xlinux.nist.gov/dads/HTML/ratcliffObershelp.html)__ (Similarity metric)
* __[Refined NYSIIS](http://www.markcrocker.com/rexxtipsntricks/rxtt28.2.0482.html)__ (Phonetic metric and algorithm)
* __[Refined Soundex](http://ntz-develop.blogspot.com/2011/03/phonetic-algorithms.html)__ (Phonetic metric and algorithm)
* __[Tanimoto](http://en.wikipedia.org/wiki/Tanimoto_coefficient)__  similarity metric)
* __[Tversky](http://en.wikipedia.org/wiki/Tversky_index)__  similarity metric)
* __[Smith-Waterman](http://en.wikipedia.org/wiki/Smith%E2%80%93Waterman_algorithm)__  similarity metric)
* __[Soundex](http://en.wikipedia.org/wiki/Soundex)__ (Phonetic metric and algorithm)
* __Weighted Levenshtein__ (Similarity metric)


## Functions

*  All functions are defined under `com.pb.fuzzy.matching.functions`.

  import com.pb.fuzzy.matching.functions._ // import to use fuzzy matching functions
~~~
  
  levenshteinFn(document, document1)
  diceSorensenFn(document, document1, nGramSize)
  hammingFn(document, document1)
  jaccardFn(document, document1, nGramSize)
  jaroFn(document, document1)
  jaroWinklerFn(document, document1)
  nGramFn(document, document1, nGramSize)
  overlapFn(document, document1, nGramSize)
  ratcliffObershelpFn(document, document1)
  weightedLevenshteinFn(document, document1, deleteWeight, insertWeight, substituteWeight)
  metaphoneFn(document, document1)
  computeMetaphoneFn(document)
  nysiisFn(document, document1)
  computeNysiisFn(document)
  refinedNysiisFn(document, document1)
  computeRefinedNysiisFn(document)
  refinedSoundexFn(document, document1)
  computeRefinedSoundexFn(document)
  soundexFn(document, document1)
  computeSoundexFn(document)
~~~


## Example
The project contains a FuzzyMatchingJoinExample which works as follows:

~~~
Dataset with proper names
+--------------------+--------------------+-------+
|               title|               gener|ratings|
+--------------------+--------------------+-------+
|The Shawshank Red...|        Crime. Drama|    9.3|
|       The Godfather|        Crime. Drama|    9.2|
|     The Dark Knight|Action. Crime. Drama|    9.0|
|The Godfather: Pa...|        Crime. Drama|    9.0|
|        Pulp Fiction|        Crime. Drama|    8.9|
+--------------------+--------------------+-------+
only showing top 5 rows

Dataset with misspelled names
+--------------------+----+--------+
|               title|year|duration|
+--------------------+----+--------+
|dhe Shwshnk Redem...|1994|     142|
|        dhe Godfdher|1972|     175|
|      dhe Drk Knighd|2008|     152|
|dhe Godfdher: Prd II|1974|     202|
|        Pulp Ficdion|1994|     154|
+--------------------+----+--------+
only showing top 5 rows

Dataset after fuzzy join
+--------------------+--------------------+-------+--------------------+----+--------+
|               title|               gener|ratings|               title|year|duration|
+--------------------+--------------------+-------+--------------------+----+--------+
|The Shawshank Red...|        Crime. Drama|    9.3|dhe Shwshnk Redem...|1994|     142|
|       The Godfather|        Crime. Drama|    9.2|        dhe Godfdher|1972|     175|
|     The Dark Knight|Action. Crime. Drama|    9.0|      dhe Drk Knighd|2008|     152|
|        Pulp Fiction|        Crime. Drama|    8.9|        Pulp Ficdion|1994|     154|
|    Schindler's List|Biography. Drama....|    8.9|    Schindler's Lisd|1993|     195|
+--------------------+--------------------+-------+--------------------+----+--------+
only showing top 5 rows
~~~

## Library used

__[stringmetric](https://github.com/rockymadden/stringmetric)__ ( :dart: String metrics and phonetic algorithms for Scala (e.g. Dice/Sorensen, Hamming, Jaccard, Jaro, Jaro-Winkler, Levenshtein, Metaphone, N-Gram, NYSIIS, Overlap, Ratcliff/Obershelp, Refined NYSIIS, Refined Soundex, Soundex, Weighted Levenshtein). )
