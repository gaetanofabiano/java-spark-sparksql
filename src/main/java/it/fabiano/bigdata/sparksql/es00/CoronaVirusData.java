package it.fabiano.bigdata.sparksql.es00;



import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;

/**
 * Java-Spark-Webinar
 *
 * @author  Gaetano Fabiano
 * @version 1.0.0
 * @since   2020-07-09

 Data From https://github.com/pcm-dpc/COVID-19
*/

public class CoronaVirusData {

  

    public static void main(String[] args) throws Exception {

    	
    	// No for Spark, this is just for downaload data from https://github.com/pcm-dpc/COVID-19 
    	// Sito del Dipartimento della Protezione Civile - Emergenza Coronavirus: la risposta nazionale
    	
    	String coronaDataItalia ="https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-province/dpc-covid19-ita-province.csv";
    	String tempFileName = "in/temp.csv";
    	it.fabiano.bigdata.sparksql.WebCSVReader.getAndSaveContent(coronaDataItalia,tempFileName);
    	
    	
    	// Init a SparkSession  
        SparkSession sparkSession = SparkSession.builder().appName("SparkSQLDataset").master("local[*]").getOrCreate();
        
        
      

        Dataset<Row> coronaDataFrame = 
        		sparkSession.read()
        		.option("header", "true")
        		.csv(tempFileName);
        
        
        SQLContext sqlContext = new SQLContext(sparkSession);
        
        coronaDataFrame.printSchema();
        
        sqlContext.registerDataFrameAsTable(coronaDataFrame, "coronaDataFrame");
        
        Dataset<Row> coronaItalia = sqlContext.sql(
        		  "SELECT *"
        		+ "FROM coronaDataFrame ");        
       
        
        coronaItalia.show(100);
        
      
        
        Dataset<Row> maxPerProvincia = 
        		coronaItalia.withColumn("totale_casi", 
        				coronaItalia.col("totale_casi").cast("long"))
        		.groupBy(coronaItalia.col("denominazione_provincia"))
        		.max("totale_casi");
        
       
         
        maxPerProvincia.show(200);
        
        sparkSession.cloneSession();
      
       
    }
    
    
}

