
package org.advancia.filippo.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getToDoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getToDoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TODo" type="{http://service.filippo.advancia.org/}toDo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getToDoResponse", propOrder = {
    "toDo"
})
public class GetToDoResponse {

    @XmlElement(name = "TODo")
    protected ToDo toDo;

    /**
     * Gets the value of the toDo property.
     * 
     * @return
     *     possible object is
     *     {@link ToDo }
     *     
     */
    public ToDo getTODo() {
        return toDo;
    }

    /**
     * Sets the value of the toDo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToDo }
     *     
     */
    public void setTODo(ToDo value) {
        this.toDo = value;
    }

}
