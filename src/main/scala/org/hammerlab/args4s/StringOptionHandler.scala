package org.hammerlab.args4s

import org.kohsuke.args4j.spi.Setter
import org.kohsuke.args4j.{ CmdLineParser, OptionDef }

/**
 * Args4J option handler that populates an [[Option[String]]].
 */
class StringOptionHandler(parser: CmdLineParser,
                          option: OptionDef,
                          setter: Setter[Option[String]])
  extends OptionHandler[String](
    parser,
    option,
    setter,
    "VAL",
    s ⇒ s
  )
