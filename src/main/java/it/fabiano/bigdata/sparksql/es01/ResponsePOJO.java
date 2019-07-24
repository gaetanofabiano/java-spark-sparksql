package it.fabiano.bigdata.sparksql.es01;

import java.io.Serializable;
/**
* Java-Spark-Training-Course
*
* @author  Gaetano Fabiano
* @version 1.0.0
* @since   2019-07-19 
*/
public class ResponsePOJO implements Serializable {
    private String country;
    private Integer ageMidPoint;
    private String occupation;
    private Integer salaryMidPoint;

    public ResponsePOJO(String country, Integer ageMidPoint, String occupation, Integer salaryMidPoint) {
        this.country = country;
        this.ageMidPoint = ageMidPoint;
        this.occupation = occupation;
        this.salaryMidPoint = salaryMidPoint;
    }

    public ResponsePOJO() {}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getAgeMidPoint() {
        return ageMidPoint;
    }

    public void setAgeMidPoint(Integer ageMidPoint) {
        this.ageMidPoint = ageMidPoint;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Integer getSalaryMidPoint() {
        return salaryMidPoint;
    }

    public void setSalaryMidPoint(Integer salaryMidPoint) {
        this.salaryMidPoint = salaryMidPoint;
    }

    @Override
    public String toString() {
        return "Response{" +
                "country='" + country + '\'' +
                ", ageMidPoint=" + ageMidPoint +
                ", occupation='" + occupation + '\'' +
                ", salaryMidPoint=" + salaryMidPoint +
                '}';
    }
}
