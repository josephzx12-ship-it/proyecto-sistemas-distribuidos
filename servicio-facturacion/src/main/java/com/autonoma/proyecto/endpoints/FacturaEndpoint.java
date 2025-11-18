package com.autonoma.proyecto.endpoints;

// Importamos las clases que generamos en el Paso 15
import com.autonoma.proyecto.facturas.CrearFacturaRequest;
import com.autonoma.proyecto.facturas.CrearFacturaResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint // Marca esta clase como un endpoint de SOAP
public class FacturaEndpoint {

    private static final String NAMESPACE_URI = "http://www.autonoma.com/proyecto/facturas";

    // Escucha peticiones que tengan el 'localPart' = "crearFacturaRequest"
    // y el namespace que definimos.
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "crearFacturaRequest")
    @ResponsePayload // Indica que el objeto que devolvemos será el 'payload' de la respuesta
    public CrearFacturaResponse crearFactura(@RequestPayload CrearFacturaRequest request) {

        // --- Aquí iría la lógica de negocio ---
        System.out.println("Solicitud de factura recibida para pedido: " + request.getIdPedido());
        System.out.println("Monto: " + request.getMontoTotal());
        // (Aquí guardaríamos en una base de datos, etc.)
        // --- Fin de la lógica ---

        // Creamos la respuesta usando la clase generada
        CrearFacturaResponse response = new CrearFacturaResponse();
        response.setIdFactura(12345L); // Un ID de factura simulado
        response.setStatus("CREADA");
        response.setMensaje("Factura creada exitosamente.");

        return response;
    }
}