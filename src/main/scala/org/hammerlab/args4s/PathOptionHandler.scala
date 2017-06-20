package org.hammerlab.args4s

import org.hammerlab.paths.Path
import org.kohsuke.args4j.spi.Setter
import org.kohsuke.args4j.{ CmdLineParser, OptionDef }

class PathOptionHandler(parser: CmdLineParser,
                        option: OptionDef,
                        setter: Setter[Option[Path]])
  extends OptionHandler[Path](
    parser,
    option,
    setter,
    "PATH",
    Path(_)
  )
