package org.hammerlab.args4s

import org.kohsuke.args4j.spi.Setter
import org.kohsuke.args4j.{ CmdLineParser, OptionDef }

/**
 * Args4J option handler that populates an [[Option[Int]]].
 */
class IntOptionHandler(parser: CmdLineParser,
                       option: OptionDef,
                       setter: Setter[Option[Int]])
  extends OptionHandler[Int](
    parser,
    option,
    setter,
    "INT",
    _.toInt
  )
