package com.org;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.ServiceBusTopicTrigger;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Function {

    @FunctionName("quarkus-data-sync-demo")
    public String run(
        @ServiceBusTopicTrigger(name = "message",
            topicName = "%TOPIC_NAME%",
            subscriptionName = "%SUBSCRIPTION_NAME%",
            connection = "ServiceBusConnectionString")
        String message,
        final ExecutionContext context) {
        Log.info("message=" + message);
        return message;
    }
}