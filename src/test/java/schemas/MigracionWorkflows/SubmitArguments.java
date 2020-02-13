
package schemas.MigracionWorkflows;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SubmitArguments {

    @SerializedName("userArguments")
    @Expose
    private List<Object> userArguments = null;
    @SerializedName("deployMode")
    @Expose
    private String deployMode;
    @SerializedName("driverJavaOptions")
    @Expose
    private String driverJavaOptions;

    public List<Object> getUserArguments() {
        return userArguments;
    }

    public void setUserArguments(List<Object> userArguments) {
        this.userArguments = userArguments;
    }

    public String getDeployMode() {
        return deployMode;
    }

    public void setDeployMode(String deployMode) {
        this.deployMode = deployMode;
    }

    public String getDriverJavaOptions() {
        return driverJavaOptions;
    }

    public void setDriverJavaOptions(String driverJavaOptions) {
        this.driverJavaOptions = driverJavaOptions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("userArguments", userArguments).append("deployMode", deployMode).append("driverJavaOptions", driverJavaOptions).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(deployMode).append(driverJavaOptions).append(userArguments).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SubmitArguments) == false) {
            return false;
        }
        SubmitArguments rhs = ((SubmitArguments) other);
        return new EqualsBuilder().append(deployMode, rhs.deployMode).append(driverJavaOptions, rhs.driverJavaOptions).append(userArguments, rhs.userArguments).isEquals();
    }

}
