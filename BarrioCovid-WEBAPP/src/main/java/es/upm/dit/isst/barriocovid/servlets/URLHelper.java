package es.upm.dit.isst.barriocovid.servlets;

public class URLHelper {

	public static String getURL() {
		String envValue = System.getenv("CovidService_SRV_SERVICE_HOST");
		if (envValue == null)
			return "http://localhost:8080/BarrioCovid-SERVICE/rest/COVID";
		else
			return envValue;
	}
}
