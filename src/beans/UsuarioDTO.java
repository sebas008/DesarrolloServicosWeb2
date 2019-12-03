package beans;

public class UsuarioDTO
{
	String codigo, nombre, apellido, email, clave, codDistrito, direccion, telefono, dni;
	boolean cliente;

	/*
	 * Adicionales
	 */
	double totalComprado;
	int cantidadComprado;

	/*
	 * Get y Set
	 */
	public String getCodigo()
	{
		return codigo;
	}

	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getApellido()
	{
		return apellido;
	}

	public void setApellido(String apellido)
	{
		this.apellido = apellido;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getClave()
	{
		return clave;
	}

	public void setClave(String clave)
	{
		this.clave = clave;
	}

	public String getCodDistrito()
	{
		return codDistrito;
	}

	public void setCodDistrito(String codDistrito)
	{
		this.codDistrito = codDistrito;
	}

	public String getDireccion()
	{
		return direccion;
	}

	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}

	public String getTelefono()
	{
		return telefono;
	}

	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}

	public String getDni()
	{
		return dni;
	}

	public void setDni(String dni)
	{
		this.dni = dni;
	}
	
	public boolean isCliente()
	{
		return cliente;
	}

	public void setCliente(boolean cliente)
	{
		this.cliente = cliente;
	}

	public double getTotalComprado()
	{
		return totalComprado;
	}

	public void setTotalComprado(double totalComprado)
	{
		this.totalComprado = totalComprado;
	}
	public int getCantidadComprado()
	{
		return cantidadComprado;
	}

	public void setCantidadComprado(int cantidadComprado)
	{
		this.cantidadComprado = cantidadComprado;
	}
}
