
package schemas.Sparta.Workflow;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SparkSubmitExecution implements Serializable
{

    @SerializedName("driverClass")
    @Expose
    private String driverClass;
    @SerializedName("driverFile")
    @Expose
    private String driverFile;
    @SerializedName("pluginFiles")
    @Expose
    private List<String> pluginFiles = null;
    @SerializedName("master")
    @Expose
    private String master;
    @SerializedName("submitArguments")
    @Expose
    private SubmitArguments_ submitArguments;
    @SerializedName("sparkConfigurations")
    @Expose
    private SparkConfigurations sparkConfigurations;
    @SerializedName("driverArguments")
    @Expose
    private DriverArguments driverArguments;
    @SerializedName("sparkHome")
    @Expose
    private String sparkHome;
    private final static long serialVersionUID = 4864814294499875862L;

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getDriverFile() {
        return driverFile;
    }

    public void setDriverFile(String driverFile) {
        this.driverFile = driverFile;
    }

    public List<String> getPluginFiles() {
        return pluginFiles;
    }

    public void setPluginFiles(List<String> pluginFiles) {
        this.pluginFiles = pluginFiles;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public SubmitArguments_ getSubmitArguments() {
        return submitArguments;
    }

    public void setSubmitArguments(SubmitArguments_ submitArguments) {
        this.submitArguments = submitArguments;
    }

    public SparkConfigurations getSparkConfigurations() {
        return sparkConfigurations;
    }

    public void setSparkConfigurations(SparkConfigurations sparkConfigurations) {
        this.sparkConfigurations = sparkConfigurations;
    }

    public DriverArguments getDriverArguments() {
        return driverArguments;
    }

    public void setDriverArguments(DriverArguments driverArguments) {
        this.driverArguments = driverArguments;
    }

    public String getSparkHome() {
        return sparkHome;
    }

    public void setSparkHome(String sparkHome) {
        this.sparkHome = sparkHome;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("driverClass", driverClass).append("driverFile", driverFile).append("pluginFiles", pluginFiles).append("master", master).append("submitArguments", submitArguments).append("sparkConfigurations", sparkConfigurations).append("driverArguments", driverArguments).append("sparkHome", sparkHome).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sparkHome).append(driverFile).append(submitArguments).append(driverClass).append(driverArguments).append(pluginFiles).append(sparkConfigurations).append(master).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SparkSubmitExecution) == false) {
            return false;
        }
        SparkSubmitExecution rhs = ((SparkSubmitExecution) other);
        return new EqualsBuilder().append(sparkHome, rhs.sparkHome).append(driverFile, rhs.driverFile).append(submitArguments, rhs.submitArguments).append(driverClass, rhs.driverClass).append(driverArguments, rhs.driverArguments).append(pluginFiles, rhs.pluginFiles).append(sparkConfigurations, rhs.sparkConfigurations).append(master, rhs.master).isEquals();
    }

}
