name := "landing-page"
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  guice,
  javaJdbc,
  "org.postgresql" % "postgresql" % "42.2.5",
  "io.ebean" % "ebean" % "11.39.1",
  "io.ebean" % "ebean-agent" % "11.39.1",
  "io.ebean" % "ebean-annotation" % "4.11",
  "org.webjars" % "bootstrap" % "4.6.0",
  "org.webjars" % "chartjs" % "2.9.4"
)

playEbeanModels in Compile := Seq("models.*")
playEbeanDebugLevel := 4
