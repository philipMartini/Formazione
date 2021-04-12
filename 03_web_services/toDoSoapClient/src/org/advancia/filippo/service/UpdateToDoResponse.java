
package org.advancia.filippo.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateToDoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateToDoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UpdatedToDo" type="{http://service.filippo.advancia.org/}toDo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateToDoResponse", propOrder = {
    "updatedToDo"
})
public class UpdateToDoResponse {

    @XmlElement(name = "UpdatedToDo")
    protected ToDo updatedToDo;

    /**
     * Gets the value of the updatedToDo property.
     * 
     * @return
     *     possible object is
     *     {@link ToDo }
     *     
     */
    public ToDo getUpdatedToDo() {
        return updatedToDo;
    }

    /**
     * Sets the value of the updatedToDo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToDo }
     *     
     */
    public void setUpdatedToDo(ToDo value) {
        this.updatedToDo = value;
    }

}
