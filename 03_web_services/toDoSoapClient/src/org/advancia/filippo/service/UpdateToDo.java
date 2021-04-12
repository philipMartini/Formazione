
package org.advancia.filippo.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateToDo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateToDo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="toDoId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="updatedTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="updatedText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateToDo", propOrder = {
    "toDoId",
    "updatedTitle",
    "updatedText"
})
public class UpdateToDo {

    protected int toDoId;
    protected String updatedTitle;
    protected String updatedText;

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

    /**
     * Gets the value of the updatedTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdatedTitle() {
        return updatedTitle;
    }

    /**
     * Sets the value of the updatedTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdatedTitle(String value) {
        this.updatedTitle = value;
    }

    /**
     * Gets the value of the updatedText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdatedText() {
        return updatedText;
    }

    /**
     * Sets the value of the updatedText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdatedText(String value) {
        this.updatedText = value;
    }

}
