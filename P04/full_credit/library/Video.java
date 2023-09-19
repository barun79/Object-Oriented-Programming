package library;

import java.time.Duration;


public class Video extends Publication{
/**
 * Represents a video publication in the library.
 */
    private Duration runtime;
/**
     * Constructs a Video object with the specified title, author, copyright year, and runtime.
     *
     * @param title     The title of the video.
     * @param author    The author of the video.
     * @param copyright The copyright year of the video.
     * @param runtime   The runtime of the video in minutes.
     * @throws InvalidRuntimeException if the runtime is less than or equal to 0.
     */
    public Video(String title, String author, int copyright, int runtime ){
        super(title, author, copyright);
        if(runtime <= 0){
            throw new InvalidRuntimeException(title, runtime);
        }
        this.runtime = Duration.ofMinutes(runtime) ;
    }

    /**
     * Returns a string representation of the video.
     *
     * @return A string containing the title, author, and runtime.
     */
    @Override
    public String toString() {
        String pre = "Video";
        long minutes = runtime.toMinutes();
        String mid = minutes + " minutes";
        
        String publicationInfo = super.toStringBuilder(pre, mid);

        return publicationInfo;
    }

}