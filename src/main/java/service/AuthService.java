package service;

import domain.AuthInfo;
import domain.Login;
import domain.Member;
import model.MemberDao;

public class AuthService {

    private MemberDao memberDao;

    public AuthService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public AuthInfo authenticate(Login login) {
        Member member = memberDao.findByUserId(login.getId());
        return new AuthInfo(member.getUserId(), member.getName(), member.getPhoneNumber());
    }
}
