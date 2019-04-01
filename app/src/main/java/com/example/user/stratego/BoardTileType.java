package com.example.user.stratego;

import android.media.Image;

public enum BoardTileType {
    EMPTY(0,R.drawable.button1),
    FLAG(1,R.drawable.flag),
    SPY(2,R.drawable.spy),
    SCOUT(3,R.drawable.scout),
    BOMB_SQUAD(4,R.drawable.bombsquadpng),
    SERGEANT(5,R.drawable.sergant),
    LIEUTENANT(6,R.drawable.lieutenant),
    MAJOR(7,R.drawable.major),
    COLONEL(8,R.drawable.colonel),
    GENERAL(9,R.drawable.general),
    MARSHAL(10,R.drawable.marshal),
    BOMB(11,R.drawable.bomb);

    private int imageValue;
    private int image;
    private BoardTileType(int value, int drawable){
        this.imageValue = value;
        this.image = drawable;
    }
}
