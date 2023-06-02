package service;

import domain.ChangeInfo;
import domain.Member;
import exception.NotFoundUserInfoException;
import model.MemberDao;

public class ChangeInfoService {

    private MemberDao memberDao;

    public ChangeInfoService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void changeInfo(String userId, ChangeInfo changeInfo) {
        Member userInfo = memberDao.findByUserId(userId);
        if(userInfo == null) {
            throw new NotFoundUserInfoException();
        }
        userInfo.setNewInfo(changeInfo.getName(), changeInfo.getPhoneNumber());

        memberDao.update(userInfo);
    }
}
