
package schemas.Payments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class Documents {

    @SerializedName("totalRegistersFound")
    @Expose
    private String totalRegistersFound;
    @SerializedName("retrieved")
    @Expose
    private String retrieved;

    public String getTotalRegistersFound() {
        return totalRegistersFound;
    }

    public void setTotalRegistersFound(String totalRegistersFound) {
        this.totalRegistersFound = totalRegistersFound;
    }

    public String getRetrieved() {
        return retrieved;
    }

    public void setRetrieved(String retrieved) {
        this.retrieved = retrieved;
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
