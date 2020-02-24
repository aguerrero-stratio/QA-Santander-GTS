
package schemas.Sparta.Workflow;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class QualityRule implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("metadataPath")
    @Expose
    private String metadataPath;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("qualityRuleScope")
    @Expose
    private String qualityRuleScope;
    @SerializedName("logicalOperator")
    @Expose
    private String logicalOperator;
    @SerializedName("metadataPathResourceExtraParams")
    @Expose
    private List<Object> metadataPathResourceExtraParams = null;
    @SerializedName("enable")
    @Expose
    private Boolean enable;
    @SerializedName("threshold")
    @Expose
    private Threshold threshold;
    @SerializedName("predicates")
    @Expose
    private List<Predicate> predicates = null;
    @SerializedName("stepName")
    @Expose
    private String stepName;
    @SerializedName("outputName")
    @Expose
    private String outputName;
    @SerializedName("qualityRuleType")
    @Expose
    private String qualityRuleType;
    @SerializedName("tenant")
    @Expose
    private String tenant;
    @SerializedName("creationDate")
    @Expose
    private String creationDate;
    @SerializedName("modificationDate")
    @Expose
    private String modificationDate;
    private final static long serialVersionUID = -4262174931731781844L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMetadataPath() {
        return metadataPath;
    }

    public void setMetadataPath(String metadataPath) {
        this.metadataPath = metadataPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualityRuleScope() {
        return qualityRuleScope;
    }

    public void setQualityRuleScope(String qualityRuleScope) {
        this.qualityRuleScope = qualityRuleScope;
    }

    public String getLogicalOperator() {
        return logicalOperator;
    }

    public void setLogicalOperator(String logicalOperator) {
        this.logicalOperator = logicalOperator;
    }

    public List<Object> getMetadataPathResourceExtraParams() {
        return metadataPathResourceExtraParams;
    }

    public void setMetadataPathResourceExtraParams(List<Object> metadataPathResourceExtraParams) {
        this.metadataPathResourceExtraParams = metadataPathResourceExtraParams;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Threshold getThreshold() {
        return threshold;
    }

    public void setThreshold(Threshold threshold) {
        this.threshold = threshold;
    }

    public List<Predicate> getPredicates() {
        return predicates;
    }

    public void setPredicates(List<Predicate> predicates) {
        this.predicates = predicates;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public String getOutputName() {
        return outputName;
    }

    public void setOutputName(String outputName) {
        this.outputName = outputName;
    }

    public String getQualityRuleType() {
        return qualityRuleType;
    }

    public void setQualityRuleType(String qualityRuleType) {
        this.qualityRuleType = qualityRuleType;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("metadataPath", metadataPath).append("name", name).append("qualityRuleScope", qualityRuleScope).append("logicalOperator", logicalOperator).append("metadataPathResourceExtraParams", metadataPathResourceExtraParams).append("enable", enable).append("threshold", threshold).append("predicates", predicates).append("stepName", stepName).append("outputName", outputName).append("qualityRuleType", qualityRuleType).append("tenant", tenant).append("creationDate", creationDate).append("modificationDate", modificationDate).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(metadataPath).append(qualityRuleType).append(outputName).append(qualityRuleScope).append(metadataPathResourceExtraParams).append(threshold).append(creationDate).append(predicates).append(modificationDate).append(logicalOperator).append(stepName).append(enable).append(name).append(id).append(tenant).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof QualityRule) == false) {
            return false;
        }
        QualityRule rhs = ((QualityRule) other);
        return new EqualsBuilder().append(metadataPath, rhs.metadataPath).append(qualityRuleType, rhs.qualityRuleType).append(outputName, rhs.outputName).append(qualityRuleScope, rhs.qualityRuleScope).append(metadataPathResourceExtraParams, rhs.metadataPathResourceExtraParams).append(threshold, rhs.threshold).append(creationDate, rhs.creationDate).append(predicates, rhs.predicates).append(modificationDate, rhs.modificationDate).append(logicalOperator, rhs.logicalOperator).append(stepName, rhs.stepName).append(enable, rhs.enable).append(name, rhs.name).append(id, rhs.id).append(tenant, rhs.tenant).isEquals();
    }

}
