
package schemas.MigracionWorkflows;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class MigracionWorkflow {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("settings")
    @Expose
    private Settings settings;
    @SerializedName("pipelineGraph")
    @Expose
    private PipelineGraph pipelineGraph;
    @SerializedName("executionEngine")
    @Expose
    private String executionEngine;
    @SerializedName("uiSettings")
    @Expose
    private UiSettings uiSettings;
    @SerializedName("creationDate")
    @Expose
    private String creationDate;
    @SerializedName("version")
    @Expose
    private Integer version;
    @SerializedName("group")
    @Expose
    private Group group;
    @SerializedName("debugMode")
    @Expose
    private Boolean debugMode;
    @SerializedName("versionSparta")
    @Expose
    private String versionSparta;
    @SerializedName("groupId")
    @Expose
    private String groupId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public PipelineGraph getPipelineGraph() {
        return pipelineGraph;
    }

    public void setPipelineGraph(PipelineGraph pipelineGraph) {
        this.pipelineGraph = pipelineGraph;
    }

    public String getExecutionEngine() {
        return executionEngine;
    }

    public void setExecutionEngine(String executionEngine) {
        this.executionEngine = executionEngine;
    }

    public UiSettings getUiSettings() {
        return uiSettings;
    }

    public void setUiSettings(UiSettings uiSettings) {
        this.uiSettings = uiSettings;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Boolean getDebugMode() {
        return debugMode;
    }

    public void setDebugMode(Boolean debugMode) {
        this.debugMode = debugMode;
    }

    public String getVersionSparta() {
        return versionSparta;
    }

    public void setVersionSparta(String versionSparta) {
        this.versionSparta = versionSparta;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("description", description).append("settings", settings).append("pipelineGraph", pipelineGraph).append("executionEngine", executionEngine).append("uiSettings", uiSettings).append("creationDate", creationDate).append("version", version).append("group", group).append("debugMode", debugMode).append("versionSparta", versionSparta).append("groupId", groupId).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(settings).append(groupId).append(uiSettings).append(description).append(creationDate).append(executionEngine).append(version).append(name).append(pipelineGraph).append(id).append(debugMode).append(group).append(versionSparta).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MigracionWorkflow) == false) {
            return false;
        }
        MigracionWorkflow rhs = ((MigracionWorkflow) other);
        return new EqualsBuilder().append(settings, rhs.settings).append(groupId, rhs.groupId).append(uiSettings, rhs.uiSettings).append(description, rhs.description).append(creationDate, rhs.creationDate).append(executionEngine, rhs.executionEngine).append(version, rhs.version).append(name, rhs.name).append(pipelineGraph, rhs.pipelineGraph).append(id, rhs.id).append(debugMode, rhs.debugMode).append(group, rhs.group).append(versionSparta, rhs.versionSparta).isEquals();
    }

}
