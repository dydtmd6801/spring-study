package service;

import domain.Login;
import domain.Member;
import exception.LoginFailException;
import model.MemberDao;

public class LoginService {

    private MemberDao memberDao;

    public LoginService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void checkLogin(Login login) {
        Member member = memberDao.findByUserId(login.getId());
        if (member == null) {
            throw new LoginFailException();
        } else {
            if (!member.getPassword().equals(login.getPassword())) {
                throw new LoginFailException();
            }
        }
    }
}
