package com.example.login_rest.service;

import com.example.login_rest.model.Factura;
import com.example.login_rest.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public void procesarFacturaXML(InputStream xmlFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Extraer datos del CFDI
            Element comprobante = document.getDocumentElement();
            String uuid = comprobante.getElementsByTagName("tfd:TimbreFiscalDigital").item(0).getAttributes().getNamedItem("UUID").getTextContent();
            String fechaStr = comprobante.getAttribute("Fecha");
            Date fecha = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(fechaStr);
            String total = comprobante.getAttribute("Total");

            // Extraer datos del Emisor
            Element emisor = (Element) comprobante.getElementsByTagName("cfdi:Emisor").item(0);
            String rfcEmisor = emisor.getAttribute("Rfc");
            String nombreEmisor = emisor.getAttribute("Nombre");

            // Crear y guardar la factura en la base de datos
            Factura factura = new Factura();
            factura.setUuid(uuid);
            factura.setFecha(fecha);
            factura.setNombreEmpresa(nombreEmisor);
            factura.setRfc(rfcEmisor);
            factura.setCargo(Double.parseDouble(total));
            facturaRepository.save(factura);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //metodo para obtener todas las facturas
    public List<Factura> obtenerTodasLasFacturas() {
        return facturaRepository.findAll();
    }

    public void eliminarPorId(int id) {
        facturaRepository.deleteById(id);
    }

}