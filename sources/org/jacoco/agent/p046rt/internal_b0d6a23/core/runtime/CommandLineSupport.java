package org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime;

import java.util.ArrayList;
import java.util.List;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.runtime.CommandLineSupport */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/runtime/CommandLineSupport.class */
final class CommandLineSupport {
    private static final char BLANK = ' ';
    private static final char QUOTE = '\"';
    private static final char SLASH = '\\';
    private static final int M_STRIPWHITESPACE = 0;
    private static final int M_PARSEARGUMENT = 1;
    private static final int M_ESCAPED = 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String quote(String arg) {
        StringBuilder escaped = new StringBuilder();
        char[] arr$ = arg.toCharArray();
        for (char c : arr$) {
            if (c == '\"' || c == '\\') {
                escaped.append('\\');
            }
            escaped.append(c);
        }
        if (arg.indexOf(32) != -1 || arg.indexOf(34) != -1) {
            escaped.insert(0, '\"').append('\"');
        }
        return escaped.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String quote(List<String> args) {
        StringBuilder result = new StringBuilder();
        boolean seperate = false;
        for (String arg : args) {
            if (seperate) {
                result.append(' ');
            }
            result.append(quote(arg));
            seperate = true;
        }
        return result.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> split(String commandline) {
        if (commandline == null || commandline.length() == 0) {
            return new ArrayList();
        }
        List<String> args = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        int mode = 0;
        int endChar = ' ';
        char[] arr$ = commandline.toCharArray();
        for (char c : arr$) {
            switch (mode) {
                case 0:
                    if (Character.isWhitespace(c)) {
                        break;
                    } else {
                        if (c == '\"') {
                            endChar = 34;
                        } else {
                            current.append(c);
                            endChar = 32;
                        }
                        mode = 1;
                        break;
                    }
                case 1:
                    if (c == endChar) {
                        addArgument(args, current);
                        mode = 0;
                        break;
                    } else if (c == '\\') {
                        current.append('\\');
                        mode = 2;
                        break;
                    } else {
                        current.append(c);
                        break;
                    }
                case 2:
                    if (c == '\"' || c == '\\') {
                        current.setCharAt(current.length() - 1, c);
                    } else if (c == endChar) {
                        addArgument(args, current);
                    } else {
                        current.append(c);
                    }
                    mode = 1;
                    break;
            }
        }
        addArgument(args, current);
        return args;
    }

    private static void addArgument(List<String> args, StringBuilder current) {
        if (current.length() > 0) {
            args.add(current.toString());
            current.setLength(0);
        }
    }

    private CommandLineSupport() {
    }
}
