name := "args4s"
version := "1.2.0-SNAPSHOT"

deps += libs.value('args4j)

providedDeps += libs.value('hadoop)

// Scala 2.11 version seems to work fine for other Scala binary versions.
noCrossPublishing
