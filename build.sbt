name := "q42-assignment"

version := "1.0"

scalaVersion := "2.10.2"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies += "org.scalatest" %% "scalatest" % "1.9.1" % "test"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

libraryDependencies +=
  "org.scalamock" %% "scalamock-scalatest-support" % "3.0.1" % "test"

org.scalastyle.sbt.ScalastylePlugin.Settings
