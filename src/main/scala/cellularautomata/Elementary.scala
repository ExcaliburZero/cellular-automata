package cellularautomata

import scala.annotation.tailrec

object Elementary {
  type Cell = Boolean
  type Generation = Array[Cell]

  val DEFAULT_RULE: Int = 110
  val DEFAULT_RANGE: Int = 1
  val DEFAULT_SIZE: Int = 80
  val DEFAULT_EMPTY: Char = ' '
  val DEFAULT_FILLED: Char = '█'

  val DEFAULT_INTERVAL: Int = 75
}

class Elementary {
  var rule: Int = Elementary.DEFAULT_RULE
  var range: Int = Elementary.DEFAULT_RANGE
  var size: Int = Elementary.DEFAULT_SIZE
  var empty: Char = Elementary.DEFAULT_EMPTY
  var filled: Char = Elementary.DEFAULT_FILLED

  var interval: Int = Elementary.DEFAULT_INTERVAL

  def setRule(rule: Int): Elementary = {
    this.rule = rule
    this
  }

  def setRange(range: Int): Elementary = {
    this.range = range
    this
  }

  def setSize(size: Int): Elementary = {
    this.size = size
    this
  }

  def setEmpty(empty: Char): Elementary = {
    this.empty = empty
    this
  }

  def setFilled(filled: Char): Elementary = {
    this.filled = filled
    this
  }

  def setInterval(interval: Int): Elementary = {
    this.interval = interval
    this
  }

  def run(): Unit = {
    val initialGeneration = new Elementary.Generation(size)
    initialGeneration.update(size / 2, true)

    runLoop(initialGeneration)
  }

  @tailrec
  private def runLoop(generation: Elementary.Generation): Unit = {
    printGeneration(generation)

    Thread.sleep(interval)
    runLoop(nextGeneration(generation))
  }

  private def nextGeneration(prevCells: Elementary.Generation): Elementary.Generation = {
    val newCells = for (i <- 0 until size) yield {
      val neighbors = getNeighbors(prevCells, i)
      nextState(neighbors)
    }

    newCells.toArray
  }

  private def getNeighbors(prevCells: Elementary.Generation, i: Int): Array[Elementary.Cell] = {
    val rangeLength = range * 2 + 1
    val start = range * -1
    val end = range + 1

    val neighbors = for (n <- start until end) yield {
      val c = Math.abs((i + n) % size)
      prevCells(c)
    }

    neighbors.toArray
  }

  private def nextState(neighbors: Array[Elementary.Cell]): Boolean = {
    val number = boolArrayToBinary(neighbors)
    val mask = 1 << number

    val bit = (rule & mask) >> number
    bit == 1
  }

  private def boolArrayToBinary(bools: Array[Boolean]): Int = {
    var num = 0

    for (b <- bools) {
      num = (num << 1) + (if(b) 1 else 0)
    }

    num
  }

  private def printGeneration(generation: Elementary.Generation): Unit = {
    val printStr = for (c <- generation) yield {
      if (c) {
        filled
      } else {
        empty
      }
    }

    println(new String(printStr))
  }
}
