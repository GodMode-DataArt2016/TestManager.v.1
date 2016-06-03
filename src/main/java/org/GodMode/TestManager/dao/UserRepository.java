package org.GodMode.TestManager.dao;

import java.util.List;

import org.GodMode.TestManager.entity.Quiz;
import org.GodMode.TestManager.entity.Role;
import org.GodMode.TestManager.entity.User;

public interface UserRepository {

    public void save(User user);

    public void update(User user);

    public User findByid(Long id);

    public List<User> getAllUsers(Integer offset, Integer maxResults);

    public Long getAllUsersTotalResulCount();

    public List<User> getAllUsersByRole(Role role, Integer offset,
                                        Integer maxResults);

    public Long getAllUsersByRoleTotalResulCount(Role role);

    public User getByEmailAndPassword(String email, String password);

    public User getByEmail(String email);

    public List<User> getUsersAssignedToQuiz(Quiz quiz);
}
