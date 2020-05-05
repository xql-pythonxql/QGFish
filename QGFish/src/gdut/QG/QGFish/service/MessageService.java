package gdut.QG.QGFish.service;

import gdut.QG.QGFish.domain.ResponseInfo;


public interface MessageService {

    public ResponseInfo selectByUserId(String user, int userId);

    public ResponseInfo buyResponse(int messageId, boolean flag);

    public ResponseInfo sureGood(int id);

    public ResponseInfo cancelGood(int id);
}
