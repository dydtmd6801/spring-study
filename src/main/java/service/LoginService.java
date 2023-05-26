package service;

import domain.Login;
import domain.Member;
import model.MemberDao;

public class LoginService {

    private MemberDao memberDao;

    public LoginService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public int checkLogin(Login login) {
        Member member = memberDao.findByUserId(login.getId());
        if(member == null) {
            return 2;
        }
        if(member.getPassword() != login.getPassword()) {
            return 3;
        }
        return 1;
    }
}
