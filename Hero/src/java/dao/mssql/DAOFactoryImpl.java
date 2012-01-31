/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.mssql;

/**
 *
 * @author a
 */
import dao.DAOFactory;
import dao.HeroDAO;

public class DAOFactoryImpl extends DAOFactory {
	private HeroDAO heroDAO = new HeroDAOImpl();
    public HeroDAO getHeroDAO() {
        return heroDAO;
    }
}
