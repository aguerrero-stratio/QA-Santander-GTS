
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class GenericDataExecution implements Serializable
{

    @SerializedName("workflow")
    @Expose
    private Workflow workflow;
    @SerializedName("executionMode")
    @Expose
    private String executionMode;
    @SerializedName("executionContext")
    @Expose
    private ExecutionContext executionContext;
    @SerializedName("launchDate")
    @Expose
    private String launchDate;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("lastError")
    @Expose
    private LastError lastError;
    private final static long serialVersionUID = 8454447538878089451L;

    public Workflow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(Workflow workflow) {
        this.workflow = workflow;
    }

    public String getExecutionMode() {
        return executionMode;
    }

    public void setExecutionMode(String executionMode) {
        this.executionMode = executionMode;
    }

    public ExecutionContext getExecutionContext() {
        return executionContext;
    }

    public void setExecutionContext(ExecutionContext executionContext) {
        this.executionContext = executionContext;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LastError getLastError() {
        return lastError;
    }

    public void setLastError(LastError lastError) {
        this.lastError = lastError;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("workflow", workflow).append("executionMode", executionMode).append("executionContext", executionContext).append("launchDate", launchDate).append("startDate", startDate).append("endDate", endDate).append("userId", userId).append("lastError", lastError).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lastError).append(workflow).append(endDate).append(executionContext).append(executionMode).append(launchDate).append(userId).append(startDate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GenericDataExecution) == false) {
            return false;
        }
        GenericDataExecution rhs = ((GenericDataExecution) other);
        return new EqualsBuilder().append(lastError, rhs.lastError).append(workflow, rhs.workflow).append(endDate, rhs.endDate).append(executionContext, rhs.executionContext).append(executionMode, rhs.executionMode).append(launchDate, rhs.launchDate).append(userId, rhs.userId).append(startDate, rhs.startDate).isEquals();
    }

}
