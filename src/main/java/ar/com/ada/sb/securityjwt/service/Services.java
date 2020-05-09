package ar.com.ada.sb.securityjwt.service;

import java.util.List;

public interface Services<T> {

    List<T> findAll();

    T save(T dto);

    void delete(Long id);

}
