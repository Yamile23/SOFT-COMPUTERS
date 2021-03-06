package factory;

import dal.Configuracion;
import dao.*;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public abstract class FactoryDao {

	protected static FactoryDao instancia;
	public static FactoryDao getFactoryInstance(){
		if(instancia == null){
                    Configuracion config = Configuracion.getConfiguracion();
                    if(config.getDbEngine().equals("PostgreSQL"));
                            instancia = FactoryDaoMySQL.getFactoryInstance();
		}
		return instancia;
	}

	public abstract ContactoDao getNewContactoDao();

	public abstract FileDao getNewFileDao();

	public abstract UsuarioDao getNewUsuarioDao();
        
        public abstract UsuariopruebaDao getUsuariopruebaDao();
        

}

