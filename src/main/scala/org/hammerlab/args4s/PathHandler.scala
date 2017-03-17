package org.hammerlab.args4s

import org.apache.hadoop.fs.Path
import org.kohsuke.args4j.spi.Setter
import org.kohsuke.args4j.{ CmdLineParser, OptionDef }

class PathHandler(parser: CmdLineParser,
                  option: OptionDef,
                  setter: Setter[Path])
  extends Handler[Path](
    parser,
    option,
    setter,
    "PATH",
    new Path(_)
  )
