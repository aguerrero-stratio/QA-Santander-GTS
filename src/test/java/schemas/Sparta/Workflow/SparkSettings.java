
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SparkSettings implements Serializable
{

    @SerializedName("master")
    @Expose
    private String master;
    @SerializedName("sparkKerberos")
    @Expose
    private Boolean sparkKerberos;
    @SerializedName("sparkDataStoreTls")
    @Expose
    private Boolean sparkDataStoreTls;
    @SerializedName("sparkMesosSecurity")
    @Expose
    private Boolean sparkMesosSecurity;
    @SerializedName("submitArguments")
    @Expose
    private SubmitArguments submitArguments;
    @SerializedName("sparkConf")
    @Expose
    private SparkConf sparkConf;
    private final static long serialVersionUID = 1012657670967569352L;

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public Boolean getSparkKerberos() {
        return sparkKerberos;
    }

    public void setSparkKerberos(Boolean sparkKerberos) {
        this.sparkKerberos = sparkKerberos;
    }

    public Boolean getSparkDataStoreTls() {
        return sparkDataStoreTls;
    }

    public void setSparkDataStoreTls(Boolean sparkDataStoreTls) {
        this.sparkDataStoreTls = sparkDataStoreTls;
    }

    public Boolean getSparkMesosSecurity() {
        return sparkMesosSecurity;
    }

    public void setSparkMesosSecurity(Boolean sparkMesosSecurity) {
        this.sparkMesosSecurity = sparkMesosSecurity;
    }

    public SubmitArguments getSubmitArguments() {
        return submitArguments;
    }

    public void setSubmitArguments(SubmitArguments submitArguments) {
        this.submitArguments = submitArguments;
    }

    public SparkConf getSparkConf() {
        return sparkConf;
    }

    public void setSparkConf(SparkConf sparkConf) {
        this.sparkConf = sparkConf;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("master", master).append("sparkKerberos", sparkKerberos).append("sparkDataStoreTls", sparkDataStoreTls).append("sparkMesosSecurity", sparkMesosSecurity).append("submitArguments", submitArguments).append("sparkConf", sparkConf).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(submitArguments).append(sparkMesosSecurity).append(sparkDataStoreTls).append(sparkConf).append(sparkKerberos).append(master).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SparkSettings) == false) {
            return false;
        }
        SparkSettings rhs = ((SparkSettings) other);
        return new EqualsBuilder().append(submitArguments, rhs.submitArguments).append(sparkMesosSecurity, rhs.sparkMesosSecurity).append(sparkDataStoreTls, rhs.sparkDataStoreTls).append(sparkConf, rhs.sparkConf).append(sparkKerberos, rhs.sparkKerberos).append(master, rhs.master).isEquals();
    }

}
