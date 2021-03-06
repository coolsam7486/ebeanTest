name := """ebeantest"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
 javaJdbc,
  cache,
  javaCore,
  javaWs,
  evolutions,
  filters,
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

lazy val myProject = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)
