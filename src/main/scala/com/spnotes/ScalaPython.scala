package com.spnotes

import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by sunilpatil on 2/2/16.
  */
object ScalaPython {

  def main(argv:Array[String]): Unit ={
    System.out.println("Entering ScalaPython.main")
    if(argv.length != 1){
      println("Please provide 1 parameters <inputFileName>")
      System.exit(1)
    }
    val fileName = argv(0)
    val sparkConf = new SparkConf().setAppName("ScalaPython").setMaster("local")
    val sparkContext = new SparkContext(sparkConf)

    val lines = sparkContext.textFile(fileName)
    println("Print lines from original file")
    lines.foreach(println)
    val lines1 = lines.pipe("src/main/resources/echo.py")
    println("Print lines returned from python")

    lines1.foreach(println)
    System.out.println("Exiting ScalaPython.main")

  }

}
