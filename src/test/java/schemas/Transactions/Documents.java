
package schemas.Transactions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Documents {

    @SerializedName("retrieved")
    @Expose
    private Integer retrieved;
    @SerializedName("totalRegistersFound")
    @Expose
    private Integer totalRegistersFound;

    public Integer getRetrieved() {
        return retrieved;
    }

    public void setRetrieved(Integer retrieved) {
        this.retrieved = retrieved;
    }

    public Integer getTotalRegistersFound() {
        return totalRegistersFound;
    }

    public void setTotalRegistersFound(Integer totalRegistersFound) {
        this.totalRegistersFound = totalRegistersFound;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("retrieved", retrieved).append("totalRegistersFound", totalRegistersFound).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(totalRegistersFound).append(retrieved).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Documents) == false) {
            return false;
        }
        Documents rhs = ((Documents) other);
        return new EqualsBuilder().append(totalRegistersFound, rhs.totalRegistersFound).append(retrieved, rhs.retrieved).isEquals();
    }

}
