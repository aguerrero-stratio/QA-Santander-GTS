
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ExtraOptions implements Serializable
{

    @SerializedName("partitionBy")
    @Expose
    private String partitionBy;
    @SerializedName("partitionOverwriteEnabled")
    @Expose
    private Boolean partitionOverwriteEnabled;
    @SerializedName("partitionColumns")
    @Expose
    private String partitionColumns;
    @SerializedName("saveMode")
    @Expose
    private String saveMode;
    @SerializedName("partitions")
    @Expose
    private String partitions;
    private final static long serialVersionUID = -8589172183173342304L;

    public String getPartitionBy() {
        return partitionBy;
    }

    public void setPartitionBy(String partitionBy) {
        this.partitionBy = partitionBy;
    }

    public Boolean getPartitionOverwriteEnabled() {
        return partitionOverwriteEnabled;
    }

    public void setPartitionOverwriteEnabled(Boolean partitionOverwriteEnabled) {
        this.partitionOverwriteEnabled = partitionOverwriteEnabled;
    }

    public String getPartitionColumns() {
        return partitionColumns;
    }

    public void setPartitionColumns(String partitionColumns) {
        this.partitionColumns = partitionColumns;
    }

    public String getSaveMode() {
        return saveMode;
    }

    public void setSaveMode(String saveMode) {
        this.saveMode = saveMode;
    }

    public String getPartitions() {
        return partitions;
    }

    public void setPartitions(String partitions) {
        this.partitions = partitions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("partitionBy", partitionBy).append("partitionOverwriteEnabled", partitionOverwriteEnabled).append("partitionColumns", partitionColumns).append("saveMode", saveMode).append("partitions", partitions).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(partitions).append(partitionBy).append(saveMode).append(partitionOverwriteEnabled).append(partitionColumns).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ExtraOptions) == false) {
            return false;
        }
        ExtraOptions rhs = ((ExtraOptions) other);
        return new EqualsBuilder().append(partitions, rhs.partitions).append(partitionBy, rhs.partitionBy).append(saveMode, rhs.saveMode).append(partitionOverwriteEnabled, rhs.partitionOverwriteEnabled).append(partitionColumns, rhs.partitionColumns).isEquals();
    }

}
