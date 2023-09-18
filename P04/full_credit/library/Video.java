package library;

import java.time.Duration;

public class Video extends Publication{

    private Duration runtime;

    public Video(String title, String author, int copyright, int runtime ){
        super(title, author, copyright);
        this.runtime = Duration.ofMinutes(runtime) ;
    }

    @Override
    public String toString() {
        String pre = "Video";
        long minutes = runtime.toMinutes();
        String mid = minutes + " minutes";
        
        // Call the toStringBuilder method from the superclass
        String publicationInfo = super.toStringBuilder(pre, mid);

        return publicationInfo;
    }

}