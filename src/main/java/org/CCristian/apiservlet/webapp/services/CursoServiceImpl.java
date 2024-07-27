package org.CCristian.apiservlet.webapp.services;

import org.CCristian.apiservlet.webapp.models.Curso;
import org.CCristian.apiservlet.webapp.repositories.CursoRepositorioImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CursoServiceImpl implements CursoService{

    private CursoRepositorioImpl repositoryJBDC;

    public CursoServiceImpl(Connection connection) {
        this.repositoryJBDC = new CursoRepositorioImpl(connection);
    }

    @Override
    public List<Curso> listar() throws SecurityException {
        try {
            return repositoryJBDC.listar();
        }catch (SQLException throwables){
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Curso> porNombre(String nombre) {
        try {
            return Optional.ofNullable((Curso) repositoryJBDC.porNombre(nombre));
        } catch (SQLException throwables){
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
