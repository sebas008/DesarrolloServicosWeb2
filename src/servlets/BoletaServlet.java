package servlets;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import beans.CarritoDTO;
import beans.UsuarioDTO;
import beans.VentaDTO;

/**
 * Servlet implementation class BoletaServlet
 */
@WebServlet("/BoletaServlet")
public class BoletaServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("application/pdf");
		ServletOutputStream sos = response.getOutputStream();

		// Recuperar el usuario y su ultima venta registrada
		UsuarioDTO usu = (UsuarioDTO) request.getSession().getAttribute("usuario");
		VentaDTO ven = ClientBuilder.newClient() .target("http://localhost:8080/ApiFerreteriaSaravia/ventaRest/ultimaVentaXUsuario/" + usu.getCodigo()).request(MediaType.APPLICATION_JSON).get(VentaDTO.class);

		ArrayList<CarritoDTO> listado = new ArrayList<>();
		CarritoDTO[] carrito = ClientBuilder.newClient().target("http://localhost:8080/ApiFerreteriaSaravia/carritoRest/listarUltimaVenta/" + ven.getNumVenta() + "/" + usu.getCodigo()).request(MediaType.APPLICATION_JSON).get(CarritoDTO[].class);
		for (CarritoDTO c : carrito)
			listado.add(c);
		
		try
		{
			double total = 0.0; // calculara el total de la venta y lo imprimira

			Document documento = new Document();
			PdfWriter writer = PdfWriter.getInstance(documento, sos);
			writer.setInitialLeading(20);

			documento.open();

			Paragraph titulo = new Paragraph("***BOLETA DE VENTA***",
					FontFactory.getFont("arial", 30, Font.BOLD, BaseColor.BLACK));
			titulo.setAlignment(Element.ALIGN_CENTER);
			documento.add(titulo);

			// DATOS DEL USUARIO
			documento.add(new Paragraph(" "));
			documento.add(new Paragraph("Fecha	: " + getFormatoFecha(ven.getFecha()),
					FontFactory.getFont("arial", 13, Font.BOLD, BaseColor.BLUE)));
			documento.add(new Paragraph("Cliente: " + usu.getNombre() + " " + usu.getApellido(),
					FontFactory.getFont("arial", 13, Font.BOLD, BaseColor.BLUE)));
			documento.add(new Paragraph(" "));

			// LISTA DE PRODUCTOS
			PdfPTable tabla = new PdfPTable(6);
			tabla.setWidthPercentage(100);
			float[] widths =
			{ 1.3f, 1.1f, 0.8f, 0.7f, 0.7f, 0.9f };
			tabla.setWidths(widths);

			// Columna 0
			PdfPCell celda = generarCabeceraTabla("Producto");
			tabla.addCell(celda);

			// Columna 1
			celda = generarCabeceraTabla("Descripcion");
			tabla.addCell(celda);

			// Columna 2
			celda = generarCabeceraTabla("Marca");
			tabla.addCell(celda);

			// Columna 3
			celda = generarCabeceraTabla("Precio");
			tabla.addCell(celda);

			// Columna 4
			celda = generarCabeceraTabla("Cantidad");
			tabla.addCell(celda);

			// Columna 5
			celda = generarCabeceraTabla("SubTotal");
			tabla.addCell(celda);

			// Generar la tabla
			for (CarritoDTO c : listado)
			{
				// Imagen del producto
				String ruta = getServletContext().getRealPath("img/productos/todos/" + c.getCodigo() + ".jpg");
				Image imagen = Image.getInstance(ruta);
				tabla.addCell(imagen);

				// Informacion del producto y de la venta
				PdfPCell registro = generarCeldaTabla(c.getDescripcion());
				tabla.addCell(registro);

				registro = generarCeldaTabla(c.getMarca());
				tabla.addCell(registro);

				registro = generarCeldaTabla(getFormatoMoneda(c.getPrecio()));
				registro.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(registro);

				registro = generarCeldaTabla("" + c.getCantidad());
				registro.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(registro);

				registro = generarCeldaTabla(getFormatoMoneda(c.getSubTotal()));
				registro.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(registro);

				total += c.getSubTotal(); // Calculando el total
			}

			documento.add(tabla);
			PdfPTable celdaTotal = new PdfPTable(1);
			celdaTotal.setWidthPercentage(16.35f);
			celdaTotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
			celdaTotal.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			celdaTotal.addCell(new Paragraph("\n\n" + getFormatoMoneda(total) + "\n\n\n",
					FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLACK)));

			documento.add(celdaTotal);
			documento.close();
		}
		catch (Exception e)
		{
			request.setAttribute("msgBoleta", e.getMessage());
			request.getRequestDispatcher("Carrito.jsp").forward(request, response);
		}
	}

	/*
	 * OTROS METODOS
	 */
	PdfPCell generarCabeceraTabla(String descripcion)
	{
		PdfPCell celdita = new PdfPCell(new Paragraph("\n" + descripcion + "\n\n", FontFactory.getFont("arial", // fuente
				12, // tamaño
				Font.BOLD, // estilo
				BaseColor.BLACK)));

		celdita.setHorizontalAlignment(Element.ALIGN_CENTER);
		celdita.setBackgroundColor(BaseColor.GREEN);

		return celdita;
	}

	PdfPCell generarCeldaTabla(String descripcion)
	{
		PdfPCell celdita = new PdfPCell(new Paragraph(descripcion, FontFactory.getFont("arial", // fuente
				11, // tamaño
				BaseColor.BLACK))); // color

		return celdita;
	}

	/*
	 * FORMATEAR
	 */
	public String getFormatoMoneda(double decimal)
	{
		DecimalFormat df = new DecimalFormat("######.00");

		return "S/." + df.format(decimal);
	}

	public String getFormatoFecha(String fecha) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfUsuario = new SimpleDateFormat("dd/MM/yyyy");

		return sdfUsuario.format(sdf.parse(fecha));
	}
}
