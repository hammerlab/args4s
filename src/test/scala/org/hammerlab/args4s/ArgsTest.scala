package org.hammerlab.args4s

import org.apache.hadoop.fs.Path
import org.hammerlab.test.Suite
import org.kohsuke.args4j
import org.kohsuke.args4j.CmdLineParser

import scala.collection.JavaConversions._

class Args {
  @args4j.Option(
    name = "--str",
    handler = classOf[StringOptionHandler]
  )
  var strOpt: Option[String] = None

  @args4j.Option(
    name = "--int",
    handler = classOf[IntOptionHandler]
  )
  var intOpt: Option[String] = None

  @args4j.Option(
    name = "--path",
    handler = classOf[PathHandler]
  )
  var path: Path = _

  @args4j.Option(
    name = "--path-opt",
    handler = classOf[PathOptionHandler]
  )
  var pathOpt: Option[Path] = None

  @args4j.Option(
    name = "--strings",
    handler = classOf[StringsOptionHandler]
  )
  var strings: Array[String] = Array()

  @args4j.Argument(
    metaVar = "<PATHS>",
    multiValued = true,
    handler = classOf[PathHandler]
  )
  var paths: Array[Path] = Array()
}

class ArgsTest
  extends Suite {
  test("parse") {
    val args = new Args
    val parser = new CmdLineParser(args)
    parser.parseArgument(
      Seq(
        "--str", "abc",
        "--path", "http://a/b/c",
        "--path-opt", "dd/ee/ff",
        "--strings", "aaa,bbb,ccc",
        "gg/hh/ii", "ftp://jj/kk"
      )
    )

    args.strOpt should be(Some("abc"))
    args.intOpt should be(None)
    args.path should be(new Path("http://a/b/c"))
    args.pathOpt should be(Some(new Path("dd/ee/ff")))
    args.strings should be(Array("aaa", "bbb", "ccc"))
    args.paths should be(Array(new Path("gg/hh/ii"), new Path("ftp://jj/kk")))
  }
}
