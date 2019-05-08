package sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Searcher {
    private String stringToSearch;
    private String stringToFind;
    private Matcher matcher;
    private Pattern pattern;

    public Searcher(String stringToFind, String stringToSearch) {
        this.stringToFind = stringToFind;
        this.stringToSearch = stringToSearch;
        this.pattern = Pattern.compile(stringToFind);
        this.matcher = pattern.matcher(stringToSearch);
    }

    public String getStringToSearch() {
        return stringToSearch;
    }

    public void setStringToSearch(String stringToSearch) {
        this.stringToSearch = stringToSearch;
    }

    public String getStringToFind() {
        return stringToFind;
    }

    public void setStringToFind(String stringToFind) {
        this.stringToFind = stringToFind;
    }

    public Matcher getMatcher() {
        return matcher;
    }

    public void setMatcher(Matcher matcher) {
        this.matcher = matcher;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }
}
