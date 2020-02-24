
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UiConfiguration implements Serializable
{

    @SerializedName("position")
    @Expose
    private Position position;
    private final static long serialVersionUID = 2140697907535219283L;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("position", position).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(position).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UiConfiguration) == false) {
            return false;
        }
        UiConfiguration rhs = ((UiConfiguration) other);
        return new EqualsBuilder().append(position, rhs.position).isEquals();
    }

}
