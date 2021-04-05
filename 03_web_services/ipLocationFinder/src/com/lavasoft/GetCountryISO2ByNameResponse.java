
package com.lavasoft;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetCountryISO2ByNameResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getCountryISO2ByNameResult"
})
@XmlRootElement(name = "GetCountryISO2ByNameResponse")
public class GetCountryISO2ByNameResponse {

    @XmlElement(name = "GetCountryISO2ByNameResult")
    protected String getCountryISO2ByNameResult;

    /**
     * Recupera il valore della proprietà getCountryISO2ByNameResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetCountryISO2ByNameResult() {
        return getCountryISO2ByNameResult;
    }

    /**
     * Imposta il valore della proprietà getCountryISO2ByNameResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetCountryISO2ByNameResult(String value) {
        this.getCountryISO2ByNameResult = value;
    }

}
