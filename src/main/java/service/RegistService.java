package service;

import com.sun.jdi.request.DuplicateRequestException;
import domain.Member;
import domain.Register;
import model.MemberDao;

import java.time.LocalDateTime;

public class RegistService {

    private MemberDao memberDao;

    public RegistService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    private int duplicateUserId(Register register) {
        Member member = memberDao.findByUserId(register.getUserId());
        if(member != null) {
            return 2;
        }
        return 1;
    }

    public long insertInfo(Register register) {
        int check = duplicateUserId(register);
        if(check == 1 && register.getPassword().equals(register.getConfirmPassword())) {
            Member newMember = new Member(
                    register.getUserId(),
                    register.getPassword(),
                    register.getName(),
                    register.getNickName(),
                    register.getPhoneNumber(),
                    register.getEmail(),
                    LocalDateTime.now());
            memberDao.insert(newMember);
            return newMember.getId();
        }
        if(check == 2) {
            return check;
        }
        return -1;
    }
}
