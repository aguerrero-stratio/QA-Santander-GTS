
package schemas.MigracionWorkflows;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Edge {

    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("dataType")
    @Expose
    private String dataType;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("origin", origin).append("destination", destination).append("dataType", dataType).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(destination).append(origin).append(dataType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Edge) == false) {
            return false;
        }
        Edge rhs = ((Edge) other);
        return new EqualsBuilder().append(destination, rhs.destination).append(origin, rhs.origin).append(dataType, rhs.dataType).isEquals();
    }

}
