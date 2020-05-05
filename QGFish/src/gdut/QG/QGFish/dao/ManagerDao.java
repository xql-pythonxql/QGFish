package gdut.QG.QGFish.dao;

import gdut.QG.QGFish.domain.Manager;

public interface ManagerDao {

    public Manager login(String username, String password);

}
