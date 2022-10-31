import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object ZipCodeLocationTest extends App{

  Logger.getLogger("org").setLevel(Level.ERROR)

  val spark = SparkSession.builder().master("local").appName("zip location").getOrCreate()
  val sc = spark.sparkContext

  val rdd = sc.textFile("src/main/resources/zipcodes_no_header.csv")
  val splittedRdd = rdd.map(line => line.split(",").map(column => column.trim))
  val resultRdd = splittedRdd.filter(zip => zip(2).equalsIgnoreCase("STANDARD") && zip(4).equalsIgnoreCase("TX"))
  println(rdd)
  println(splittedRdd)
  println(resultRdd.count())
  resultRdd.map(zip => (zip(1),zip(2),zip(3))).foreach(println)
}
