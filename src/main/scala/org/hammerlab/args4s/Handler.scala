package org.hammerlab.args4s

import org.kohsuke.args4j.{ CmdLineParser, OptionDef }
import org.kohsuke.args4j.spi.{ OptionHandler ⇒ Args4JOptionHandler, Parameters, Setter }

class Handler[T](parser: CmdLineParser,
                 option: OptionDef,
                 setter: Setter[T],
                 defaultMetaVariable: String,
                 fn: String ⇒ T)
  extends Args4JOptionHandler[T](parser, option, setter) {
  override def getDefaultMetaVariable: String = defaultMetaVariable

  override def parseArguments(params: Parameters): Int = {
    setter.addValue(fn(params.getParameter(0)))
    1
  }
}
