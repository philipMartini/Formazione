
package org.advancia.filippo.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addToDo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addToDo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="toDoToAdd" type="{http://service.filippo.advancia.org/}toDo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addToDo", propOrder = {
    "toDoToAdd"
})
public class AddToDo {

    protected ToDo toDoToAdd;

    /**
     * Gets the value of the toDoToAdd property.
     * 
     * @return
     *     possible object is
     *     {@link ToDo }
     *     
     */
    public ToDo getToDoToAdd() {
        return toDoToAdd;
    }

    /**
     * Sets the value of the toDoToAdd property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToDo }
     *     
     */
    public void setToDoToAdd(ToDo value) {
        this.toDoToAdd = value;
    }

}
