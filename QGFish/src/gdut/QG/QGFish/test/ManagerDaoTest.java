package gdut.QG.QGFish.test;

import gdut.QG.QGFish.dao.ManagerDao;
import gdut.QG.QGFish.dao.impl.ManagerDaoImpl;
import gdut.QG.QGFish.domain.Manager;

public class ManagerDaoTest {
    public static void main(String[] args) {
        login();
    }

    private static void login() {
        ManagerDao dao = new ManagerDaoImpl();
        Manager manager = dao.login("xql", "xql");
        System.out.println(manager);
    }

}
