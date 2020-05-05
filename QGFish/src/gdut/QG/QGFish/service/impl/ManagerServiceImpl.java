package gdut.QG.QGFish.service.impl;

import gdut.QG.QGFish.dao.ManagerDao;
import gdut.QG.QGFish.dao.impl.ManagerDaoImpl;
import gdut.QG.QGFish.domain.Manager;
import gdut.QG.QGFish.domain.ResponseInfo;
import gdut.QG.QGFish.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {

    private ManagerDao managerDao = new ManagerDaoImpl();

    @Override
    public ResponseInfo login(String username, String password) {
        Manager manager = managerDao.login(username, password);
        ResponseInfo info = new ResponseInfo();
        if (manager != null) {
            info.setStatus(true);
            info.setMessage("Success");
            info.setData(manager);
        } else {
            info.setStatus(false);
            info.setMessage("Error");
            info.setData(null);
        }
        return info;
    }

}
