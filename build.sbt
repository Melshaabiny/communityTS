name := """communityTS"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)
PlayKeys.fileWatchService:=play.runsupport.FileWatchService.sbt(2000)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "org.mindrot" % "jbcrypt" % "0.3m",
  "org.webjars" % "bootstrap" % "3.3.5",
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41"
)
// FOR PRODUCTION, ENSURE YOU ARE USING LATEST VERSION OF BCRYPT LIB

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
