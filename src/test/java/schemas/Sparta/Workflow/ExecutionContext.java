
package schemas.Sparta.Workflow;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ExecutionContext implements Serializable
{

    @SerializedName("extraParams")
    @Expose
    private List<Object> extraParams = null;
    @SerializedName("paramsLists")
    @Expose
    private List<String> paramsLists = null;
    private final static long serialVersionUID = 3018410178410654499L;

    public List<Object> getExtraParams() {
        return extraParams;
    }

    public void setExtraParams(List<Object> extraParams) {
        this.extraParams = extraParams;
    }

    public List<String> getParamsLists() {
        return paramsLists;
    }

    public void setParamsLists(List<String> paramsLists) {
        this.paramsLists = paramsLists;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("extraParams", extraParams).append("paramsLists", paramsLists).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(paramsLists).append(extraParams).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ExecutionContext) == false) {
            return false;
        }
        ExecutionContext rhs = ((ExecutionContext) other);
        return new EqualsBuilder().append(paramsLists, rhs.paramsLists).append(extraParams, rhs.extraParams).isEquals();
    }

}
