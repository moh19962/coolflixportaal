package com.coolflix.notification.Repository;

import com.coolflix.notification.Domain.Model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
