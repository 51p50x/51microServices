package com.p50x.notificacion;

import com.p50x.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/sendNotification")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest){
        System.out.println(notificationRequest.toString() +" not request");
        notificationService.sendNotification(notificationRequest);
    }

}
