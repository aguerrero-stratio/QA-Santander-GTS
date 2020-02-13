
package schemas.MigracionWorkflows;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ExtraOptions {

    @SerializedName("saveMode")
    @Expose
    private String saveMode;
    @SerializedName("partitions")
    @Expose
    private String partitions;
    @SerializedName("partitionColumns")
    @Expose
    private String partitionColumns;

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

    public String getPartitionColumns() {
        return partitionColumns;
    }

    public void setPartitionColumns(String partitionColumns) {
        this.partitionColumns = partitionColumns;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("saveMode", saveMode).append("partitions", partitions).append("partitionColumns", partitionColumns).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(partitions).append(saveMode).append(partitionColumns).toHashCode();
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
        return new EqualsBuilder().append(partitions, rhs.partitions).append(saveMode, rhs.saveMode).append(partitionColumns, rhs.partitionColumns).isEquals();
    }

}
