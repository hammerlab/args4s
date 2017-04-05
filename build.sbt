name := "args4s"
version := "1.2.2"

deps ++= Seq(
  libs.value('args4j),
  libs.value('paths)
)

// Scala 2.11 version seems to work fine for other Scala binary versions.
noCrossPublishing
