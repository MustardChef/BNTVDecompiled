package org.jsoup.select;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.internal.StringUtil;
import org.jsoup.parser.TokenQueue;
import org.jsoup.select.CombiningEvaluator;
import org.jsoup.select.Evaluator;
import org.jsoup.select.Selector;
import org.jsoup.select.StructuralEvaluator;

/* loaded from: classes5.dex */
public class QueryParser {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final List<Evaluator> evals = new ArrayList();
    private final String query;

    /* renamed from: tq */
    private final TokenQueue f10715tq;
    private static final String[] combinators = {",", ">", "+", "~", " "};
    private static final String[] AttributeEvals = {"=", "!=", "^=", "$=", "*=", "~="};
    private static final Pattern NTH_AB = Pattern.compile("(([+-])?(\\d+)?)n(\\s*([+-])?\\s*\\d+)?", 2);
    private static final Pattern NTH_B = Pattern.compile("([+-])?(\\d+)");

    private QueryParser(String str) {
        Validate.notEmpty(str);
        String trim = str.trim();
        this.query = trim;
        this.f10715tq = new TokenQueue(trim);
    }

    public static Evaluator parse(String str) {
        try {
            return new QueryParser(str).parse();
        } catch (IllegalArgumentException e) {
            throw new Selector.SelectorParseException(e.getMessage(), new Object[0]);
        }
    }

    Evaluator parse() {
        this.f10715tq.consumeWhitespace();
        if (this.f10715tq.matchesAny(combinators)) {
            this.evals.add(new StructuralEvaluator.Root());
            combinator(this.f10715tq.consume());
        } else {
            findElements();
        }
        while (!this.f10715tq.isEmpty()) {
            boolean consumeWhitespace = this.f10715tq.consumeWhitespace();
            if (this.f10715tq.matchesAny(combinators)) {
                combinator(this.f10715tq.consume());
            } else if (consumeWhitespace) {
                combinator(' ');
            } else {
                findElements();
            }
        }
        if (this.evals.size() == 1) {
            return this.evals.get(0);
        }
        return new CombiningEvaluator.And(this.evals);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void combinator(char r11) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.select.QueryParser.combinator(char):void");
    }

    private String consumeSubQuery() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        while (!this.f10715tq.isEmpty()) {
            if (this.f10715tq.matches("(")) {
                borrowBuilder.append("(");
                borrowBuilder.append(this.f10715tq.chompBalanced('(', ')'));
                borrowBuilder.append(")");
            } else if (this.f10715tq.matches("[")) {
                borrowBuilder.append("[");
                borrowBuilder.append(this.f10715tq.chompBalanced('[', ']'));
                borrowBuilder.append("]");
            } else if (this.f10715tq.matchesAny(combinators)) {
                if (borrowBuilder.length() > 0) {
                    break;
                }
                this.f10715tq.consume();
            } else {
                borrowBuilder.append(this.f10715tq.consume());
            }
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    private void findElements() {
        if (this.f10715tq.matchChomp("#")) {
            byId();
        } else if (this.f10715tq.matchChomp(".")) {
            byClass();
        } else if (this.f10715tq.matchesWord() || this.f10715tq.matches("*|")) {
            byTag();
        } else if (this.f10715tq.matches("[")) {
            byAttribute();
        } else if (this.f10715tq.matchChomp("*")) {
            allElements();
        } else if (this.f10715tq.matchChomp(":lt(")) {
            indexLessThan();
        } else if (this.f10715tq.matchChomp(":gt(")) {
            indexGreaterThan();
        } else if (this.f10715tq.matchChomp(":eq(")) {
            indexEquals();
        } else if (this.f10715tq.matches(":has(")) {
            has();
        } else if (this.f10715tq.matches(":contains(")) {
            contains(false);
        } else if (this.f10715tq.matches(":containsOwn(")) {
            contains(true);
        } else if (this.f10715tq.matches(":containsData(")) {
            containsData();
        } else if (this.f10715tq.matches(":matches(")) {
            matches(false);
        } else if (this.f10715tq.matches(":matchesOwn(")) {
            matches(true);
        } else if (this.f10715tq.matches(":not(")) {
            not();
        } else if (this.f10715tq.matchChomp(":nth-child(")) {
            cssNthChild(false, false);
        } else if (this.f10715tq.matchChomp(":nth-last-child(")) {
            cssNthChild(true, false);
        } else if (this.f10715tq.matchChomp(":nth-of-type(")) {
            cssNthChild(false, true);
        } else if (this.f10715tq.matchChomp(":nth-last-of-type(")) {
            cssNthChild(true, true);
        } else if (this.f10715tq.matchChomp(":first-child")) {
            this.evals.add(new Evaluator.IsFirstChild());
        } else if (this.f10715tq.matchChomp(":last-child")) {
            this.evals.add(new Evaluator.IsLastChild());
        } else if (this.f10715tq.matchChomp(":first-of-type")) {
            this.evals.add(new Evaluator.IsFirstOfType());
        } else if (this.f10715tq.matchChomp(":last-of-type")) {
            this.evals.add(new Evaluator.IsLastOfType());
        } else if (this.f10715tq.matchChomp(":only-child")) {
            this.evals.add(new Evaluator.IsOnlyChild());
        } else if (this.f10715tq.matchChomp(":only-of-type")) {
            this.evals.add(new Evaluator.IsOnlyOfType());
        } else if (this.f10715tq.matchChomp(":empty")) {
            this.evals.add(new Evaluator.IsEmpty());
        } else if (this.f10715tq.matchChomp(":root")) {
            this.evals.add(new Evaluator.IsRoot());
        } else if (this.f10715tq.matchChomp(":matchText")) {
            this.evals.add(new Evaluator.MatchText());
        } else {
            throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", this.query, this.f10715tq.remainder());
        }
    }

    private void byId() {
        String consumeCssIdentifier = this.f10715tq.consumeCssIdentifier();
        Validate.notEmpty(consumeCssIdentifier);
        this.evals.add(new Evaluator.C5493Id(consumeCssIdentifier));
    }

    private void byClass() {
        String consumeCssIdentifier = this.f10715tq.consumeCssIdentifier();
        Validate.notEmpty(consumeCssIdentifier);
        this.evals.add(new Evaluator.Class(consumeCssIdentifier.trim()));
    }

    private void byTag() {
        String normalize = Normalizer.normalize(this.f10715tq.consumeElementSelector());
        Validate.notEmpty(normalize);
        if (normalize.startsWith("*|")) {
            this.evals.add(new CombiningEvaluator.C5492Or(new Evaluator.Tag(normalize.substring(2)), new Evaluator.TagEndsWith(normalize.replace("*|", ":"))));
            return;
        }
        if (normalize.contains("|")) {
            normalize = normalize.replace("|", ":");
        }
        this.evals.add(new Evaluator.Tag(normalize));
    }

    private void byAttribute() {
        TokenQueue tokenQueue = new TokenQueue(this.f10715tq.chompBalanced('[', ']'));
        String consumeToAny = tokenQueue.consumeToAny(AttributeEvals);
        Validate.notEmpty(consumeToAny);
        tokenQueue.consumeWhitespace();
        if (tokenQueue.isEmpty()) {
            if (consumeToAny.startsWith("^")) {
                this.evals.add(new Evaluator.AttributeStarting(consumeToAny.substring(1)));
            } else {
                this.evals.add(new Evaluator.Attribute(consumeToAny));
            }
        } else if (tokenQueue.matchChomp("=")) {
            this.evals.add(new Evaluator.AttributeWithValue(consumeToAny, tokenQueue.remainder()));
        } else if (tokenQueue.matchChomp("!=")) {
            this.evals.add(new Evaluator.AttributeWithValueNot(consumeToAny, tokenQueue.remainder()));
        } else if (tokenQueue.matchChomp("^=")) {
            this.evals.add(new Evaluator.AttributeWithValueStarting(consumeToAny, tokenQueue.remainder()));
        } else if (tokenQueue.matchChomp("$=")) {
            this.evals.add(new Evaluator.AttributeWithValueEnding(consumeToAny, tokenQueue.remainder()));
        } else if (tokenQueue.matchChomp("*=")) {
            this.evals.add(new Evaluator.AttributeWithValueContaining(consumeToAny, tokenQueue.remainder()));
        } else if (tokenQueue.matchChomp("~=")) {
            this.evals.add(new Evaluator.AttributeWithValueMatching(consumeToAny, Pattern.compile(tokenQueue.remainder())));
        } else {
            throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", this.query, tokenQueue.remainder());
        }
    }

    private void allElements() {
        this.evals.add(new Evaluator.AllElements());
    }

    private void indexLessThan() {
        this.evals.add(new Evaluator.IndexLessThan(consumeIndex()));
    }

    private void indexGreaterThan() {
        this.evals.add(new Evaluator.IndexGreaterThan(consumeIndex()));
    }

    private void indexEquals() {
        this.evals.add(new Evaluator.IndexEquals(consumeIndex()));
    }

    private void cssNthChild(boolean z, boolean z2) {
        String normalize = Normalizer.normalize(this.f10715tq.chompTo(")"));
        Matcher matcher = NTH_AB.matcher(normalize);
        Matcher matcher2 = NTH_B.matcher(normalize);
        int i = 2;
        if ("odd".equals(normalize)) {
            r5 = 1;
        } else if (!"even".equals(normalize)) {
            if (matcher.matches()) {
                int parseInt = matcher.group(3) != null ? Integer.parseInt(matcher.group(1).replaceFirst("^\\+", "")) : 1;
                r5 = matcher.group(4) != null ? Integer.parseInt(matcher.group(4).replaceFirst("^\\+", "")) : 0;
                i = parseInt;
            } else if (matcher2.matches()) {
                r5 = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
                i = 0;
            } else {
                throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", normalize);
            }
        }
        if (z2) {
            if (z) {
                this.evals.add(new Evaluator.IsNthLastOfType(i, r5));
            } else {
                this.evals.add(new Evaluator.IsNthOfType(i, r5));
            }
        } else if (z) {
            this.evals.add(new Evaluator.IsNthLastChild(i, r5));
        } else {
            this.evals.add(new Evaluator.IsNthChild(i, r5));
        }
    }

    private int consumeIndex() {
        String trim = this.f10715tq.chompTo(")").trim();
        Validate.isTrue(StringUtil.isNumeric(trim), "Index must be numeric");
        return Integer.parseInt(trim);
    }

    private void has() {
        this.f10715tq.consume(":has");
        String chompBalanced = this.f10715tq.chompBalanced('(', ')');
        Validate.notEmpty(chompBalanced, ":has(selector) subselect must not be empty");
        this.evals.add(new StructuralEvaluator.Has(parse(chompBalanced)));
    }

    private void contains(boolean z) {
        this.f10715tq.consume(z ? ":containsOwn" : ":contains");
        String unescape = TokenQueue.unescape(this.f10715tq.chompBalanced('(', ')'));
        Validate.notEmpty(unescape, ":contains(text) query must not be empty");
        if (z) {
            this.evals.add(new Evaluator.ContainsOwnText(unescape));
        } else {
            this.evals.add(new Evaluator.ContainsText(unescape));
        }
    }

    private void containsData() {
        this.f10715tq.consume(":containsData");
        String unescape = TokenQueue.unescape(this.f10715tq.chompBalanced('(', ')'));
        Validate.notEmpty(unescape, ":containsData(text) query must not be empty");
        this.evals.add(new Evaluator.ContainsData(unescape));
    }

    private void matches(boolean z) {
        this.f10715tq.consume(z ? ":matchesOwn" : ":matches");
        String chompBalanced = this.f10715tq.chompBalanced('(', ')');
        Validate.notEmpty(chompBalanced, ":matches(regex) query must not be empty");
        if (z) {
            this.evals.add(new Evaluator.MatchesOwn(Pattern.compile(chompBalanced)));
        } else {
            this.evals.add(new Evaluator.Matches(Pattern.compile(chompBalanced)));
        }
    }

    private void not() {
        this.f10715tq.consume(":not");
        String chompBalanced = this.f10715tq.chompBalanced('(', ')');
        Validate.notEmpty(chompBalanced, ":not(selector) subselect must not be empty");
        this.evals.add(new StructuralEvaluator.Not(parse(chompBalanced)));
    }

    public String toString() {
        return this.query;
    }
}
