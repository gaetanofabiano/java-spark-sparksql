package it.fabiano.bigdata.sparksql.es00;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;
/**
* Java-Spark-Training-Course
*
* @author  Gaetano Fabiano
* @version 1.1.0
* @since   2019-07-19 
* @updated 2020-07-01 
*/

public class RegisterDataFrameAsTable {

  

    public static void main(String[] args) throws Exception {

    	
        SparkSession session = SparkSession.builder().appName("SparkSQLDataset").master("local[1]").getOrCreate();

        Dataset<Row> realEstate = session.read().option("header", "true").csv("in/RealEstate.csv");
        
       
        SQLContext sqlContext = new SQLContext(session);
        
        sqlContext.registerDataFrameAsTable(realEstate, "realEstate");
        
        Dataset<Row> dataSetFromSQL = sqlContext.sql(
        		  "SELECT count(*)"
        		+ "FROM realEstate");
        
       
        dataSetFromSQL.show(10);
    }
}
