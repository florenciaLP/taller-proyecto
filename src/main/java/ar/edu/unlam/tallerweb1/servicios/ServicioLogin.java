package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {
	Usuario consultarUsuario(Usuario usuario);
	Boolean guardarUsuario(Usuario usuario);
	Boolean buscarUsuarioPorNombreUsuario(Usuario usuario);
	Usuario buscarUsuarioPorEmail(Usuario usuario);
	boolean verificarSiValoresNulos(Usuario usuario);
}