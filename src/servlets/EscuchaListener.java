package servlets;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import beans.CarritoDTO;

/**
 * Application Lifecycle Listener implementation class EscuchaListener
 *
 */
@WebListener
public class EscuchaListener implements HttpSessionListener 
{
    /**
     * Default constructor. 
     */
    public EscuchaListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  
    { 
    	//Variables globales
    	ArrayList<CarritoDTO> carrito = new ArrayList<CarritoDTO>();
    	int cantArticulos = 0;
    	double totalVenta = 0.0;
    	
    	//Enviar las variables como atributos de la session
    	arg0.getSession().setAttribute("carrito", carrito);
    	arg0.getSession().setAttribute("cantArticulos", cantArticulos);
    	arg0.getSession().setAttribute("totalVenta", totalVenta);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  
    {
    	//Identificamos la session a cerrar
    	System.out.println("Cerrando session ID: " + arg0.getSession().getId());
    }
	
}
