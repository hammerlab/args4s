package org.hammerlab.args4s

import java.nio.file.{ Path ⇒ JPath }

import org.hammerlab.paths.Path
import org.kohsuke.args4j.spi.Setter
import org.kohsuke.args4j.{ CmdLineParser, OptionDef }

/**
 * Since [[Path]] is an [[AnyVal]], options with type [[Path]] end up as type [[java.nio.file.Path]] at run-time, and
 * should be used with this [[Handler]].
 */
class JPathHandler(parser: CmdLineParser,
                   option: OptionDef,
                   setter: Setter[JPath])
  extends Handler[JPath](
    parser,
    option,
    setter,
    "PATH",
    Path(_).path
  )

/**
 * Options that have type [[Array[Path]]] will box [[Path]]s, and so should be fed this [[Handler]].
 */
class PathHandler(parser: CmdLineParser,
                  option: OptionDef,
                  setter: Setter[Path])
  extends Handler[Path](
    parser,
    option,
    setter,
    "PATH",
    Path(_)
  )
