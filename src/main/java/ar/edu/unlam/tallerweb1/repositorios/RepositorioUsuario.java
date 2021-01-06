	package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Regalo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	
	Usuario consultarUsuario (Usuario usuario);
	Boolean guardarUsuario(Usuario usuario);
	Boolean buscarUsuarioPorNombreUsuario(Usuario usuario);
	Usuario buscarUsuarioPorEmail(Usuario usuario);
	Usuario getUsuarioPorUsername(String username);
	Boolean checkUserByEmail(String email);
	Usuario getUserByEmail(String email);
	Usuario getUserById(long idRegalador);
}
