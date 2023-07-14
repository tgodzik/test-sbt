organization := "com.example"
scalaVersion := "2.13.11"
name := "metals-sample"
scalacOptions ++= Seq(
  "-Yrangepos",
  "-P:semanticdb:failures:warning",
  "-P:semanticdb:synthetics:on",
  "-Xplugin-require:semanticdb",
  "-P:semanticdb:sourceroot:" +
    baseDirectory.in(ThisBuild).value.toString
)

libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
testFrameworks += new TestFramework("munit.Framework")

addCompilerPlugin(
  "org.scalameta" % "semanticdb-scalac" % "4.8.4" cross CrossVersion.full
)
