
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SubmitArguments_ implements Serializable
{

    @SerializedName("--deploy-mode")
    @Expose
    private String deployMode;
    @SerializedName("--driver-java-options")
    @Expose
    private String driverJavaOptions;
    @SerializedName("--principal")
    @Expose
    private String principal;
    @SerializedName("--keytab")
    @Expose
    private String keytab;
    private final static long serialVersionUID = 1944134446332796070L;

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

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getKeytab() {
        return keytab;
    }

    public void setKeytab(String keytab) {
        this.keytab = keytab;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("deployMode", deployMode).append("driverJavaOptions", driverJavaOptions).append("principal", principal).append("keytab", keytab).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(principal).append(keytab).append(deployMode).append(driverJavaOptions).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SubmitArguments_) == false) {
            return false;
        }
        SubmitArguments_ rhs = ((SubmitArguments_) other);
        return new EqualsBuilder().append(principal, rhs.principal).append(keytab, rhs.keytab).append(deployMode, rhs.deployMode).append(driverJavaOptions, rhs.driverJavaOptions).isEquals();
    }

}
