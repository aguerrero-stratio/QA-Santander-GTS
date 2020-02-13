
package schemas.MigracionWorkflows;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Configuration {

    @SerializedName("eventType")
    @Expose
    private String eventType;
    @SerializedName("outputField")
    @Expose
    private String outputField;
    @SerializedName("event")
    @Expose
    private String event;
    @SerializedName("errorTableName")
    @Expose
    private String errorTableName;
    @SerializedName("numEvents")
    @Expose
    private String numEvents;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("errorSink")
    @Expose
    private Boolean errorSink;
    @SerializedName("saveOptions")
    @Expose
    private String saveOptions;
    @SerializedName("delimiter")
    @Expose
    private String delimiter;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getOutputField() {
        return outputField;
    }

    public void setOutputField(String outputField) {
        this.outputField = outputField;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getErrorTableName() {
        return errorTableName;
    }

    public void setErrorTableName(String errorTableName) {
        this.errorTableName = errorTableName;
    }

    public String getNumEvents() {
        return numEvents;
    }

    public void setNumEvents(String numEvents) {
        this.numEvents = numEvents;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getErrorSink() {
        return errorSink;
    }

    public void setErrorSink(Boolean errorSink) {
        this.errorSink = errorSink;
    }

    public String getSaveOptions() {
        return saveOptions;
    }

    public void setSaveOptions(String saveOptions) {
        this.saveOptions = saveOptions;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("eventType", eventType).append("outputField", outputField).append("event", event).append("errorTableName", errorTableName).append("numEvents", numEvents).append("path", path).append("errorSink", errorSink).append("saveOptions", saveOptions).append("delimiter", delimiter).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(saveOptions).append(path).append(delimiter).append(errorSink).append(errorTableName).append(numEvents).append(eventType).append(event).append(outputField).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Configuration) == false) {
            return false;
        }
        Configuration rhs = ((Configuration) other);
        return new EqualsBuilder().append(saveOptions, rhs.saveOptions).append(path, rhs.path).append(delimiter, rhs.delimiter).append(errorSink, rhs.errorSink).append(errorTableName, rhs.errorTableName).append(numEvents, rhs.numEvents).append(eventType, rhs.eventType).append(event, rhs.event).append(outputField, rhs.outputField).isEquals();
    }

}
