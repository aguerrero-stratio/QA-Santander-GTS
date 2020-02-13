
package schemas.MigracionWorkflows;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Settings {

    @SerializedName("global")
    @Expose
    private Global global;
    @SerializedName("streamingSettings")
    @Expose
    private StreamingSettings streamingSettings;
    @SerializedName("sparkSettings")
    @Expose
    private SparkSettings sparkSettings;
    @SerializedName("errorsManagement")
    @Expose
    private ErrorsManagement errorsManagement;

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

    public StreamingSettings getStreamingSettings() {
        return streamingSettings;
    }

    public void setStreamingSettings(StreamingSettings streamingSettings) {
        this.streamingSettings = streamingSettings;
    }

    public SparkSettings getSparkSettings() {
        return sparkSettings;
    }

    public void setSparkSettings(SparkSettings sparkSettings) {
        this.sparkSettings = sparkSettings;
    }

    public ErrorsManagement getErrorsManagement() {
        return errorsManagement;
    }

    public void setErrorsManagement(ErrorsManagement errorsManagement) {
        this.errorsManagement = errorsManagement;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("global", global).append("streamingSettings", streamingSettings).append("sparkSettings", sparkSettings).append("errorsManagement", errorsManagement).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(global).append(streamingSettings).append(errorsManagement).append(sparkSettings).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Settings) == false) {
            return false;
        }
        Settings rhs = ((Settings) other);
        return new EqualsBuilder().append(global, rhs.global).append(streamingSettings, rhs.streamingSettings).append(errorsManagement, rhs.errorsManagement).append(sparkSettings, rhs.sparkSettings).isEquals();
    }

}
