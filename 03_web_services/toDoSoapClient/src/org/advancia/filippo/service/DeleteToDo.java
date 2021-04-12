
package org.advancia.filippo.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteToDo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteToDo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="toDoId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteToDo", propOrder = {
    "toDoId"
})
public class DeleteToDo {

    protected int toDoId;

    /**
     * Gets the value of the toDoId property.
     * 
     */
    public int getToDoId() {
        return toDoId;
    }

    /**
     * Sets the value of the toDoId property.
     * 
     */
    public void setToDoId(int value) {
        this.toDoId = value;
    }

}
