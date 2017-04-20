package org.hammerlab.args4s

import java.io.ByteArrayOutputStream

import org.hammerlab.paths.Path
import org.hammerlab.test.Suite
import org.kohsuke.args4j
import org.kohsuke.args4j.CmdLineParser

import scala.collection.JavaConversions._

class Args {
  @args4j.Option(
    name = "--str",
    handler = classOf[StringOptionHandler],
    usage = "An optional string"
  )
  var strOpt: Option[String] = None

  @args4j.Option(
    name = "--int",
    handler = classOf[IntOptionHandler],
    usage = "An int"
  )
  var intOpt: Option[String] = None

  @args4j.Option(
    name = "--path",
    handler = classOf[PathHandler],
    usage = "A path"
  )
  var path: Path = _

  @args4j.Option(
    name = "--path-opt",
    handler = classOf[PathOptionHandler],
    usage = "An optional path"
  )
  var pathOpt: Option[Path] = None

  @args4j.Option(
    name = "--strings",
    handler = classOf[StringsOptionHandler],
    usage = "Some strings"
  )
  var strings: Array[String] = Array()

  @args4j.Argument(
    metaVar = "<PATHS>",
    multiValued = true,
    handler = classOf[PathHandler],
    usage = "Path arguments"
  )
  var paths: Array[Path] = Array()
}

class ArgsTest
  extends Suite {
  test("parse") {
    val args = new Args
    val parser = new CmdLineParser(args)

    val ss = new ByteArrayOutputStream
    parser.printUsage(ss)
    ss.toString("UTF-8") should be(
      """ <PATHS>            : Path arguments
        | --int INT          : An int (default: None)
        | --path PATH        : A path
        | --path-opt PATH    : An optional path (default: None)
        | --str VAL          : An optional string (default: None)
        | --strings STRING[] : Some strings
        |"""
      .stripMargin('|')
    )

    parser.parseArgument(
      Seq(
        "--str", "abc",
        "--path", "file:///a/b/c",
        "--path-opt", "dd/ee/ff",
        "--strings", "aaa,bbb,ccc",
        "gg/hh/ii", "file:///jj/kk"
      )
    )

    args.strOpt should be(Some("abc"))
    args.intOpt should be(None)
    args.path should be(Path("file:///a/b/c"))
    args.pathOpt should be(Some(Path("dd/ee/ff")))
    args.strings should be(Array("aaa", "bbb", "ccc"))
    args.paths should be(Array(Path("gg/hh/ii"), Path("file:///jj/kk")))
  }
}
