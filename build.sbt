name := "TestElevio"

version := "0.1"

scalaVersion := "2.12.0"

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.4",
  "net.liftweb" %% "lift-json" % "3.3.0"
)