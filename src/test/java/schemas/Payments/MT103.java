
package schemas.Payments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class MT103 {

    @SerializedName("contentType")
    @Expose
    private String contentType;
    @SerializedName("mt103CopyFile")
    @Expose
    private String mt103CopyFile;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getMt103CopyFile() {
        return mt103CopyFile;
    }

    public void setMt103CopyFile(String mt103CopyFile) {
        this.mt103CopyFile = mt103CopyFile;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("contentType", contentType).append("mt103CopyFile", mt103CopyFile).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(contentType).append(mt103CopyFile).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MT103) == false) {
            return false;
        }
        MT103 rhs = ((MT103) other);
        return new EqualsBuilder().append(contentType, rhs.contentType).append(mt103CopyFile, rhs.mt103CopyFile).isEquals();
    }

}
