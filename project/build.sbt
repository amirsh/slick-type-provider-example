organization := "com.typesafe.slick"

name := "slick-typeproviders"

version := "1.0.0"

scalacOptions += "-deprecation"

libraryDependencies ++= List(
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.h2database" % "h2" % "1.3.170",
  "org.xerial" % "sqlite-jdbc" % "3.6.20"
)