package com.example.nihal.retro.pojo;

import com.google.gson.annotations.SerializedName;

public class DataClass {

    @SerializedName("title")
    String gameName;

    @SerializedName("id")
    String gameID;

    @SerializedName("image")
    String gamePoster;

    @SerializedName("game")
    String gameType;

    @SerializedName("date")
    String gameDate;

    @SerializedName("participants")
    String gameParticipants;

    @SerializedName("child")
    String gameRestriction;

    @SerializedName("fee")
    String gameFee;

    public DataClass(String gameFee) {
        this.gameFee = gameFee;
    }

    public String getGameFee() {
        return gameFee;
    }

    public DataClass(String gameName, String gameID, String gamePoster, String gameType, String gameDate, String gameParticipants, String gameRestriction) {
        this.gameName = gameName;
        this.gameID = gameID;
        this.gamePoster = gamePoster;
        this.gameType = gameType;
        this.gameDate = gameDate;
        this.gameParticipants = gameParticipants;
        this.gameRestriction = gameRestriction;
    }

    public String getGameName() {
        return gameName;
    }

    public String getGameID() {
        return gameID;
    }

    public String getGamePoster() {
        return gamePoster;
    }

    public String getGameType() {
        return gameType;
    }

    public String getGameDate() {
        return gameDate;
    }

    public String getGameParticipants() {
        return gameParticipants;
    }

    public String getGameRestriction() {
        return gameRestriction;
    }
}
