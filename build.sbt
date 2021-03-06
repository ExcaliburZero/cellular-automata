name := "cellularautomata"

version := "1.0"

scalaVersion := "2.12.1"

mainClass in Compile := Some("cellularautomata.Main")

libraryDependencies += "org.rogach" %% "scallop" % "3.1.1"

// Linting
resolvers += Resolver.sonatypeRepo("snapshots")
addCompilerPlugin("org.psywerx.hairyfotr" %% "linter" % "0.1-SNAPSHOT")
