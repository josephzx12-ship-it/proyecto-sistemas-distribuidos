//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.11.17 a las 10:48:27 PM PET 
//


package com.autonoma.proyecto.facturas;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id_pedido" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="monto_total" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="datos_cliente" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idPedido",
    "montoTotal",
    "datosCliente"
})
@XmlRootElement(name = "crearFacturaRequest")
public class CrearFacturaRequest {

    @XmlElement(name = "id_pedido", required = true)
    protected String idPedido;
    @XmlElement(name = "monto_total")
    protected double montoTotal;
    @XmlElement(name = "datos_cliente", required = true)
    protected String datosCliente;

    /**
     * Obtiene el valor de la propiedad idPedido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPedido() {
        return idPedido;
    }

    /**
     * Define el valor de la propiedad idPedido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPedido(String value) {
        this.idPedido = value;
    }

    /**
     * Obtiene el valor de la propiedad montoTotal.
     * 
     */
    public double getMontoTotal() {
        return montoTotal;
    }

    /**
     * Define el valor de la propiedad montoTotal.
     * 
     */
    public void setMontoTotal(double value) {
        this.montoTotal = value;
    }

    /**
     * Obtiene el valor de la propiedad datosCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatosCliente() {
        return datosCliente;
    }

    /**
     * Define el valor de la propiedad datosCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatosCliente(String value) {
        this.datosCliente = value;
    }

}
