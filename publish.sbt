organization := "com.github.itspawanbhardwaj"
organizationName := "pb"
organizationHomepage := Some(url("https://github.com/itspawanbhardwaj/spark-fuzzy-matching"))

scmInfo := Some(
  ScmInfo(
    url("https://github.com/itspawanbhardwaj/spark-fuzzy-matching"),
    "scm:git@github.com:itspawanbhardwaj/spark-fuzzy-matching.git"
  )
)
developers := List(
  Developer(
    id    = "itspawanbhardwaj",
    name  = "Pawan Bhardwaj",
    email = "bhardwaj.2391@gmail.com",
    url   = url("https://github.com/itspawanbhardwaj/spark-fuzzy-matching")
  )
)

description := "Implementation of fuzzy matching algorithms in spark"
licenses := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
homepage := Some(url("https://github.com/itspawanbhardwaj/spark-fuzzy-matching"))

// Remove all additional repository other than Maven Central from POM
pomIncludeRepository := { _ => false }
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
publishMavenStyle := true