import xerial.sbt.Sonatype._

publishMavenStyle := true

sonatypeProfileName := "itspawanbhardwaj"
sonatypeProjectHosting := Some(GithubHosting(user="itspawanbhardwaj", repository="spark-fuzzy-matching", email="bhardwaj.2391@gmail.com"))
developers := List(
  Developer(id = "itspawanbhardwaj", name = "Pawan Bhardwaj", email = "bhardwaj.2391@gmail.com", url = url("https://github.com/itspawanbhardwaj"))
)
licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

publishTo := sonatypePublishTo.value