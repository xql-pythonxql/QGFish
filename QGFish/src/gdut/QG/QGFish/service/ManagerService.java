package gdut.QG.QGFish.service;

import gdut.QG.QGFish.domain.ResponseInfo;

public interface ManagerService {

    public ResponseInfo login(String username, String password);

}
