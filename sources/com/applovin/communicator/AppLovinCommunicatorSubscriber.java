package com.applovin.communicator;

/* loaded from: classes.dex */
public interface AppLovinCommunicatorSubscriber extends AppLovinCommunicatorEntity {
    void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage);
}
