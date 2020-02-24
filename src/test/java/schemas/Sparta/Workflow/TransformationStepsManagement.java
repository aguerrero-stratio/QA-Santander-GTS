
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TransformationStepsManagement implements Serializable
{

    @SerializedName("whenError")
    @Expose
    private String whenError;
    @SerializedName("whenRowError")
    @Expose
    private String whenRowError;
    @SerializedName("whenFieldError")
    @Expose
    private String whenFieldError;
    private final static long serialVersionUID = 6828833557009339441L;

    public String getWhenError() {
        return whenError;
    }

    public void setWhenError(String whenError) {
        this.whenError = whenError;
    }

    public String getWhenRowError() {
        return whenRowError;
    }

    public void setWhenRowError(String whenRowError) {
        this.whenRowError = whenRowError;
    }

    public String getWhenFieldError() {
        return whenFieldError;
    }

    public void setWhenFieldError(String whenFieldError) {
        this.whenFieldError = whenFieldError;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("whenError", whenError).append("whenRowError", whenRowError).append("whenFieldError", whenFieldError).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(whenError).append(whenFieldError).append(whenRowError).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TransformationStepsManagement) == false) {
            return false;
        }
        TransformationStepsManagement rhs = ((TransformationStepsManagement) other);
        return new EqualsBuilder().append(whenError, rhs.whenError).append(whenFieldError, rhs.whenFieldError).append(whenRowError, rhs.whenRowError).isEquals();
    }

}
