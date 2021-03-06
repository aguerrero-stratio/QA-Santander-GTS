
package schemas.MigracionWorkflows;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class GenericErrorManagement {

    @SerializedName("whenError")
    @Expose
    private String whenError;

    public String getWhenError() {
        return whenError;
    }

    public void setWhenError(String whenError) {
        this.whenError = whenError;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("whenError", whenError).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(whenError).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GenericErrorManagement) == false) {
            return false;
        }
        GenericErrorManagement rhs = ((GenericErrorManagement) other);
        return new EqualsBuilder().append(whenError, rhs.whenError).isEquals();
    }

}
