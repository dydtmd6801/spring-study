package service;

import com.sun.jdi.request.DuplicateRequestException;
import domain.Member;
import domain.Register;
import exception.DuplicateMemberException;
import model.MemberDao;
import org.springframework.validation.ValidationUtils;

import java.time.LocalDateTime;

public class RegistService {

    private MemberDao memberDao;

    public RegistService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    private void duplicateUserId(Register register) {
        Member member = memberDao.findByUserId(register.getUserId());
        if(member != null) {
            throw new DuplicateMemberException("dup Member" + register.getUserId());
        }
    }

    public long insertInfo(Register register) {
        duplicateUserId(register);
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
}
