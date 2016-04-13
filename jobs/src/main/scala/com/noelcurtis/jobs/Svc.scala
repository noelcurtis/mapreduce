package com.noelcurtis.jobs
import org.apache.spark.{SparkConf, SparkContext}

object Svc extends App {

  println("Starting map reduce ...")

  val conf = new SparkConf().setAppName("Test Application")
  val sc = SparkContext.getOrCreate(conf)
  sc.setLogLevel("INFO")

  TestJob("/Users/ncurtis/Workspace/spark/mapreduce/lorem.txt", sc).execute()

  println("Complete!")
}
