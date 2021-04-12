
package org.advancia.filippo.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addToDoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addToDoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addedToDo" type="{http://service.filippo.advancia.org/}toDo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addToDoResponse", propOrder = {
    "addedToDo"
})
public class AddToDoResponse {

    protected ToDo addedToDo;

    /**
     * Gets the value of the addedToDo property.
     * 
     * @return
     *     possible object is
     *     {@link ToDo }
     *     
     */
    public ToDo getAddedToDo() {
        return addedToDo;
    }

    /**
     * Sets the value of the addedToDo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToDo }
     *     
     */
    public void setAddedToDo(ToDo value) {
        this.addedToDo = value;
    }

}
