name := "args4s"
version := "1.2.4"

deps ++= Seq(
  args4j,
  paths % "1.2.0"
)

// Scala 2.11 version seems to work fine for other Scala binary versions.
noCrossPublishing
