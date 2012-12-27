package play.utils

object Colors {

  import scala.Console._

  lazy val isANSISupported = {
    Option(System.getProperty("sbt.log.noformat")).map(_ != "true").orElse {
      Option(System.getProperty("os.name"))
        .map(!_.toLowerCase.contains("windows"))
    }.getOrElse(true)
  }

  def wrap(colorCode: String)(str: String): String = if (isANSISupported) (colorCode + str + RESET) else str

  val red: String => String = wrap(RED)

  val blue: String => String = wrap(BLUE)

  val cyan: String => String = wrap(CYAN)

  val green: String => String = wrap(GREEN)

  val magenta: String => String = wrap(MAGENTA)

  val white: String => String = wrap(WHITE)

  val black: String => String = wrap(BLACK)

  val yellow: String => String = wrap(YELLOW)

}