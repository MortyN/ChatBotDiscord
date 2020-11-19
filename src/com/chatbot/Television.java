/*
 * Copyright 2015-2020 Austin Keener, Michael Ritter, Florian Spieß, and the JDA contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.chatbot;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.PermissionException;
import net.dv8tion.jda.api.exceptions.RateLimitedException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Television extends ListenerAdapter
{
    /**
     * This is the method where the program starts.
     */
    public static void main(String[] args)
    {
        //We construct a builder for a BOT account. If we wanted to use a CLIENT account
        // we would use AccountType.CLIENT
        try
        {
            JDA jda = JDABuilder.createDefault("Nzc4OTg5MDc4MTExNTg0Mjc5.X7aAHQ.koz75YR5m4gfuOgbipvgb3aiK20") // The token of the account that is logging in.
                    .addEventListeners(new PingCommand())   // An instance of a class that will handle events.
                    .addEventListeners(new botJoinChannel())   // An instance of a class that will handle events.
                    .build();
            jda.awaitReady(); // Blocking guarantees that JDA will be completely loaded.
            jda.getPresence().setActivity(Activity.watching("Håkons rumpehull"));
            System.out.println("Finished Building JDA!");
        }
        catch (LoginException e)
        {
            //If anything goes wrong in terms of authentication, this is the exception that will represent it
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            //Due to the fact that awaitReady is a blocking method, one which waits until JDA is fully loaded,
            // the waiting can be interrupted. This is the exception that would fire in that situation.
            //As a note: in this extremely simplified example this will never occur. In fact, this will never occur unless
            // you use awaitReady in a thread that has the possibility of being interrupted (async thread usage and interrupts)
            e.printStackTrace();
        }
    }
}



//package com.chatbot;
//
//import net.dv8tion.jda.api.AccountType;
//import net.dv8tion.jda.api.JDA;
//import net.dv8tion.jda.api.JDABuilder;
//import net.dv8tion.jda.api.OnlineStatus;
//import net.dv8tion.jda.api.entities.Activity;
//
//import com.chatbot.*;
//
//import javax.security.auth.login.LoginException;
//
//public class Television {
//    public static String prefix = "!";
//
//    public static void main(String[] args) throws LoginException {
//        JDA jda = JDABuilder.createDefault("Nzc4OTg5MDc4MTExNTg0Mjc5.X7aAHQ.koz75YR5m4gfuOgbipvgb3aiK20").build();
//        jda.getPresence().setStatus(OnlineStatus.ONLINE);
//        jda.getPresence().setActivity(Activity.watching("Håkons rumpehull"));
//        System.out.println("test");
//        jda.addEventListener(new messageEvent());
//    }
//}
