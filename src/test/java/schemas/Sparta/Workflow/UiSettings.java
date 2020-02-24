
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UiSettings implements Serializable
{

    @SerializedName("position")
    @Expose
    private Position_ position;
    private final static long serialVersionUID = -1239136048195449440L;

    public Position_ getPosition() {
        return position;
    }

    public void setPosition(Position_ position) {
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
        if ((other instanceof UiSettings) == false) {
            return false;
        }
        UiSettings rhs = ((UiSettings) other);
        return new EqualsBuilder().append(position, rhs.position).isEquals();
    }

}
