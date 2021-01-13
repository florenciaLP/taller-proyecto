package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioUsuario {

	Usuario getUsuarioPorNombreUsuario(String username);

	Boolean checkUserByEmail(String email);

	Usuario getUsuarioByEmail(String email);

	Usuario getUsuarioById(long idRegalador);
}
