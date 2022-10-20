package ru.tiulnikow.springboot1.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.tiulnikow.springboot1.model.User;

public interface UserDao extends JpaRepository<User,Integer> {

}
