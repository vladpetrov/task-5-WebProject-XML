
package by.epam.training.task05.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Deposit_type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Deposit_type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="demand"/>
 *     &lt;enumeration value="fixed"/>
 *     &lt;enumeration value="estimated"/>
 *     &lt;enumeration value="accumulation"/>
 *     &lt;enumeration value="savings"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Deposit_type", namespace = "http://www.training.by/bank")
@XmlEnum
public enum DepositType {

    @XmlEnumValue("demand")
    DEMAND("demand"),
    @XmlEnumValue("fixed")
    FIXED("fixed"),
    @XmlEnumValue("estimated")
    ESTIMATED("estimated"),
    @XmlEnumValue("accumulation")
    ACCUMULATION("accumulation"),
    @XmlEnumValue("savings")
    SAVINGS("savings");
    private final String value;

    DepositType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DepositType fromValue(String v) {
        for (DepositType c: DepositType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
