
package schemas.Payments.Events;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ForeignExchangeDetails implements Serializable
{

    @SerializedName("sourceCurrency")
    @Expose
    private String sourceCurrency;
    @SerializedName("targetCurrency")
    @Expose
    private String targetCurrency;
    @SerializedName("exchangeRate")
    @Expose
    private String exchangeRate;
    private final static long serialVersionUID = 8163452996357989080L;

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("sourceCurrency", sourceCurrency).append("targetCurrency", targetCurrency).append("exchangeRate", exchangeRate).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sourceCurrency).append(targetCurrency).append(exchangeRate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ForeignExchangeDetails) == false) {
            return false;
        }
        ForeignExchangeDetails rhs = ((ForeignExchangeDetails) other);
        return new EqualsBuilder().append(sourceCurrency, rhs.sourceCurrency).append(targetCurrency, rhs.targetCurrency).append(exchangeRate, rhs.exchangeRate).isEquals();
    }

}
