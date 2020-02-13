
package schemas.MigracionWorkflows;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CheckpointSettings {

    @SerializedName("checkpointPath")
    @Expose
    private String checkpointPath;
    @SerializedName("enableCheckpointing")
    @Expose
    private Boolean enableCheckpointing;
    @SerializedName("autoDeleteCheckpoint")
    @Expose
    private Boolean autoDeleteCheckpoint;
    @SerializedName("addTimeToCheckpointPath")
    @Expose
    private Boolean addTimeToCheckpointPath;

    public String getCheckpointPath() {
        return checkpointPath;
    }

    public void setCheckpointPath(String checkpointPath) {
        this.checkpointPath = checkpointPath;
    }

    public Boolean getEnableCheckpointing() {
        return enableCheckpointing;
    }

    public void setEnableCheckpointing(Boolean enableCheckpointing) {
        this.enableCheckpointing = enableCheckpointing;
    }

    public Boolean getAutoDeleteCheckpoint() {
        return autoDeleteCheckpoint;
    }

    public void setAutoDeleteCheckpoint(Boolean autoDeleteCheckpoint) {
        this.autoDeleteCheckpoint = autoDeleteCheckpoint;
    }

    public Boolean getAddTimeToCheckpointPath() {
        return addTimeToCheckpointPath;
    }

    public void setAddTimeToCheckpointPath(Boolean addTimeToCheckpointPath) {
        this.addTimeToCheckpointPath = addTimeToCheckpointPath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("checkpointPath", checkpointPath).append("enableCheckpointing", enableCheckpointing).append("autoDeleteCheckpoint", autoDeleteCheckpoint).append("addTimeToCheckpointPath", addTimeToCheckpointPath).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(enableCheckpointing).append(autoDeleteCheckpoint).append(addTimeToCheckpointPath).append(checkpointPath).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CheckpointSettings) == false) {
            return false;
        }
        CheckpointSettings rhs = ((CheckpointSettings) other);
        return new EqualsBuilder().append(enableCheckpointing, rhs.enableCheckpointing).append(autoDeleteCheckpoint, rhs.autoDeleteCheckpoint).append(addTimeToCheckpointPath, rhs.addTimeToCheckpointPath).append(checkpointPath, rhs.checkpointPath).isEquals();
    }

}
