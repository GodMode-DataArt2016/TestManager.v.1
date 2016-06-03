package org.GodMode.TestManager.service;

import org.GodMode.TestManager.entity.Quiz;
import org.GodMode.TestManager.entity.Role;
import org.GodMode.TestManager.entity.User;

import java.util.List;

public interface UserService {

    public void save(User user);

    public void update(User user);

    public User findByid(Long id);

    public List<User> getAllUsers(Integer offset, Integer maxResults);

    public Long getAllUsersTotalResulCount();

    public Long getAllUsersPagesNumber(Integer maxResults);

    public List<User> getAllUsersByRole(Role role, Integer offset,
                                        Integer maxResults);

    public Long getAllUsersByRoleTotalResulCount(Role role);

    public Long getAllUsersByRolePagesNumber(Role role, Integer maxResults);

    public User getByEmailAndPassword(String email, String password);

    public User getByEmail(String email);

    public List<User> getUsersAssignedToQuiz(Quiz quiz);

}
