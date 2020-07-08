package it.fabiano.bigdata.sparksql.es01;

import static it.fabiano.bigdata.sparksql.Utils.COMMA_DELIMITER;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;
/**
* Java-Spark-Training-Course
*
* @author  Gaetano Fabiano
* @version 1.1.0
* @since   2019-07-19 
* @updated 2020-07-01 
*/
public class RddDatasetConversion {

    public static void main(String[] args) throws Exception {
        Logger.getLogger("org").setLevel(Level.ERROR);
        SparkConf conf = new SparkConf().setAppName("RddDatasetConversion").setMaster("local[1]");

        JavaSparkContext sc = new JavaSparkContext(conf);

        SparkSession session = SparkSession.builder().appName("StackOverFlowSurvey").master("local[1]").getOrCreate();

        JavaRDD<String> lines = sc.textFile("in/2016-stack-overflow-survey-responses.csv");

        JavaRDD<ResponsePOJO> responseRDD = lines
                .filter(line -> !line.split(COMMA_DELIMITER, -1)[2].equals("country"))
                .map(line -> {
                    String[] splits = line.split(COMMA_DELIMITER, -1);
                    return new ResponsePOJO(splits[2], toInt(splits[6]), splits[9], toInt(splits[14]));
                });
        Dataset<ResponsePOJO> responseDataset = session.createDataset(responseRDD.rdd(), Encoders.bean(ResponsePOJO.class));

        System.out.println("=== Print out schema ===");
        responseDataset.printSchema();

        System.out.println("=== Print 20 records of responses table ===");
        responseDataset.show(20);

        
        //Conversion here
        JavaRDD<ResponsePOJO> responseJavaRDD = responseDataset.toJavaRDD();
        for (ResponsePOJO response : responseJavaRDD.collect()) {
            System.out.println(response);
        }
    }
    private static Integer toInt(String split) {
        return split.isEmpty() ? null : Math.round(Float.valueOf(split));
    }
}
