package org.hammerlab.args4s

import org.kohsuke.args4j.spi.Setter
import org.kohsuke.args4j.{ CmdLineParser, OptionDef }

class OptionHandler[T](parser: CmdLineParser,
                       option: OptionDef,
                       setter: Setter[Option[T]],
                       defaultMetaVariable: String,
                       fn: String ⇒ T)
  extends Handler[Option[T]](
    parser,
    option,
    setter,
    defaultMetaVariable,
    s ⇒ Some(fn(s))
  )
