
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Position_ implements Serializable
{

    @SerializedName("x")
    @Expose
    private Double x;
    @SerializedName("y")
    @Expose
    private Double y;
    @SerializedName("k")
    @Expose
    private Double k;
    private final static long serialVersionUID = -8207626373347434653L;

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getK() {
        return k;
    }

    public void setK(Double k) {
        this.k = k;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("x", x).append("y", y).append("k", k).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(x).append(y).append(k).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Position_) == false) {
            return false;
        }
        Position_ rhs = ((Position_) other);
        return new EqualsBuilder().append(x, rhs.x).append(y, rhs.y).append(k, rhs.k).isEquals();
    }

}
