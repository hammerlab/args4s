package org.hammerlab.args4s

import org.hammerlab.paths.Path
import org.kohsuke.args4j.spi.Setter
import org.kohsuke.args4j.{ CmdLineParser, OptionDef }

/**
 * Options of type [[Option[Path]]] will box their [[Path]] during instantiation/assignment, so this [[Handler]] uses
 * [[Path]] instead of [[java.nio.file.Path]] (see [[PathHandler]] / [[JPathHandler]]).
 */
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
