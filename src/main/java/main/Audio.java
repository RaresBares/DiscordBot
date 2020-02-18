package main;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.audio.AudioReceiveHandler;
import net.dv8tion.jda.api.audio.CombinedAudio;
import net.dv8tion.jda.api.audio.OpusPacket;
import net.dv8tion.jda.api.audio.UserAudio;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;

import javax.annotation.Nonnull;

public class Audio extends Thread {
    PrivateChannel pc;

    @Override
    public void run() {
        for(int i = 0; i< 30; i++) {
            pc.sendMessage("Adde mich auf DC Rares#0911 :D").queue();
            try {
                sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }

}
