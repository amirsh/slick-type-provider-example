import sbt._
import Keys._
import Tests._

object SlickBuild extends Build {

  lazy val paradiseSettings = Defaults.defaultSettings ++ Seq(
    scalaVersion := "2.11.0-SNAPSHOT",
    scalaOrganization := "org.scala-lang.macro-paradise",
    resolvers += Resolver.sonatypeRepo("snapshots"),
    libraryDependencies <+= (scalaVersion)("org.scala-lang.macro-paradise" % "scala-reflect" % _),
    libraryDependencies <+= (scalaVersion)("org.scala-lang.macro-paradise" % "scala-compiler" % _ % "optional")
  )

  val scalaSettings = {
//     paradiseSettings
//     Defaults.defaultSettings
    Project.defaultSettings ++ paradiseSettings
  }

  lazy val core = ProjectRef(file("../slick_paradise"), "slick") 

  lazy val config = Project(id = "config", base = file("config"), 
    settings = scalaSettings).dependsOn(core)

  /* Project Definitions */
  lazy val aRootProject = Project(id = "root", base = file("."),
    settings = scalaSettings).dependsOn(config)
}
