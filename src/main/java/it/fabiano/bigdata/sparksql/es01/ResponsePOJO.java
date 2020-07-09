package it.fabiano.bigdata.sparksql.es01;

import java.io.Serializable;
/**
* Java-Spark-Training-Course
*
* @author  Gaetano Fabiano
* @version 1.1.0
* @since   2019-07-19 
* @updated 2020-07-01 
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ageMidPoint == null) ? 0 : ageMidPoint.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((occupation == null) ? 0 : occupation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponsePOJO other = (ResponsePOJO) obj;
		if (ageMidPoint == null) {
			if (other.ageMidPoint != null)
				return false;
		} else if (!ageMidPoint.equals(other.ageMidPoint))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (occupation == null) {
			if (other.occupation != null)
				return false;
		} else if (!occupation.equals(other.occupation))
			return false;
		return true;
	}

    
}
