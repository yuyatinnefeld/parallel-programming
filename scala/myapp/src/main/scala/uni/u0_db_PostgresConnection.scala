package uni
import java.sql.{Connection, DriverManager, ResultSet}
import java.util.Properties
import scala.sys.props


object u0_db_PostgresConnection extends App{
  println("Postgres connector")

  classOf[org.postgresql.Driver]

  //val url = "jdbc:postgresql://localhost:5432/DBNAME?user=DBUSER&password=DBPWD"
  val url = "jdbc:postgresql://localhost/scala_db?user=scala_db&password=password"
  val conn = DriverManager.getConnection(url)


  //val jdbcDF = spark.read.format("jdbc").option("url", "jdbc:postgresql:scala_db").option("person", "schema.person").option("user", "scala_db").option("password", "password").load()


}
