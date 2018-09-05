package com.dongnao.weixinapp.repository;

import com.dongnao.weixinapp.dataobject.AnwserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerHistoryRepository extends JpaRepository<AnwserHistory, String> {
}
