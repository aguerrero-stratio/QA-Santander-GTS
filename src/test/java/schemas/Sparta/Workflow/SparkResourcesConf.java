
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SparkResourcesConf implements Serializable
{

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
    @SerializedName("mesosExtraCores")
    @Expose
    private String mesosExtraCores;
    @SerializedName("localityWait")
    @Expose
    private String localityWait;
    @SerializedName("taskMaxFailures")
    @Expose
    private String taskMaxFailures;
    @SerializedName("sparkMemoryFraction")
    @Expose
    private String sparkMemoryFraction;
    @SerializedName("sparkParallelism")
    @Expose
    private String sparkParallelism;
    private final static long serialVersionUID = -2495305910762959637L;

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

    public String getMesosExtraCores() {
        return mesosExtraCores;
    }

    public void setMesosExtraCores(String mesosExtraCores) {
        this.mesosExtraCores = mesosExtraCores;
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

    public String getSparkParallelism() {
        return sparkParallelism;
    }

    public void setSparkParallelism(String sparkParallelism) {
        this.sparkParallelism = sparkParallelism;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("coresMax", coresMax).append("executorMemory", executorMemory).append("executorCores", executorCores).append("driverCores", driverCores).append("driverMemory", driverMemory).append("mesosExtraCores", mesosExtraCores).append("localityWait", localityWait).append("taskMaxFailures", taskMaxFailures).append("sparkMemoryFraction", sparkMemoryFraction).append("sparkParallelism", sparkParallelism).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(executorMemory).append(driverMemory).append(sparkParallelism).append(driverCores).append(coresMax).append(executorCores).append(mesosExtraCores).append(localityWait).append(sparkMemoryFraction).append(taskMaxFailures).toHashCode();
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
        return new EqualsBuilder().append(executorMemory, rhs.executorMemory).append(driverMemory, rhs.driverMemory).append(sparkParallelism, rhs.sparkParallelism).append(driverCores, rhs.driverCores).append(coresMax, rhs.coresMax).append(executorCores, rhs.executorCores).append(mesosExtraCores, rhs.mesosExtraCores).append(localityWait, rhs.localityWait).append(sparkMemoryFraction, rhs.sparkMemoryFraction).append(taskMaxFailures, rhs.taskMaxFailures).isEquals();
    }

}
