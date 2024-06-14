package Insurance;

import java.util.StringTokenizer;

public class Insurance {

    private String name;
    private String description;
    private String premium;
    private String coverage;
    private String term;
    private String maxAge;
    private String exclusions;
    
    public Insurance(String inputString) {
        StringTokenizer tokenizer = new StringTokenizer(inputString, "\n");
        this.name = tokenizer.nextToken().trim();
        this.description = tokenizer.nextToken().trim();
        this.premium = tokenizer.nextToken().trim();
        this.coverage = tokenizer.nextToken().trim();
        this.term = tokenizer.nextToken().trim();
        this.maxAge = tokenizer.nextToken().trim();
        this.exclusions = tokenizer.nextToken().trim();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPremium() {
        return premium;
    }

    public String getCoverage() {
        return coverage;
    }

    public String getTerm() {
        return term;
    }

    public String getMaxAge() {
        return maxAge;
    }

    public String getExclusions() {
        return exclusions;
    }
}
