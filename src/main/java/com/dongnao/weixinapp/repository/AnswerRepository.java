package com.dongnao.weixinapp.repository;

import com.dongnao.weixinapp.dataobject.AnwserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<AnwserInfo, String> {
}
