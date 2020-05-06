package com.william.evrard.bestchoicebackend.utils;

import java.util.Collection;

public class Utils {

    public static boolean isNullOrEmpty(final Collection pCollection) {
        return (pCollection == null || pCollection.isEmpty());
    }

    public static int getSizeOrZero(final Collection pColl) {
        return pColl == null ? 0 : pColl.size();
    }
}
