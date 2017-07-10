name := "args4s"
version := "1.2.4-SNAPSHOT"

deps ++= Seq(
  args4j,
  paths % "1.1.1-SNAPSHOT"
)

// Scala 2.11 version seems to work fine for other Scala binary versions.
noCrossPublishing
