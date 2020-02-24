
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class MarathonExecution implements Serializable
{

    @SerializedName("marathonId")
    @Expose
    private String marathonId;
    @SerializedName("sparkURI")
    @Expose
    private String sparkURI;
    private final static long serialVersionUID = 6540779591229975892L;

    public String getMarathonId() {
        return marathonId;
    }

    public void setMarathonId(String marathonId) {
        this.marathonId = marathonId;
    }

    public String getSparkURI() {
        return sparkURI;
    }

    public void setSparkURI(String sparkURI) {
        this.sparkURI = sparkURI;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("marathonId", marathonId).append("sparkURI", sparkURI).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(marathonId).append(sparkURI).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MarathonExecution) == false) {
            return false;
        }
        MarathonExecution rhs = ((MarathonExecution) other);
        return new EqualsBuilder().append(marathonId, rhs.marathonId).append(sparkURI, rhs.sparkURI).isEquals();
    }

}
