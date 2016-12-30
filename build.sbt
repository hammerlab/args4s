name := "args4s"
version := "1.1.0"
deps += libs.value('args4j)

// Scala 2.11 version seems to work fine for other Scala binary versions.
noCrossPublishing

// Omit default test deps
testDeps := Seq()
