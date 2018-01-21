// Your sbt build file. Guides on how to write one can be found at
// http://www.scala-sbt.org/0.13/docs/index.html

organization := "pb"

name := "spark-fuzzy-matching"

version := "0.0.1"

crossScalaVersions := Seq("2.11.8", "2.10.6")

initialize := {
  val _ = initialize.value
  val required = VersionNumber("1.8")
  val current = VersionNumber(sys.props("java.specification.version"))
  assert(VersionNumber.Strict.isCompatible(current, required), s"Java $required required.")
}

sparkVersion := "2.0.0"

// change the value below to change the directory where your zip artifact will be created
spDistDirectory := target.value

spAppendScalaVersion := true

//credentials += Credentials(Path.userHome / ".ivy2" / ".sbtcredentials")

sparkComponents += "sql"

// add any sparkPackageDependencies using sparkPackageDependencies.
// e.g. sparkPackageDependencies += "pb/spark-avro:0.1"
spName := "pb/spark-fuzzy-matching"

licenses := Seq("GPL-3.0" -> url("http://opensource.org/licenses/GPL-3.0"))

resolvers += Resolver.mavenLocal

resolvers ++= Seq(
  "string metric core" at  "https://mvnrepository.com/artifact/"
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "com.rockymadden.stringmetric" %% "stringmetric-core" % "0.27.3"

)
