
package schemas.MigracionWorkflows;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Node {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("stepType")
    @Expose
    private String stepType;
    @SerializedName("className")
    @Expose
    private String className;
    @SerializedName("classPrettyName")
    @Expose
    private String classPrettyName;
    @SerializedName("arity")
    @Expose
    private List<String> arity = null;
    @SerializedName("uiConfiguration")
    @Expose
    private UiConfiguration uiConfiguration;
    @SerializedName("configuration")
    @Expose
    private Configuration configuration;
    @SerializedName("supportedEngines")
    @Expose
    private List<String> supportedEngines = null;
    @SerializedName("executionEngine")
    @Expose
    private String executionEngine;
    @SerializedName("supportedDataRelations")
    @Expose
    private List<String> supportedDataRelations = null;
    @SerializedName("lineageProperties")
    @Expose
    private List<Object> lineageProperties = null;
    @SerializedName("outputsWriter")
    @Expose
    private List<OutputsWriter> outputsWriter = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStepType() {
        return stepType;
    }

    public void setStepType(String stepType) {
        this.stepType = stepType;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassPrettyName() {
        return classPrettyName;
    }

    public void setClassPrettyName(String classPrettyName) {
        this.classPrettyName = classPrettyName;
    }

    public List<String> getArity() {
        return arity;
    }

    public void setArity(List<String> arity) {
        this.arity = arity;
    }

    public UiConfiguration getUiConfiguration() {
        return uiConfiguration;
    }

    public void setUiConfiguration(UiConfiguration uiConfiguration) {
        this.uiConfiguration = uiConfiguration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public List<String> getSupportedEngines() {
        return supportedEngines;
    }

    public void setSupportedEngines(List<String> supportedEngines) {
        this.supportedEngines = supportedEngines;
    }

    public String getExecutionEngine() {
        return executionEngine;
    }

    public void setExecutionEngine(String executionEngine) {
        this.executionEngine = executionEngine;
    }

    public List<String> getSupportedDataRelations() {
        return supportedDataRelations;
    }

    public void setSupportedDataRelations(List<String> supportedDataRelations) {
        this.supportedDataRelations = supportedDataRelations;
    }

    public List<Object> getLineageProperties() {
        return lineageProperties;
    }

    public void setLineageProperties(List<Object> lineageProperties) {
        this.lineageProperties = lineageProperties;
    }

    public List<OutputsWriter> getOutputsWriter() {
        return outputsWriter;
    }

    public void setOutputsWriter(List<OutputsWriter> outputsWriter) {
        this.outputsWriter = outputsWriter;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("stepType", stepType).append("className", className).append("classPrettyName", classPrettyName).append("arity", arity).append("uiConfiguration", uiConfiguration).append("configuration", configuration).append("supportedEngines", supportedEngines).append("executionEngine", executionEngine).append("supportedDataRelations", supportedDataRelations).append("lineageProperties", lineageProperties).append("outputsWriter", outputsWriter).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lineageProperties).append(stepType).append(configuration).append(supportedEngines).append(classPrettyName).append(outputsWriter).append(className).append(supportedDataRelations).append(executionEngine).append(arity).append(uiConfiguration).append(name).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Node) == false) {
            return false;
        }
        Node rhs = ((Node) other);
        return new EqualsBuilder().append(lineageProperties, rhs.lineageProperties).append(stepType, rhs.stepType).append(configuration, rhs.configuration).append(supportedEngines, rhs.supportedEngines).append(classPrettyName, rhs.classPrettyName).append(outputsWriter, rhs.outputsWriter).append(className, rhs.className).append(supportedDataRelations, rhs.supportedDataRelations).append(executionEngine, rhs.executionEngine).append(arity, rhs.arity).append(uiConfiguration, rhs.uiConfiguration).append(name, rhs.name).isEquals();
    }

}
