
package schemas.MigracionWorkflows;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SparkResourcesConf {

    @SerializedName("coresMax")
    @Expose
    private String coresMax;
    @SerializedName("executorMemory")
    @Expose
    private String executorMemory;
    @SerializedName("executorCores")
    @Expose
    private String executorCores;
    @SerializedName("driverCores")
    @Expose
    private String driverCores;
    @SerializedName("driverMemory")
    @Expose
    private String driverMemory;
    @SerializedName("localityWait")
    @Expose
    private String localityWait;
    @SerializedName("taskMaxFailures")
    @Expose
    private String taskMaxFailures;
    @SerializedName("sparkMemoryFraction")
    @Expose
    private String sparkMemoryFraction;

    public String getCoresMax() {
        return coresMax;
    }

    public void setCoresMax(String coresMax) {
        this.coresMax = coresMax;
    }

    public String getExecutorMemory() {
        return executorMemory;
    }

    public void setExecutorMemory(String executorMemory) {
        this.executorMemory = executorMemory;
    }

    public String getExecutorCores() {
        return executorCores;
    }

    public void setExecutorCores(String executorCores) {
        this.executorCores = executorCores;
    }

    public String getDriverCores() {
        return driverCores;
    }

    public void setDriverCores(String driverCores) {
        this.driverCores = driverCores;
    }

    public String getDriverMemory() {
        return driverMemory;
    }

    public void setDriverMemory(String driverMemory) {
        this.driverMemory = driverMemory;
    }

    public String getLocalityWait() {
        return localityWait;
    }

    public void setLocalityWait(String localityWait) {
        this.localityWait = localityWait;
    }

    public String getTaskMaxFailures() {
        return taskMaxFailures;
    }

    public void setTaskMaxFailures(String taskMaxFailures) {
        this.taskMaxFailures = taskMaxFailures;
    }

    public String getSparkMemoryFraction() {
        return sparkMemoryFraction;
    }

    public void setSparkMemoryFraction(String sparkMemoryFraction) {
        this.sparkMemoryFraction = sparkMemoryFraction;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("coresMax", coresMax).append("executorMemory", executorMemory).append("executorCores", executorCores).append("driverCores", driverCores).append("driverMemory", driverMemory).append("localityWait", localityWait).append("taskMaxFailures", taskMaxFailures).append("sparkMemoryFraction", sparkMemoryFraction).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(executorMemory).append(driverMemory).append(driverCores).append(coresMax).append(executorCores).append(localityWait).append(sparkMemoryFraction).append(taskMaxFailures).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SparkResourcesConf) == false) {
            return false;
        }
        SparkResourcesConf rhs = ((SparkResourcesConf) other);
        return new EqualsBuilder().append(executorMemory, rhs.executorMemory).append(driverMemory, rhs.driverMemory).append(driverCores, rhs.driverCores).append(coresMax, rhs.coresMax).append(executorCores, rhs.executorCores).append(localityWait, rhs.localityWait).append(sparkMemoryFraction, rhs.sparkMemoryFraction).append(taskMaxFailures, rhs.taskMaxFailures).isEquals();
    }

}
