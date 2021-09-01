package com.itheima.authority.biz.service.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.authority.dto.auth.LoginDTO;
import com.itheima.authority.dto.auth.UserUpdatePasswordDTO;
import com.itheima.authority.entity.auth.User;
import com.itheima.authority.vo.ImportResultVO;
import com.itheima.tools.base.R;
import com.itheima.tools.database.mybatis.conditions.query.LbqWrapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业务接口
 * 账号
 * </p>
 */
public interface UserService extends IService<User> {

    Map<String, Object> getDataScopeById(Long userId);

    List<User> findUserByRoleId(Long roleId, String keyword);

    void updatePasswordErrorNumById(Long id);

    User getByAccount(String account);

    void updateLoginTime(String account);

    User saveUser(User user);

    boolean reset(List<Long> ids);

    User updateUser(User user);

    boolean remove(List<Long> ids);

    IPage<User> findUserPage(IPage<User> page, Map<String, Object> params);

    Boolean updatePassword(UserUpdatePasswordDTO data);

    int resetPassErrorNum(Long id);

    ImportResultVO importExcel(MultipartFile file);

    void updateUserRole(User user);

    R<LoginDTO> current();
}
