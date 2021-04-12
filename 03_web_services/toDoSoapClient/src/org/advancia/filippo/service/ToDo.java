
package org.advancia.filippo.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for toDo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="toDo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ToDoID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ToDoText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ToDoTITLE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "toDo", propOrder = {
    "toDoID",
    "toDoText",
    "toDoTITLE"
})
public class ToDo {

    @XmlElement(name = "ToDoID")
    protected int toDoID;
    @XmlElement(name = "ToDoText")
    protected String toDoText;
    @XmlElement(name = "ToDoTITLE")
    protected String toDoTITLE;

    /**
     * Gets the value of the toDoID property.
     * 
     */
    public int getToDoID() {
        return toDoID;
    }

    /**
     * Sets the value of the toDoID property.
     * 
     */
    public void setToDoID(int value) {
        this.toDoID = value;
    }

    /**
     * Gets the value of the toDoText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToDoText() {
        return toDoText;
    }

    /**
     * Sets the value of the toDoText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToDoText(String value) {
        this.toDoText = value;
    }

    /**
     * Gets the value of the toDoTITLE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToDoTITLE() {
        return toDoTITLE;
    }

    /**
     * Sets the value of the toDoTITLE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToDoTITLE(String value) {
        this.toDoTITLE = value;
    }

}
