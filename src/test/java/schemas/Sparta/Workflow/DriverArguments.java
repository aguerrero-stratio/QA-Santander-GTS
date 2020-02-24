
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class DriverArguments implements Serializable
{

    @SerializedName("plugins")
    @Expose
    private String plugins;
    @SerializedName("executionId")
    @Expose
    private String executionId;
    private final static long serialVersionUID = 7393165607373705003L;

    public String getPlugins() {
        return plugins;
    }

    public void setPlugins(String plugins) {
        this.plugins = plugins;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("plugins", plugins).append("executionId", executionId).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(executionId).append(plugins).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DriverArguments) == false) {
            return false;
        }
        DriverArguments rhs = ((DriverArguments) other);
        return new EqualsBuilder().append(executionId, rhs.executionId).append(plugins, rhs.plugins).isEquals();
    }

}
