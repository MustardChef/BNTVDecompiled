package org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime;

import java.util.regex.Pattern;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.runtime.WildcardMatcher */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/runtime/WildcardMatcher.class */
public class WildcardMatcher {
    private final Pattern pattern;

    public WildcardMatcher(String expression) {
        String[] parts = expression.split("\\:");
        StringBuilder regex = new StringBuilder(expression.length() * 2);
        boolean next = false;
        for (String part : parts) {
            if (next) {
                regex.append('|');
            }
            regex.append('(').append(toRegex(part)).append(')');
            next = true;
        }
        this.pattern = Pattern.compile(regex.toString());
    }

    private static CharSequence toRegex(String expression) {
        StringBuilder regex = new StringBuilder(expression.length() * 2);
        char[] arr$ = expression.toCharArray();
        for (char c : arr$) {
            switch (c) {
                case '*':
                    regex.append(".*");
                    break;
                case '?':
                    regex.append(".?");
                    break;
                default:
                    regex.append(Pattern.quote(String.valueOf(c)));
                    break;
            }
        }
        return regex;
    }

    public boolean matches(String s) {
        return this.pattern.matcher(s).matches();
    }
}
