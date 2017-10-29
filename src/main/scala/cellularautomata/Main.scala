package cellularautomata

import org.rogach.scallop._

object Main {
  def main(args: Array[String]): Unit = {
    val conf = new Conf(args)
    //val ca = new Elementary()
    //ca.run()
    conf.subcommand match {
      case None =>
        val ca = new Elementary()
        ca.run()
      case Some(conf.elementary) =>
        runElementary(conf)
      case Some(_) =>
        ()
    }
  }

  private def runElementary(conf: Conf): Unit = {
    val ca = new Elementary()

    if (conf.elementary.rule.isSupplied) {
      ca.setRule(conf.elementary.rule())
    }
    if (conf.elementary.range.isSupplied) {
      ca.setRange(conf.elementary.range())
    }
    if (conf.elementary.size.isSupplied) {
      ca.setSize(conf.elementary.size())
    }
    if (conf.elementary.empty.isSupplied) {
      ca.setEmpty(conf.elementary.empty())
    }
    if (conf.elementary.filled.isSupplied) {
      ca.setFilled(conf.elementary.filled())
    }
    if (conf.elementary.interval.isSupplied) {
      ca.setInterval(conf.elementary.interval())
    }
    if (conf.elementary.generation.isSupplied) {
      println("Enter the initial generation:")
      val line = readLine().toCharArray
      ca.setGeneration(line.map(_ != ' '))
    }

    ca.run()
  }
}

class Conf(arguments: Seq[String]) extends ScallopConf(arguments) {
  val elementary = new Subcommand("elementary") {
    val rule = opt[Int]()
    val range = opt[Int]()
    val size = opt[Int]()
    val empty = opt[Char]()
    val filled = opt[Char]()

    val interval = opt[Int]()
    val generation = opt[Boolean]()
  }
  addSubcommand(elementary)

  verify()
}
