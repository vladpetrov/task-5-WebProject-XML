
package by.epam.training.task05.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deposit" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="bank_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="registration_country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="deposit_type" type="{http://www.training.by/bank}Deposit_type"/>
 *                   &lt;element name="depositor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="account_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="amount_of_deposit" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="profitability" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="time_constraints" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="deposit_id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "deposit"
})
@XmlRootElement(name = "bank", namespace = "http://www.training.by/bank")
public class Bank {

    @XmlElement(required = true)
    protected List<Bank.Deposit> deposit;

    /**
     * Gets the value of the deposit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deposit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeposit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Bank.Deposit }
     * 
     * 
     */
    public List<Bank.Deposit> getDeposit() {
        if (deposit == null) {
            deposit = new ArrayList<Bank.Deposit>();
        }
        return this.deposit;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="bank_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="registration_country" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="deposit_type" type="{http://www.training.by/bank}Deposit_type"/>
     *         &lt;element name="depositor" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="account_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="amount_of_deposit" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="profitability" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="time_constraints" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *       &lt;/sequence>
     *       &lt;attribute name="deposit_id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "bankName",
        "registrationCountry",
        "depositType",
        "depositor",
        "accountId",
        "amountOfDeposit",
        "profitability",
        "timeConstraints"
    })
    public static class Deposit {

        @XmlElement(name = "bank_name", required = true)
        protected String bankName;
        @XmlElement(name = "registration_country", required = true)
        protected String registrationCountry;
        @XmlElement(name = "deposit_type", required = true)
        @XmlSchemaType(name = "string")
        protected DepositType depositType;
        @XmlElement(required = true)
        protected String depositor;
        @XmlElement(name = "account_id")
        protected Integer accountId;
        @XmlElement(name = "amount_of_deposit", required = true)
        protected Double amountOfDeposit;
        @XmlElement(required = true)
        protected Double profitability;
        @XmlElement(name = "time_constraints", required = true)
        @XmlSchemaType(name = "date")
        protected String timeConstraints;
        @XmlAttribute(name = "deposit_id", required = true)
        protected String depositId;

        /**
         * Gets the value of the bankName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBankName() {
            return bankName;
        }

        /**
         * Sets the value of the bankName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBankName(String value) {
            this.bankName = value;
        }

        /**
         * Gets the value of the registrationCountry property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRegistrationCountry() {
            return registrationCountry;
        }

        /**
         * Sets the value of the registrationCountry property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRegistrationCountry(String value) {
            this.registrationCountry = value;
        }

        /**
         * Gets the value of the depositType property.
         * 
         * @return
         *     possible object is
         *     {@link DepositType }
         *     
         */
        public DepositType getDepositType() {
            return depositType;
        }

        /**
         * Sets the value of the depositType property.
         * 
         * @param value
         *     allowed object is
         *     {@link DepositType }
         *     
         */
        public void setDepositType(DepositType value) {
            this.depositType = value;
        }

        /**
         * Gets the value of the depositor property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDepositor() {
            return depositor;
        }

        /**
         * Sets the value of the depositor property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDepositor(String value) {
            this.depositor = value;
        }

        /**
         * Gets the value of the accountId property.
         * 
         */
        public int getAccountId() {
            return accountId;
        }

        /**
         * Sets the value of the accountId property.
         * 
         */
        public void setAccountId(int value) {
            this.accountId = value;
        }

        /**
         * Gets the value of the amountOfDeposit property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public Double getAmountOfDeposit() {
            return amountOfDeposit;
        }

        /**
         * Sets the value of the amountOfDeposit property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAmountOfDeposit(Double value) {
            this.amountOfDeposit = value;
        }

        /**
         * Gets the value of the profitability property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public Double getProfitability() {
            return profitability;
        }

        /**
         * Sets the value of the profitability property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setProfitability(Double value) {
            this.profitability = value;
        }

        /**
         * Gets the value of the timeConstraints property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public String getTimeConstraints() {
            return this.timeConstraints;
        }

        /**
         * Sets the value of the timeConstraints property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setTimeConstraints(String value) {
            this.timeConstraints = value;
        }

        /**
         * Gets the value of the depositId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDepositId() {
            return depositId;
        }

        /**
         * Sets the value of the depositId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDepositId(String value) {
            this.depositId = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Deposit deposit = (Deposit) o;

            if (accountId != deposit.accountId) return false;
            if (amountOfDeposit != null ? !amountOfDeposit.equals(deposit.amountOfDeposit) : deposit.amountOfDeposit != null)
                return false;
            if (bankName != null ? !bankName.equals(deposit.bankName) : deposit.bankName != null) return false;
            if (depositId != null ? !depositId.equals(deposit.depositId) : deposit.depositId != null) return false;
            if (depositType != deposit.depositType) return false;
            if (depositor != null ? !depositor.equals(deposit.depositor) : deposit.depositor != null) return false;
            if (profitability != null ? !profitability.equals(deposit.profitability) : deposit.profitability != null)
                return false;
            if (registrationCountry != null ? !registrationCountry.equals(deposit.registrationCountry) : deposit.registrationCountry != null)
                return false;
            if (timeConstraints != null ? !timeConstraints.equals(deposit.timeConstraints) : deposit.timeConstraints != null)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = bankName != null ? bankName.hashCode() : 0;
            result = 31 * result + (registrationCountry != null ? registrationCountry.hashCode() : 0);
            result = 31 * result + (depositType != null ? depositType.hashCode() : 0);
            result = 31 * result + (depositor != null ? depositor.hashCode() : 0);
            result = 31 * result + accountId;
            result = 31 * result + (amountOfDeposit != null ? amountOfDeposit.hashCode() : 0);
            result = 31 * result + (profitability != null ? profitability.hashCode() : 0);
            result = 31 * result + (timeConstraints != null ? timeConstraints.hashCode() : 0);
            result = 31 * result + (depositId != null ? depositId.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Deposit{");
            sb.append("bankName='").append(bankName).append('\'');
            sb.append(", registrationCountry='").append(registrationCountry).append('\'');
            sb.append(", depositType=").append(depositType);
            sb.append(", depositor='").append(depositor).append('\'');
            sb.append(", accountId=").append(accountId);
            sb.append(", amountOfDeposit=").append(amountOfDeposit);
            sb.append(", profitability=").append(profitability);
            sb.append(", timeConstraints=").append(timeConstraints);
            sb.append(", depositId='").append(depositId).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

}
