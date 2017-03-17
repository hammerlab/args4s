package org.hammerlab.args4s

import org.kohsuke.args4j.{ CmdLineParser, OptionDef }
import org.kohsuke.args4j.spi.{ Parameters, Setter }
import org.kohsuke.args4j

/**
 * Handler for parsing a comma-delimited list of strings.
 */
class StringsOptionHandler(parser: CmdLineParser,
                           option: OptionDef,
                           setter: Setter[String])
  extends args4j.spi.OptionHandler[String](
    parser,
    option,
    setter
  ) {
    override def getDefaultMetaVariable: String = "STRING[]"
    override def parseArguments(params: Parameters): Int = {
        params.getParameter(0).split(",").foreach(setter.addValue)
        1
    }
}
