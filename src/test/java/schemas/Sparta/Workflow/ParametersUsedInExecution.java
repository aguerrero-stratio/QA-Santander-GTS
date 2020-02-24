
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ParametersUsedInExecution implements Serializable
{

    @SerializedName("Global.SPARK_DRIVER_MEMORY")
    @Expose
    private String globalSPARKDRIVERMEMORY;
    @SerializedName("Global.SPARK_LOCALITY_WAIT")
    @Expose
    private String globalSPARKLOCALITYWAIT;
    @SerializedName("Global.SPARK_EXECUTOR_CORES")
    @Expose
    private String globalSPARKEXECUTORCORES;
    @SerializedName("Global.SPARK_LOCAL_PATH")
    @Expose
    private String globalSPARKLOCALPATH;
    @SerializedName("Global.SPARK_CORES_MAX")
    @Expose
    private String globalSPARKCORESMAX;
    @SerializedName("Environment.JDBC_DRIVER")
    @Expose
    private String environmentJDBCDRIVER;
    @SerializedName("Global.SPARK_MEMORY_FRACTION")
    @Expose
    private String globalSPARKMEMORYFRACTION;
    @SerializedName("Environment.POSTGRES_OT_MS_URL")
    @Expose
    private String environmentPOSTGRESOTMSURL;
    @SerializedName("Global.SPARK_EXECUTOR_MEMORY")
    @Expose
    private String globalSPARKEXECUTORMEMORY;
    @SerializedName("Global.SPARK_EXECUTOR_EXTRA_JAVA_OPTIONS")
    @Expose
    private String globalSPARKEXECUTOREXTRAJAVAOPTIONS;
    @SerializedName("Global.SPARK_TASK_MAX_FAILURES")
    @Expose
    private String globalSPARKTASKMAXFAILURES;
    @SerializedName("Global.SPARK_DRIVER_JAVA_OPTIONS")
    @Expose
    private String globalSPARKDRIVERJAVAOPTIONS;
    @SerializedName("Global.SPARK_DRIVER_CORES")
    @Expose
    private String globalSPARKDRIVERCORES;
    private final static long serialVersionUID = -5044205364599242195L;

    public String getGlobalSPARKDRIVERMEMORY() {
        return globalSPARKDRIVERMEMORY;
    }

    public void setGlobalSPARKDRIVERMEMORY(String globalSPARKDRIVERMEMORY) {
        this.globalSPARKDRIVERMEMORY = globalSPARKDRIVERMEMORY;
    }

    public String getGlobalSPARKLOCALITYWAIT() {
        return globalSPARKLOCALITYWAIT;
    }

    public void setGlobalSPARKLOCALITYWAIT(String globalSPARKLOCALITYWAIT) {
        this.globalSPARKLOCALITYWAIT = globalSPARKLOCALITYWAIT;
    }

    public String getGlobalSPARKEXECUTORCORES() {
        return globalSPARKEXECUTORCORES;
    }

    public void setGlobalSPARKEXECUTORCORES(String globalSPARKEXECUTORCORES) {
        this.globalSPARKEXECUTORCORES = globalSPARKEXECUTORCORES;
    }

    public String getGlobalSPARKLOCALPATH() {
        return globalSPARKLOCALPATH;
    }

    public void setGlobalSPARKLOCALPATH(String globalSPARKLOCALPATH) {
        this.globalSPARKLOCALPATH = globalSPARKLOCALPATH;
    }

    public String getGlobalSPARKCORESMAX() {
        return globalSPARKCORESMAX;
    }

    public void setGlobalSPARKCORESMAX(String globalSPARKCORESMAX) {
        this.globalSPARKCORESMAX = globalSPARKCORESMAX;
    }

    public String getEnvironmentJDBCDRIVER() {
        return environmentJDBCDRIVER;
    }

    public void setEnvironmentJDBCDRIVER(String environmentJDBCDRIVER) {
        this.environmentJDBCDRIVER = environmentJDBCDRIVER;
    }

    public String getGlobalSPARKMEMORYFRACTION() {
        return globalSPARKMEMORYFRACTION;
    }

    public void setGlobalSPARKMEMORYFRACTION(String globalSPARKMEMORYFRACTION) {
        this.globalSPARKMEMORYFRACTION = globalSPARKMEMORYFRACTION;
    }

    public String getEnvironmentPOSTGRESOTMSURL() {
        return environmentPOSTGRESOTMSURL;
    }

    public void setEnvironmentPOSTGRESOTMSURL(String environmentPOSTGRESOTMSURL) {
        this.environmentPOSTGRESOTMSURL = environmentPOSTGRESOTMSURL;
    }

    public String getGlobalSPARKEXECUTORMEMORY() {
        return globalSPARKEXECUTORMEMORY;
    }

    public void setGlobalSPARKEXECUTORMEMORY(String globalSPARKEXECUTORMEMORY) {
        this.globalSPARKEXECUTORMEMORY = globalSPARKEXECUTORMEMORY;
    }

    public String getGlobalSPARKEXECUTOREXTRAJAVAOPTIONS() {
        return globalSPARKEXECUTOREXTRAJAVAOPTIONS;
    }

    public void setGlobalSPARKEXECUTOREXTRAJAVAOPTIONS(String globalSPARKEXECUTOREXTRAJAVAOPTIONS) {
        this.globalSPARKEXECUTOREXTRAJAVAOPTIONS = globalSPARKEXECUTOREXTRAJAVAOPTIONS;
    }

    public String getGlobalSPARKTASKMAXFAILURES() {
        return globalSPARKTASKMAXFAILURES;
    }

    public void setGlobalSPARKTASKMAXFAILURES(String globalSPARKTASKMAXFAILURES) {
        this.globalSPARKTASKMAXFAILURES = globalSPARKTASKMAXFAILURES;
    }

    public String getGlobalSPARKDRIVERJAVAOPTIONS() {
        return globalSPARKDRIVERJAVAOPTIONS;
    }

    public void setGlobalSPARKDRIVERJAVAOPTIONS(String globalSPARKDRIVERJAVAOPTIONS) {
        this.globalSPARKDRIVERJAVAOPTIONS = globalSPARKDRIVERJAVAOPTIONS;
    }

    public String getGlobalSPARKDRIVERCORES() {
        return globalSPARKDRIVERCORES;
    }

    public void setGlobalSPARKDRIVERCORES(String globalSPARKDRIVERCORES) {
        this.globalSPARKDRIVERCORES = globalSPARKDRIVERCORES;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("globalSPARKDRIVERMEMORY", globalSPARKDRIVERMEMORY).append("globalSPARKLOCALITYWAIT", globalSPARKLOCALITYWAIT).append("globalSPARKEXECUTORCORES", globalSPARKEXECUTORCORES).append("globalSPARKLOCALPATH", globalSPARKLOCALPATH).append("globalSPARKCORESMAX", globalSPARKCORESMAX).append("environmentJDBCDRIVER", environmentJDBCDRIVER).append("globalSPARKMEMORYFRACTION", globalSPARKMEMORYFRACTION).append("environmentPOSTGRESOTMSURL", environmentPOSTGRESOTMSURL).append("globalSPARKEXECUTORMEMORY", globalSPARKEXECUTORMEMORY).append("globalSPARKEXECUTOREXTRAJAVAOPTIONS", globalSPARKEXECUTOREXTRAJAVAOPTIONS).append("globalSPARKTASKMAXFAILURES", globalSPARKTASKMAXFAILURES).append("globalSPARKDRIVERJAVAOPTIONS", globalSPARKDRIVERJAVAOPTIONS).append("globalSPARKDRIVERCORES", globalSPARKDRIVERCORES).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(globalSPARKTASKMAXFAILURES).append(globalSPARKCORESMAX).append(globalSPARKDRIVERJAVAOPTIONS).append(environmentPOSTGRESOTMSURL).append(globalSPARKEXECUTORCORES).append(globalSPARKDRIVERCORES).append(globalSPARKLOCALITYWAIT).append(globalSPARKDRIVERMEMORY).append(globalSPARKLOCALPATH).append(globalSPARKMEMORYFRACTION).append(globalSPARKEXECUTOREXTRAJAVAOPTIONS).append(environmentJDBCDRIVER).append(globalSPARKEXECUTORMEMORY).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ParametersUsedInExecution) == false) {
            return false;
        }
        ParametersUsedInExecution rhs = ((ParametersUsedInExecution) other);
        return new EqualsBuilder().append(globalSPARKTASKMAXFAILURES, rhs.globalSPARKTASKMAXFAILURES).append(globalSPARKCORESMAX, rhs.globalSPARKCORESMAX).append(globalSPARKDRIVERJAVAOPTIONS, rhs.globalSPARKDRIVERJAVAOPTIONS).append(environmentPOSTGRESOTMSURL, rhs.environmentPOSTGRESOTMSURL).append(globalSPARKEXECUTORCORES, rhs.globalSPARKEXECUTORCORES).append(globalSPARKDRIVERCORES, rhs.globalSPARKDRIVERCORES).append(globalSPARKLOCALITYWAIT, rhs.globalSPARKLOCALITYWAIT).append(globalSPARKDRIVERMEMORY, rhs.globalSPARKDRIVERMEMORY).append(globalSPARKLOCALPATH, rhs.globalSPARKLOCALPATH).append(globalSPARKMEMORYFRACTION, rhs.globalSPARKMEMORYFRACTION).append(globalSPARKEXECUTOREXTRAJAVAOPTIONS, rhs.globalSPARKEXECUTOREXTRAJAVAOPTIONS).append(environmentJDBCDRIVER, rhs.environmentJDBCDRIVER).append(globalSPARKEXECUTORMEMORY, rhs.globalSPARKEXECUTORMEMORY).isEquals();
    }

}
