package com.spnotes

import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by sunilpatil on 2/2/16.
  */
object ScalaPython {

  def main(argv:Array[String]): Unit ={
    System.out.println("Entering ScalaPython.main")
    val sparkConf = new SparkConf().setAppName("ScalaPython").setMaster("local")
    val sparkContext = new SparkContext(sparkConf)

    val lines = sparkContext.textFile("/Users/sunilpatil/Downloads/pumpsmall.log")
    val lines1 = lines.pipe("src/main/resources/echo.py")

    lines1.foreach(println)
    System.out.println("Exiting ScalaPython.main")

  }

}
