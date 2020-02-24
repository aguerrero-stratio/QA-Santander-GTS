
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ActionType implements Serializable
{

    @SerializedName("type")
    @Expose
    private String type;
    private final static long serialVersionUID = 724790466340524676L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("type", type).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ActionType) == false) {
            return false;
        }
        ActionType rhs = ((ActionType) other);
        return new EqualsBuilder().append(type, rhs.type).isEquals();
    }

}
