
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SparkHistoryServerConf implements Serializable
{

    @SerializedName("enableHistoryServerMonitoring")
    @Expose
    private Boolean enableHistoryServerMonitoring;
    @SerializedName("sparkHistoryServerEventLogRotateEnable")
    @Expose
    private Boolean sparkHistoryServerEventLogRotateEnable;
    @SerializedName("sparkHistoryServerEventLogRotateNum")
    @Expose
    private String sparkHistoryServerEventLogRotateNum;
    @SerializedName("sparkHistoryServerEventLogRotateSize")
    @Expose
    private String sparkHistoryServerEventLogRotateSize;
    private final static long serialVersionUID = -3998367316762509655L;

    public Boolean getEnableHistoryServerMonitoring() {
        return enableHistoryServerMonitoring;
    }

    public void setEnableHistoryServerMonitoring(Boolean enableHistoryServerMonitoring) {
        this.enableHistoryServerMonitoring = enableHistoryServerMonitoring;
    }

    public Boolean getSparkHistoryServerEventLogRotateEnable() {
        return sparkHistoryServerEventLogRotateEnable;
    }

    public void setSparkHistoryServerEventLogRotateEnable(Boolean sparkHistoryServerEventLogRotateEnable) {
        this.sparkHistoryServerEventLogRotateEnable = sparkHistoryServerEventLogRotateEnable;
    }

    public String getSparkHistoryServerEventLogRotateNum() {
        return sparkHistoryServerEventLogRotateNum;
    }

    public void setSparkHistoryServerEventLogRotateNum(String sparkHistoryServerEventLogRotateNum) {
        this.sparkHistoryServerEventLogRotateNum = sparkHistoryServerEventLogRotateNum;
    }

    public String getSparkHistoryServerEventLogRotateSize() {
        return sparkHistoryServerEventLogRotateSize;
    }

    public void setSparkHistoryServerEventLogRotateSize(String sparkHistoryServerEventLogRotateSize) {
        this.sparkHistoryServerEventLogRotateSize = sparkHistoryServerEventLogRotateSize;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("enableHistoryServerMonitoring", enableHistoryServerMonitoring).append("sparkHistoryServerEventLogRotateEnable", sparkHistoryServerEventLogRotateEnable).append("sparkHistoryServerEventLogRotateNum", sparkHistoryServerEventLogRotateNum).append("sparkHistoryServerEventLogRotateSize", sparkHistoryServerEventLogRotateSize).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sparkHistoryServerEventLogRotateNum).append(enableHistoryServerMonitoring).append(sparkHistoryServerEventLogRotateSize).append(sparkHistoryServerEventLogRotateEnable).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SparkHistoryServerConf) == false) {
            return false;
        }
        SparkHistoryServerConf rhs = ((SparkHistoryServerConf) other);
        return new EqualsBuilder().append(sparkHistoryServerEventLogRotateNum, rhs.sparkHistoryServerEventLogRotateNum).append(enableHistoryServerMonitoring, rhs.enableHistoryServerMonitoring).append(sparkHistoryServerEventLogRotateSize, rhs.sparkHistoryServerEventLogRotateSize).append(sparkHistoryServerEventLogRotateEnable, rhs.sparkHistoryServerEventLogRotateEnable).isEquals();
    }

}
