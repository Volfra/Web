package co.edu.poli.parcial1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.poli.parcial1.model.Cuenta;
import co.edu.poli.parcial1.model.QueryGroupBy;
import co.edu.poli.parcial1.model.Transaccion;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, String>{
	
	@Query("select new co.edu.poli.parcial1.model.QueryGroupBy(t.documento.id, d.descripcion, sum(t.valor) as sum) "
			+ "from Transaccion t, Documento d "
			+ "where t.documento.id = d.id "
			+ "group by t.documento.id")
	List<QueryGroupBy> sumaPorGrupo();	

	@Query("select t " +
		   "from  Transaccion t, Documento d " +
		   "where t.documento.id = d.id " + 
		   "and t.documento.descripcion like %?1%")
	List<Transaccion> filtroDocumento(String desc);	
	
	@Query("select c " +
		   "from  Cuenta c " +
		   "where c.numero not in (select t.cuenta from Transaccion t where t.documento=6795)")
	List<Cuenta> cuentasSinDoc795();	
	
}

