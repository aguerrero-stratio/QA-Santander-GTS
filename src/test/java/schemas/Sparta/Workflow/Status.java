
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Status implements Serializable
{

    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("statusInfo")
    @Expose
    private String statusInfo;
    @SerializedName("lastUpdateDate")
    @Expose
    private String lastUpdateDate;
    private final static long serialVersionUID = -2800824143148752342L;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("state", state).append("statusInfo", statusInfo).append("lastUpdateDate", lastUpdateDate).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(state).append(statusInfo).append(lastUpdateDate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Status) == false) {
            return false;
        }
        Status rhs = ((Status) other);
        return new EqualsBuilder().append(state, rhs.state).append(statusInfo, rhs.statusInfo).append(lastUpdateDate, rhs.lastUpdateDate).isEquals();
    }

}
