package com.example.basic.dao;

import com.example.basic.entity.Account;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import java.util.List;
import java.util.Optional;

@Dao
public interface AccountDAO {
    @Insert
    int insert(Account account);
    @Select
    List<Account> selectAll();
    @Update
    int update(Account account);
    @Select
    Optional<Account> selectById(int userId);

    @Select
    List<Account> search(String username);
}
