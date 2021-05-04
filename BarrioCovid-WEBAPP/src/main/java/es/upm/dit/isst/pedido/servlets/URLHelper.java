package es.upm.dit.isst.pedido.servlets;

public class URLHelper {
    public static String getURL() {
            String envValue = System.getenv("PEDIDOSERVICE_SRV_SERVICE_HOST");
            if(envValue == null)
                    return "http://localhost:8080/BarrioCovid-SERVICE/rest/PEDIDOs";
            else
                    return envValue;
    }
}
