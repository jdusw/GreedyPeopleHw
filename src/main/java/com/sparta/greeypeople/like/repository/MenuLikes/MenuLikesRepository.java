package com.sparta.greeypeople.like.repository.MenuLikes;

import com.sparta.greeypeople.like.entity.MenuLikes;
import com.sparta.greeypeople.menu.entity.Menu;
import com.sparta.greeypeople.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuLikesRepository extends JpaRepository<MenuLikes, Long>, MenuLikesRepositoryQuery {
	Optional<MenuLikes> findByUserAndMenu(User foundUser, Menu foundMenu);
}