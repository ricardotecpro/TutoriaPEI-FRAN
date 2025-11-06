package com.br.tutoria.pei.fran.repository;

import com.br.tutoria.pei.fran.entities.Usuario;
import com.br.tutoria.pei.fran.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByCpf(String cpf);

    @Query(nativeQuery = true, value = """
			SELECT tb_usuario.nome AS username, tb_usuario.cpf, tb_papel.id AS roleId, tb_papel.authority
			FROM tb_usuario
			INNER JOIN tb_usuario_papel ON tb_usuario.id = tb_usuario_papel.usuario_id
			INNER JOIN tb_papel ON tb_papel.id = tb_usuario_papel.papel_id
			WHERE tb_usuario.nome = :nome
		""")
    List<UserDetailsProjection> searchUsuarioAndPapeisByNome(String nome);
}