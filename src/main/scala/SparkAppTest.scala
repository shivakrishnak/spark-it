import org.apache.spark.sql.SparkSession

object SparkAppTest {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
    val spark = SparkSession.builder().master("local").appName("test").getOrCreate()

    println("First SparkContext:")
    println("APP Name :" + spark.sparkContext.appName);
    println("Deploy Mode :" + spark.sparkContext.deployMode);
    println("Master :" + spark.sparkContext.master);
    println("ApplicationId :" +spark.sparkContext.applicationId)
  }
}