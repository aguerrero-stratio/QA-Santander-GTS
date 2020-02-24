
package schemas.Sparta.Workflow;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class MarathonDeploymentSettings implements Serializable
{

    @SerializedName("gracePeriodSeconds")
    @Expose
    private String gracePeriodSeconds;
    @SerializedName("intervalSeconds")
    @Expose
    private String intervalSeconds;
    @SerializedName("timeoutSeconds")
    @Expose
    private String timeoutSeconds;
    @SerializedName("maxConsecutiveFailures")
    @Expose
    private String maxConsecutiveFailures;
    @SerializedName("forcePullImage")
    @Expose
    private Boolean forcePullImage;
    @SerializedName("privileged")
    @Expose
    private Boolean privileged;
    @SerializedName("userEnvVariables")
    @Expose
    private List<Object> userEnvVariables = null;
    @SerializedName("userLabels")
    @Expose
    private List<Object> userLabels = null;
    @SerializedName("logLevel")
    @Expose
    private String logLevel;
    private final static long serialVersionUID = -1148420052458419314L;

    public String getGracePeriodSeconds() {
        return gracePeriodSeconds;
    }

    public void setGracePeriodSeconds(String gracePeriodSeconds) {
        this.gracePeriodSeconds = gracePeriodSeconds;
    }

    public String getIntervalSeconds() {
        return intervalSeconds;
    }

    public void setIntervalSeconds(String intervalSeconds) {
        this.intervalSeconds = intervalSeconds;
    }

    public String getTimeoutSeconds() {
        return timeoutSeconds;
    }

    public void setTimeoutSeconds(String timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    public String getMaxConsecutiveFailures() {
        return maxConsecutiveFailures;
    }

    public void setMaxConsecutiveFailures(String maxConsecutiveFailures) {
        this.maxConsecutiveFailures = maxConsecutiveFailures;
    }

    public Boolean getForcePullImage() {
        return forcePullImage;
    }

    public void setForcePullImage(Boolean forcePullImage) {
        this.forcePullImage = forcePullImage;
    }

    public Boolean getPrivileged() {
        return privileged;
    }

    public void setPrivileged(Boolean privileged) {
        this.privileged = privileged;
    }

    public List<Object> getUserEnvVariables() {
        return userEnvVariables;
    }

    public void setUserEnvVariables(List<Object> userEnvVariables) {
        this.userEnvVariables = userEnvVariables;
    }

    public List<Object> getUserLabels() {
        return userLabels;
    }

    public void setUserLabels(List<Object> userLabels) {
        this.userLabels = userLabels;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("gracePeriodSeconds", gracePeriodSeconds).append("intervalSeconds", intervalSeconds).append("timeoutSeconds", timeoutSeconds).append("maxConsecutiveFailures", maxConsecutiveFailures).append("forcePullImage", forcePullImage).append("privileged", privileged).append("userEnvVariables", userEnvVariables).append("userLabels", userLabels).append("logLevel", logLevel).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(privileged).append(logLevel).append(timeoutSeconds).append(userEnvVariables).append(userLabels).append(gracePeriodSeconds).append(maxConsecutiveFailures).append(intervalSeconds).append(forcePullImage).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MarathonDeploymentSettings) == false) {
            return false;
        }
        MarathonDeploymentSettings rhs = ((MarathonDeploymentSettings) other);
        return new EqualsBuilder().append(privileged, rhs.privileged).append(logLevel, rhs.logLevel).append(timeoutSeconds, rhs.timeoutSeconds).append(userEnvVariables, rhs.userEnvVariables).append(userLabels, rhs.userLabels).append(gracePeriodSeconds, rhs.gracePeriodSeconds).append(maxConsecutiveFailures, rhs.maxConsecutiveFailures).append(intervalSeconds, rhs.intervalSeconds).append(forcePullImage, rhs.forcePullImage).isEquals();
    }

}
