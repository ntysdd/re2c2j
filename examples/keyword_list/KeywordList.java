package keyword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static keyword.KeywordList.Token.*;

public class KeywordList {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
            parseLine(line);
        }
    }

    static void parseLine(String line) {
        INPUT_BUF = (line + "\0").toCharArray();
        YYCURSOR = 0;
        YYLIMIT = INPUT_BUF.length - 1;

        Token token;
        while (true) {
            token = nextToken();
            System.out.println(token);
            if (token == EOF) {
                break;
            }
        }
    }

    static char[] INPUT_BUF;
    static int YYCURSOR;
    static int YYLIMIT;

    static Token nextToken() {
        {
            char yych = 0;
            int SWITCH_STATE = 0;
            while (true) {
                switch (SWITCH_STATE) {
                    case 0:
                        yych = INPUT_BUF[YYCURSOR];
                        if (yych <= 'i') {
                            if (yych <= 'a') {
                                if (yych <= '\t') {
                                    if (yych <= 0x0000) {
                                        if (YYLIMIT <= YYCURSOR) {
                                            {
                                                SWITCH_STATE = 291;
                                                continue;
                                            }
                                        }
                                        {
                                            SWITCH_STATE = 1;
                                            continue;
                                        }
                                    }
                                    if (yych >= '\t') {
                                        SWITCH_STATE = 3;
                                        continue;
                                    }
                                } else {
                                    if (yych == ' ') {
                                        SWITCH_STATE = 3;
                                        continue;
                                    }
                                    if (yych >= 'a') {
                                        SWITCH_STATE = 5;
                                        continue;
                                    }
                                }
                            } else {
                                if (yych <= 'e') {
                                    if (yych <= 'b') {
                                        SWITCH_STATE = 7;
                                        continue;
                                    }
                                    if (yych <= 'c') {
                                        SWITCH_STATE = 8;
                                        continue;
                                    }
                                    if (yych <= 'd') {
                                        SWITCH_STATE = 9;
                                        continue;
                                    }
                                    {
                                        SWITCH_STATE = 10;
                                        continue;
                                    }
                                } else {
                                    if (yych <= 'f') {
                                        SWITCH_STATE = 11;
                                        continue;
                                    }
                                    if (yych <= 'g') {
                                        SWITCH_STATE = 12;
                                        continue;
                                    }
                                    if (yych <= 'h') {
                                        SWITCH_STATE = 13;
                                        continue;
                                    }
                                    {
                                        SWITCH_STATE = 15;
                                        continue;
                                    }
                                }
                            }
                        } else {
                            if (yych <= 'q') {
                                if (yych <= 'm') {
                                    if (yych == 'l') {
                                        SWITCH_STATE = 16;
                                        continue;
                                    }
                                    {
                                        SWITCH_STATE = 13;
                                        continue;
                                    }
                                } else {
                                    if (yych <= 'n') {
                                        SWITCH_STATE = 17;
                                        continue;
                                    }
                                    if (yych == 'p') {
                                        SWITCH_STATE = 18;
                                        continue;
                                    }
                                    {
                                        SWITCH_STATE = 13;
                                        continue;
                                    }
                                }
                            } else {
                                if (yych <= 'u') {
                                    if (yych <= 'r') {
                                        SWITCH_STATE = 19;
                                        continue;
                                    }
                                    if (yych <= 's') {
                                        SWITCH_STATE = 20;
                                        continue;
                                    }
                                    if (yych <= 't') {
                                        SWITCH_STATE = 21;
                                        continue;
                                    }
                                    {
                                        SWITCH_STATE = 13;
                                        continue;
                                    }
                                } else {
                                    if (yych <= 'v') {
                                        SWITCH_STATE = 22;
                                        continue;
                                    }
                                    if (yych <= 'w') {
                                        SWITCH_STATE = 23;
                                        continue;
                                    }
                                    if (yych <= 'z') {
                                        SWITCH_STATE = 13;
                                        continue;
                                    }
                                }
                            }
                        }
                    case 1:
                        ++YYCURSOR;
                    case 2: {
                        return ERROR;
                    }
                    case 3:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= '\t') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 4;
                                    continue;
                                }
                            }
                            if (yych >= '\t') {
                                SWITCH_STATE = 3;
                                continue;
                            }
                        } else {
                            if (yych == ' ') {
                                SWITCH_STATE = 3;
                                continue;
                            }
                        }
                    case 4: {
                        return WHITE_SPACE;
                    }
                    case 5:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 'b') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 6;
                                    continue;
                                }
                            }
                            if (yych <= 'a') {
                                SWITCH_STATE = 14;
                                continue;
                            }
                            {
                                SWITCH_STATE = 24;
                                continue;
                            }
                        } else {
                            if (yych == 's') {
                                SWITCH_STATE = 25;
                                continue;
                            }
                            {
                                SWITCH_STATE = 14;
                                continue;
                            }
                        }
                    case 6: {
                        return IDENT;
                    }
                    case 7:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 'q') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 6;
                                    continue;
                                }
                            }
                            if (yych == 'o') {
                                SWITCH_STATE = 26;
                                continue;
                            }
                            {
                                SWITCH_STATE = 14;
                                continue;
                            }
                        } else {
                            if (yych <= 'r') {
                                SWITCH_STATE = 27;
                                continue;
                            }
                            if (yych == 'y') {
                                SWITCH_STATE = 28;
                                continue;
                            }
                            {
                                SWITCH_STATE = 14;
                                continue;
                            }
                        }
                    case 8:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 'h') {
                            if (yych <= '`') {
                                if (yych <= 0x0000) {
                                    if (YYLIMIT <= YYCURSOR) {
                                    }
                                    {
                                        SWITCH_STATE = 6;
                                        continue;
                                    }
                                }
                                {
                                    SWITCH_STATE = 14;
                                    continue;
                                }
                            } else {
                                if (yych <= 'a') {
                                    SWITCH_STATE = 29;
                                    continue;
                                }
                                if (yych <= 'g') {
                                    SWITCH_STATE = 14;
                                    continue;
                                }
                                {
                                    SWITCH_STATE = 30;
                                    continue;
                                }
                            }
                        } else {
                            if (yych <= 'l') {
                                if (yych <= 'k') {
                                    SWITCH_STATE = 14;
                                    continue;
                                }
                                {
                                    SWITCH_STATE = 31;
                                    continue;
                                }
                            } else {
                                if (yych == 'o') {
                                    SWITCH_STATE = 32;
                                    continue;
                                }
                                {
                                    SWITCH_STATE = 14;
                                    continue;
                                }
                            }
                        }
                    case 9:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 'e') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 6;
                                    continue;
                                }
                            }
                            if (yych <= 'd') {
                                SWITCH_STATE = 14;
                                continue;
                            }
                            {
                                SWITCH_STATE = 33;
                                continue;
                            }
                        } else {
                            if (yych == 'o') {
                                SWITCH_STATE = 34;
                                continue;
                            }
                            {
                                SWITCH_STATE = 14;
                                continue;
                            }
                        }
                    case 10:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 'm') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 6;
                                    continue;
                                }
                            }
                            if (yych == 'l') {
                                SWITCH_STATE = 36;
                                continue;
                            }
                            {
                                SWITCH_STATE = 14;
                                continue;
                            }
                        } else {
                            if (yych <= 'n') {
                                SWITCH_STATE = 37;
                                continue;
                            }
                            if (yych == 'x') {
                                SWITCH_STATE = 38;
                                continue;
                            }
                            {
                                SWITCH_STATE = 14;
                                continue;
                            }
                        }
                    case 11:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 'k') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 6;
                                    continue;
                                }
                            }
                            if (yych == 'i') {
                                SWITCH_STATE = 39;
                                continue;
                            }
                            {
                                SWITCH_STATE = 14;
                                continue;
                            }
                        } else {
                            if (yych <= 'l') {
                                SWITCH_STATE = 40;
                                continue;
                            }
                            if (yych == 'o') {
                                SWITCH_STATE = 41;
                                continue;
                            }
                            {
                                SWITCH_STATE = 14;
                                continue;
                            }
                        }
                    case 12:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'o') {
                            SWITCH_STATE = 42;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 13:
                        yych = INPUT_BUF[++YYCURSOR];
                    case 14:
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 6;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    {
                        SWITCH_STATE = 6;
                        continue;
                    }
                    case 15:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 'f') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 6;
                                    continue;
                                }
                            }
                            if (yych <= 'e') {
                                SWITCH_STATE = 14;
                                continue;
                            }
                            {
                                SWITCH_STATE = 43;
                                continue;
                            }
                        } else {
                            if (yych <= 'l') {
                                SWITCH_STATE = 14;
                                continue;
                            }
                            if (yych <= 'm') {
                                SWITCH_STATE = 45;
                                continue;
                            }
                            if (yych <= 'n') {
                                SWITCH_STATE = 46;
                                continue;
                            }
                            {
                                SWITCH_STATE = 14;
                                continue;
                            }
                        }
                    case 16:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'o') {
                            SWITCH_STATE = 47;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 17:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 'a') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 6;
                                    continue;
                                }
                            }
                            if (yych <= '`') {
                                SWITCH_STATE = 14;
                                continue;
                            }
                            {
                                SWITCH_STATE = 48;
                                continue;
                            }
                        } else {
                            if (yych == 'e') {
                                SWITCH_STATE = 49;
                                continue;
                            }
                            {
                                SWITCH_STATE = 14;
                                continue;
                            }
                        }
                    case 18:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 'q') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 6;
                                    continue;
                                }
                            }
                            if (yych == 'a') {
                                SWITCH_STATE = 50;
                                continue;
                            }
                            {
                                SWITCH_STATE = 14;
                                continue;
                            }
                        } else {
                            if (yych <= 'r') {
                                SWITCH_STATE = 51;
                                continue;
                            }
                            if (yych == 'u') {
                                SWITCH_STATE = 52;
                                continue;
                            }
                            {
                                SWITCH_STATE = 14;
                                continue;
                            }
                        }
                    case 19:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 53;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 20:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 't') {
                            if (yych <= 'g') {
                                if (yych <= 0x0000) {
                                    if (YYLIMIT <= YYCURSOR) {
                                    }
                                    {
                                        SWITCH_STATE = 6;
                                        continue;
                                    }
                                }
                                {
                                    SWITCH_STATE = 14;
                                    continue;
                                }
                            } else {
                                if (yych <= 'h') {
                                    SWITCH_STATE = 54;
                                    continue;
                                }
                                if (yych <= 's') {
                                    SWITCH_STATE = 14;
                                    continue;
                                }
                                {
                                    SWITCH_STATE = 55;
                                    continue;
                                }
                            }
                        } else {
                            if (yych <= 'w') {
                                if (yych <= 'u') {
                                    SWITCH_STATE = 56;
                                    continue;
                                }
                                if (yych <= 'v') {
                                    SWITCH_STATE = 14;
                                    continue;
                                }
                                {
                                    SWITCH_STATE = 57;
                                    continue;
                                }
                            } else {
                                if (yych == 'y') {
                                    SWITCH_STATE = 58;
                                    continue;
                                }
                                {
                                    SWITCH_STATE = 14;
                                    continue;
                                }
                            }
                        }
                    case 21:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 'h') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 6;
                                    continue;
                                }
                            }
                            if (yych <= 'g') {
                                SWITCH_STATE = 14;
                                continue;
                            }
                            {
                                SWITCH_STATE = 59;
                                continue;
                            }
                        } else {
                            if (yych == 'r') {
                                SWITCH_STATE = 60;
                                continue;
                            }
                            {
                                SWITCH_STATE = 14;
                                continue;
                            }
                        }
                    case 22:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'o') {
                            SWITCH_STATE = 61;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 23:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'h') {
                            SWITCH_STATE = 62;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 24:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 's') {
                            SWITCH_STATE = 63;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 25:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 's') {
                            SWITCH_STATE = 64;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 26:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'o') {
                            SWITCH_STATE = 65;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 27:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 66;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 28:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 67;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 29:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych <= 'r') {
                            SWITCH_STATE = 14;
                            continue;
                        }
                        if (yych <= 's') {
                            SWITCH_STATE = 68;
                            continue;
                        }
                        if (yych <= 't') {
                            SWITCH_STATE = 69;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 30:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'a') {
                            SWITCH_STATE = 70;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 31:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'a') {
                            SWITCH_STATE = 71;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 32:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'n') {
                            SWITCH_STATE = 72;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 33:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'f') {
                            SWITCH_STATE = 73;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 34:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 't') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 35;
                                    continue;
                                }
                            }
                            if (yych >= 'a') {
                                SWITCH_STATE = 13;
                                continue;
                            }
                        } else {
                            if (yych <= 'u') {
                                SWITCH_STATE = 74;
                                continue;
                            }
                            if (yych <= 'z') {
                                SWITCH_STATE = 13;
                                continue;
                            }
                        }
                    case 35: {
                        return KW_do;
                    }
                    case 36:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 's') {
                            SWITCH_STATE = 75;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 37:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'u') {
                            SWITCH_STATE = 76;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 38:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 77;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 39:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'n') {
                            SWITCH_STATE = 78;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 40:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'o') {
                            SWITCH_STATE = 79;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 41:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'r') {
                            SWITCH_STATE = 80;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 42:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 82;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 43:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 44;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 44;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 44: {
                        return KW_if;
                    }
                    case 45:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'p') {
                            SWITCH_STATE = 83;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 46:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych <= 'r') {
                            SWITCH_STATE = 14;
                            continue;
                        }
                        if (yych <= 's') {
                            SWITCH_STATE = 84;
                            continue;
                        }
                        if (yych <= 't') {
                            SWITCH_STATE = 85;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 47:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'n') {
                            SWITCH_STATE = 87;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 48:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 88;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 49:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'w') {
                            SWITCH_STATE = 89;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 50:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'c') {
                            SWITCH_STATE = 91;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 51:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 'i') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 6;
                                    continue;
                                }
                            }
                            if (yych <= 'h') {
                                SWITCH_STATE = 14;
                                continue;
                            }
                            {
                                SWITCH_STATE = 92;
                                continue;
                            }
                        } else {
                            if (yych == 'o') {
                                SWITCH_STATE = 93;
                                continue;
                            }
                            {
                                SWITCH_STATE = 14;
                                continue;
                            }
                        }
                    case 52:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'b') {
                            SWITCH_STATE = 94;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 53:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 95;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 54:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'o') {
                            SWITCH_STATE = 96;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 55:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 'a') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 6;
                                    continue;
                                }
                            }
                            if (yych <= '`') {
                                SWITCH_STATE = 14;
                                continue;
                            }
                            {
                                SWITCH_STATE = 97;
                                continue;
                            }
                        } else {
                            if (yych == 'r') {
                                SWITCH_STATE = 98;
                                continue;
                            }
                            {
                                SWITCH_STATE = 14;
                                continue;
                            }
                        }
                    case 56:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'p') {
                            SWITCH_STATE = 99;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 57:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'i') {
                            SWITCH_STATE = 100;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 58:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'n') {
                            SWITCH_STATE = 101;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 59:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 'i') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 6;
                                    continue;
                                }
                            }
                            if (yych <= 'h') {
                                SWITCH_STATE = 14;
                                continue;
                            }
                            {
                                SWITCH_STATE = 102;
                                continue;
                            }
                        } else {
                            if (yych == 'r') {
                                SWITCH_STATE = 103;
                                continue;
                            }
                            {
                                SWITCH_STATE = 14;
                                continue;
                            }
                        }
                    case 60:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 'a') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 6;
                                    continue;
                                }
                            }
                            if (yych <= '`') {
                                SWITCH_STATE = 14;
                                continue;
                            }
                            {
                                SWITCH_STATE = 104;
                                continue;
                            }
                        } else {
                            if (yych == 'y') {
                                SWITCH_STATE = 105;
                                continue;
                            }
                            {
                                SWITCH_STATE = 14;
                                continue;
                            }
                        }
                    case 61:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 'i') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 6;
                                    continue;
                                }
                            }
                            if (yych <= 'h') {
                                SWITCH_STATE = 14;
                                continue;
                            }
                            {
                                SWITCH_STATE = 107;
                                continue;
                            }
                        } else {
                            if (yych == 'l') {
                                SWITCH_STATE = 108;
                                continue;
                            }
                            {
                                SWITCH_STATE = 14;
                                continue;
                            }
                        }
                    case 62:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'i') {
                            SWITCH_STATE = 109;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 63:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 110;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 64:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 111;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 65:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'l') {
                            SWITCH_STATE = 112;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 66:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'a') {
                            SWITCH_STATE = 113;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 67:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 114;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 68:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 116;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 69:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'c') {
                            SWITCH_STATE = 118;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 70:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'r') {
                            SWITCH_STATE = 119;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 71:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 's') {
                            SWITCH_STATE = 121;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 72:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych <= 'r') {
                            SWITCH_STATE = 14;
                            continue;
                        }
                        if (yych <= 's') {
                            SWITCH_STATE = 122;
                            continue;
                        }
                        if (yych <= 't') {
                            SWITCH_STATE = 123;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 73:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'a') {
                            SWITCH_STATE = 124;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 74:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'b') {
                            SWITCH_STATE = 125;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 75:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 126;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 76:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'm') {
                            SWITCH_STATE = 128;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 77:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 130;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 78:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'a') {
                            SWITCH_STATE = 131;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 79:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'a') {
                            SWITCH_STATE = 132;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 80:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 81;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 81;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 81: {
                        return KW_for;
                    }
                    case 82:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'o') {
                            SWITCH_STATE = 133;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 83:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 'l') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 6;
                                    continue;
                                }
                            }
                            if (yych <= 'k') {
                                SWITCH_STATE = 14;
                                continue;
                            }
                            {
                                SWITCH_STATE = 135;
                                continue;
                            }
                        } else {
                            if (yych == 'o') {
                                SWITCH_STATE = 136;
                                continue;
                            }
                            {
                                SWITCH_STATE = 14;
                                continue;
                            }
                        }
                    case 84:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 137;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 85:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 'd') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 86;
                                    continue;
                                }
                            }
                            if (yych >= 'a') {
                                SWITCH_STATE = 13;
                                continue;
                            }
                        } else {
                            if (yych <= 'e') {
                                SWITCH_STATE = 138;
                                continue;
                            }
                            if (yych <= 'z') {
                                SWITCH_STATE = 13;
                                continue;
                            }
                        }
                    case 86: {
                        return KW_int;
                    }
                    case 87:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'g') {
                            SWITCH_STATE = 139;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 88:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'i') {
                            SWITCH_STATE = 141;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 89:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 90;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 90;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 90: {
                        return KW_new;
                    }
                    case 91:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'k') {
                            SWITCH_STATE = 142;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 92:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'v') {
                            SWITCH_STATE = 143;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 93:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 144;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 94:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'l') {
                            SWITCH_STATE = 145;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 95:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'u') {
                            SWITCH_STATE = 146;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 96:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'r') {
                            SWITCH_STATE = 147;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 97:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 148;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 98:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'i') {
                            SWITCH_STATE = 149;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 99:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 150;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 100:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 151;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 101:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'c') {
                            SWITCH_STATE = 152;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 102:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 's') {
                            SWITCH_STATE = 153;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 103:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'o') {
                            SWITCH_STATE = 155;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 104:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'n') {
                            SWITCH_STATE = 156;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 105:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 106;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 106;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 106: {
                        return KW_try;
                    }
                    case 107:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'd') {
                            SWITCH_STATE = 157;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 108:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'a') {
                            SWITCH_STATE = 159;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 109:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'l') {
                            SWITCH_STATE = 160;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 110:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'r') {
                            SWITCH_STATE = 161;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 111:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'r') {
                            SWITCH_STATE = 162;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 112:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 163;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 113:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'k') {
                            SWITCH_STATE = 164;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 114:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 115;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 115;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 115: {
                        return KW_byte;
                    }
                    case 116:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 117;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 117;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 117: {
                        return KW_case;
                    }
                    case 118:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'h') {
                            SWITCH_STATE = 166;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 119:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 120;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 120;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 120: {
                        return KW_char;
                    }
                    case 121:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 's') {
                            SWITCH_STATE = 168;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 122:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 170;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 123:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'i') {
                            SWITCH_STATE = 172;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 124:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'u') {
                            SWITCH_STATE = 173;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 125:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'l') {
                            SWITCH_STATE = 174;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 126:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 127;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 127;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 127: {
                        return KW_else;
                    }
                    case 128:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 129;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 129;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 129: {
                        return KW_enum;
                    }
                    case 130:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'n') {
                            SWITCH_STATE = 175;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 131:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'l') {
                            SWITCH_STATE = 176;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 132:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 178;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 133:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 134;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 134;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 134: {
                        return KW_goto;
                    }
                    case 135:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 180;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 136:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'r') {
                            SWITCH_STATE = 181;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 137:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'a') {
                            SWITCH_STATE = 182;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 138:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'r') {
                            SWITCH_STATE = 183;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 139:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 140;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 140;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 140: {
                        return KW_long;
                    }
                    case 141:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'v') {
                            SWITCH_STATE = 184;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 142:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'a') {
                            SWITCH_STATE = 185;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 143:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'a') {
                            SWITCH_STATE = 186;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 144:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 187;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 145:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'i') {
                            SWITCH_STATE = 188;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 146:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'r') {
                            SWITCH_STATE = 189;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 147:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 190;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 148:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'i') {
                            SWITCH_STATE = 192;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 149:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'c') {
                            SWITCH_STATE = 193;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 150:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'r') {
                            SWITCH_STATE = 194;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 151:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'c') {
                            SWITCH_STATE = 196;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 152:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'h') {
                            SWITCH_STATE = 197;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 153:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 154;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 154;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 154: {
                        return KW_this;
                    }
                    case 155:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'w') {
                            SWITCH_STATE = 198;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 156:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 's') {
                            SWITCH_STATE = 200;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 157:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 158;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 158;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 158: {
                        return KW_void;
                    }
                    case 159:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 201;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 160:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 202;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 161:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'a') {
                            SWITCH_STATE = 204;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 162:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 205;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 163:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'a') {
                            SWITCH_STATE = 207;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 164:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 165;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 165;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 165: {
                        return KW_break;
                    }
                    case 166:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 167;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 167;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 167: {
                        return KW_catch;
                    }
                    case 168:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 169;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 169;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 169: {
                        return KW_class;
                    }
                    case 170:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 171;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 171;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 171: {
                        return KW_const;
                    }
                    case 172:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'n') {
                            SWITCH_STATE = 208;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 173:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'l') {
                            SWITCH_STATE = 209;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 174:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 210;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 175:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'd') {
                            SWITCH_STATE = 212;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 176:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 'k') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 177;
                                    continue;
                                }
                            }
                            if (yych >= 'a') {
                                SWITCH_STATE = 13;
                                continue;
                            }
                        } else {
                            if (yych <= 'l') {
                                SWITCH_STATE = 213;
                                continue;
                            }
                            if (yych <= 'z') {
                                SWITCH_STATE = 13;
                                continue;
                            }
                        }
                    case 177: {
                        return KW_final;
                    }
                    case 178:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 179;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 179;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 179: {
                        return KW_float;
                    }
                    case 180:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'm') {
                            SWITCH_STATE = 214;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 181:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 215;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 182:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'n') {
                            SWITCH_STATE = 217;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 183:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'f') {
                            SWITCH_STATE = 218;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 184:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 219;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 185:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'g') {
                            SWITCH_STATE = 221;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 186:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 222;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 187:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'c') {
                            SWITCH_STATE = 223;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 188:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'c') {
                            SWITCH_STATE = 224;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 189:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'n') {
                            SWITCH_STATE = 226;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 190:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 191;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 191;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 191: {
                        return KW_short;
                    }
                    case 192:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'c') {
                            SWITCH_STATE = 228;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 193:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 230;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 194:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 195;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 195;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 195: {
                        return KW_super;
                    }
                    case 196:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'h') {
                            SWITCH_STATE = 231;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 197:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'r') {
                            SWITCH_STATE = 233;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 198:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 'r') {
                            if (yych <= 0x0000) {
                                if (YYLIMIT <= YYCURSOR) {
                                }
                                {
                                    SWITCH_STATE = 199;
                                    continue;
                                }
                            }
                            if (yych >= 'a') {
                                SWITCH_STATE = 13;
                                continue;
                            }
                        } else {
                            if (yych <= 's') {
                                SWITCH_STATE = 234;
                                continue;
                            }
                            if (yych <= 'z') {
                                SWITCH_STATE = 13;
                                continue;
                            }
                        }
                    case 199: {
                        return KW_throw;
                    }
                    case 200:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'i') {
                            SWITCH_STATE = 236;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 201:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'i') {
                            SWITCH_STATE = 237;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 202:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 203;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 203;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 203: {
                        return KW_while;
                    }
                    case 204:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'c') {
                            SWITCH_STATE = 238;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 205:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 206;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 206;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 206: {
                        return KW_assert;
                    }
                    case 207:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'n') {
                            SWITCH_STATE = 239;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 208:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'u') {
                            SWITCH_STATE = 241;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 209:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 242;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 210:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 211;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 211;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 211: {
                        return KW_double;
                    }
                    case 212:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 's') {
                            SWITCH_STATE = 244;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 213:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'y') {
                            SWITCH_STATE = 246;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 214:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 248;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 215:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 216;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 216;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 216: {
                        return KW_import;
                    }
                    case 217:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'c') {
                            SWITCH_STATE = 249;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 218:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'a') {
                            SWITCH_STATE = 250;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 219:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 220;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 220;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 220: {
                        return KW_native;
                    }
                    case 221:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 251;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 222:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 253;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 223:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 255;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 224:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 225;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 225;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 225: {
                        return KW_public;
                    }
                    case 226:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 227;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 227;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 227: {
                        return KW_return;
                    }
                    case 228:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 229;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 229;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 229: {
                        return KW_static;
                    }
                    case 230:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'f') {
                            SWITCH_STATE = 256;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 231:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 232;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 232;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 232: {
                        return KW_switch;
                    }
                    case 233:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'o') {
                            SWITCH_STATE = 257;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 234:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 235;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 235;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 235: {
                        return KW_throws;
                    }
                    case 236:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 258;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 237:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'l') {
                            SWITCH_STATE = 259;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 238:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 260;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 239:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 240;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 240;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 240: {
                        return KW_boolean;
                    }
                    case 241:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 262;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 242:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 243;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 243;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 243: {
                        return KW_default;
                    }
                    case 244:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 245;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 245;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 245: {
                        return KW_extends;
                    }
                    case 246:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 247;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 247;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 247: {
                        return KW_finally;
                    }
                    case 248:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'n') {
                            SWITCH_STATE = 264;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 249:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 265;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 250:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'c') {
                            SWITCH_STATE = 266;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 251:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 252;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 252;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 252: {
                        return KW_package;
                    }
                    case 253:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 254;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 254;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 254: {
                        return KW_private;
                    }
                    case 255:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 267;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 256:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'p') {
                            SWITCH_STATE = 268;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 257:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'n') {
                            SWITCH_STATE = 270;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 258:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'n') {
                            SWITCH_STATE = 271;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 259:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 272;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 260:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 261;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 261;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 261: {
                        return KW_abstract;
                    }
                    case 262:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 263;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 263;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 263: {
                        return KW_continue;
                    }
                    case 264:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 274;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 265:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'o') {
                            SWITCH_STATE = 275;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 266:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'e') {
                            SWITCH_STATE = 276;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 267:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'd') {
                            SWITCH_STATE = 278;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 268:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 269;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 269;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 269: {
                        return KW_strictfp;
                    }
                    case 270:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'i') {
                            SWITCH_STATE = 280;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 271:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 't') {
                            SWITCH_STATE = 281;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 272:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 273;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 273;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 273: {
                        return KW_volatile;
                    }
                    case 274:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 's') {
                            SWITCH_STATE = 283;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 275:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'f') {
                            SWITCH_STATE = 285;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 276:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 277;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 277;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 277: {
                        return KW_interface;
                    }
                    case 278:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 279;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 279;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 279: {
                        return KW_protected;
                    }
                    case 280:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych == 'z') {
                            SWITCH_STATE = 287;
                            continue;
                        }
                    {
                        SWITCH_STATE = 14;
                        continue;
                    }
                    case 281:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 282;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 282;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 282: {
                        return KW_transient;
                    }
                    case 283:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 284;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 284;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 284: {
                        return KW_implements;
                    }
                    case 285:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 286;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 286;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 286: {
                        return KW_instanceof;
                    }
                    case 287:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych != 'e') {
                            SWITCH_STATE = 14;
                            continue;
                        }
                    case 288:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 6;
                                continue;
                            }
                        }
                        if (yych != 'd') {
                            SWITCH_STATE = 14;
                            continue;
                        }
                    case 289:
                        yych = INPUT_BUF[++YYCURSOR];
                        if (yych <= 0x0000) {
                            if (YYLIMIT <= YYCURSOR) {
                            }
                            {
                                SWITCH_STATE = 290;
                                continue;
                            }
                        }
                        if (yych <= '`') {
                            SWITCH_STATE = 290;
                            continue;
                        }
                        if (yych <= 'z') {
                            SWITCH_STATE = 13;
                            continue;
                        }
                    case 290: {
                        return KW_synchronized;
                    }
                    case 291: {
                        return EOF;
                    }
                }

            }
        }
    }

    enum Token {
        EOF,
        ERROR,
        IDENT,
        WHITE_SPACE,
        KW_abstract,
        KW_assert,
        KW_boolean,
        KW_break,
        KW_byte,
        KW_case,
        KW_catch,
        KW_char,
        KW_class,
        KW_const,
        KW_continue,
        KW_default,
        KW_do,
        KW_double,
        KW_else,
        KW_enum,
        KW_extends,
        KW_final,
        KW_finally,
        KW_float,
        KW_for,
        KW_goto,
        KW_if,
        KW_implements,
        KW_import,
        KW_instanceof,
        KW_int,
        KW_interface,
        KW_long,
        KW_native,
        KW_new,
        KW_package,
        KW_private,
        KW_protected,
        KW_public,
        KW_return,
        KW_short,
        KW_static,
        KW_strictfp,
        KW_super,
        KW_switch,
        KW_synchronized,
        KW_this,
        KW_throw,
        KW_throws,
        KW_transient,
        KW_try,
        KW_void,
        KW_volatile,
        KW_while,
    }
}
