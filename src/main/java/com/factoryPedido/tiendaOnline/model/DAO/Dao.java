package com.factoryPedido.tiendaOnline.model.DAO;

// import com.factoryPedido.tiendaOnline.model.Cliente;

public interface Dao<T> {
        void insertar(T obj);
        void actualizar(T obj);
        void eliminar(T obj);
        T buscar(Object id);
}
