package week1

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]): Unit = {
    println("Week 1 - Assignment: Recursion")
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {

    @tailrec
    def compare(a: List[Char], numOpen: Int): Boolean = {
      if (a.isEmpty || numOpen < 0)
        numOpen == 0
      else if (a.head == '(')
        compare(a.tail, numOpen + 1)
      else if (a.head == ')')
        compare(a.tail, numOpen - 1)
      else
        compare(a.tail, numOpen)
    }

    compare(chars, 0)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    // can use memoization

    if (money == 0) 1
    else if (money < 0) 0
    else if (coins.length <= 0 && money >= 1) 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
}
